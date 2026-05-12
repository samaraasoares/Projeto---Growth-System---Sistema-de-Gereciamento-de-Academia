package br.com.GrowthSystem.dao;

import br.com.GrowthSystem.model.Aula;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AulaDAO {
    public void inserir(Aula aula) {
        String sql = "INSERT INTO aula (codigo, modalidade, horario, capacidade_max) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexaoBD.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, aula.getId());
            stmt.setString(2, aula.getModalidade());
            stmt.setString(3, aula.getHorario());
            stmt.setInt(4, aula.getCapacidadeMax());
            stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public Aula buscarPorId(int id) {
        String sql = "SELECT * FROM aula WHERE codigo = ?";
        try (Connection conn = ConexaoBD.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return new Aula(rs.getInt("codigo"), rs.getString("modalidade"), rs.getString("horario"), rs.getInt("capacidade_max"));
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }

    public List<Aula> listarTodos() {
        List<Aula> lista = new ArrayList<>();
        String sql = "SELECT * FROM aula";
        try (Connection conn = ConexaoBD.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) lista.add(new Aula(rs.getInt("codigo"), rs.getString("modalidade"), rs.getString("horario"), rs.getInt("capacidade_max")));
        } catch (SQLException e) { e.printStackTrace(); }
        return lista;
    }

    public void atualizar(Aula aula) {
        String sql = "UPDATE aula SET modalidade = ?, horario = ?, capacidade_max = ? WHERE codigo = ?";
        try (Connection conn = ConexaoBD.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, aula.getModalidade());
            stmt.setString(2, aula.getHorario());
            stmt.setInt(3, aula.getCapacidadeMax());
            stmt.setInt(4, aula.getId());
            stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM aula WHERE codigo = ?";
        try (Connection conn = ConexaoBD.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
}