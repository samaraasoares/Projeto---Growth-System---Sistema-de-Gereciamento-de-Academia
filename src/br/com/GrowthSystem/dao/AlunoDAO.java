package br.com.GrowthSystem.dao;

import br.com.GrowthSystem.model.Aluno;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
    public void inserir(Aluno aluno) {
        String sql = "INSERT INTO aluno (codigo, nome, cpf) VALUES (?, ?, ?)";
        try (Connection conn = ConexaoBD.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, aluno.getId());
            stmt.setString(2, aluno.getNome());
            stmt.setString(3, aluno.getCpf());
            stmt.executeUpdate();
        } catch (SQLException e) { System.err.println("Erro ao inserir: " + e.getMessage()); }
    }

    public Aluno buscarPorId(int id) {
        String sql = "SELECT * FROM aluno WHERE codigo = ?";
        try (Connection conn = ConexaoBD.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return new Aluno(rs.getInt("codigo"), rs.getString("nome"), rs.getString("cpf"));
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }

    public List<Aluno> listarTodos() {
        List<Aluno> lista = new ArrayList<>();
        String sql = "SELECT * FROM aluno";
        try (Connection conn = ConexaoBD.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) lista.add(new Aluno(rs.getInt("codigo"), rs.getString("nome"), rs.getString("cpf")));
        } catch (SQLException e) { e.printStackTrace(); }
        return lista;
    }

    public void atualizar(Aluno aluno) {
        String sql = "UPDATE aluno SET nome = ?, cpf = ? WHERE codigo = ?";
        try (Connection conn = ConexaoBD.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getCpf());
            stmt.setInt(3, aluno.getId());
            stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM aluno WHERE codigo = ?";
        try (Connection conn = ConexaoBD.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
}