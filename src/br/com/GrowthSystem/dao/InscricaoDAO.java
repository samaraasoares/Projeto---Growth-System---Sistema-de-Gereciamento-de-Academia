package br.com.GrowthSystem.dao;

import br.com.GrowthSystem.model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InscricaoDAO {
    public void inserir(Inscricao i) {
        String sql = "INSERT INTO inscricao (codigo, aluno_codigo, aula_codigo, data_inscricao) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexaoBD.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, i.getId());
            stmt.setInt(2, i.getAluno().getId());
            stmt.setInt(3, i.getAula().getId());
            stmt.setString(4, i.getDataInscricao());
            stmt.executeUpdate();
        } catch (SQLException e) { System.err.println("Erro ao matricular: " + e.getMessage()); }
    }

    public int contarPorAula(int aulaId) {
        String sql = "SELECT COUNT(*) FROM inscricao WHERE aula_codigo = ?";
        try (Connection conn = ConexaoBD.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, aulaId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return rs.getInt(1);
        } catch (SQLException e) { e.printStackTrace(); }
        return 0;
    }

    public List<Inscricao> listarTodas() {
        List<Inscricao> lista = new ArrayList<>();
        String sql = "SELECT i.*, al.nome as al_nome, al.cpf as al_cpf, au.modalidade, au.horario, au.capacidade_max " +
                "FROM inscricao i " +
                "JOIN aluno al ON i.aluno_codigo = al.codigo " +
                "JOIN aula au ON i.aula_codigo = au.codigo";
        try (Connection conn = ConexaoBD.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Aluno al = new Aluno(rs.getInt("aluno_codigo"), rs.getString("al_nome"), rs.getString("al_cpf"));
                Aula au = new Aula(rs.getInt("aula_codigo"), rs.getString("modalidade"), rs.getString("horario"), rs.getInt("capacidade_max"));
                lista.add(new Inscricao(rs.getInt("codigo"), al, au, rs.getString("data_inscricao")));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return lista;
    }

    public void excluir(int id) {
        String sql = "DELETE FROM inscricao WHERE codigo = ?";
        try (Connection conn = ConexaoBD.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
}