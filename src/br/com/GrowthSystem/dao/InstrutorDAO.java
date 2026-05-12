package br.com.GrowthSystem.dao;

import br.com.GrowthSystem.model.Instrutor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InstrutorDAO {
    public void inserir(Instrutor instrutor) {
        String sql = "INSERT INTO instrutor (codigo, nome, cpf, especialidade) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexaoBD.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, instrutor.getId());
            stmt.setString(2, instrutor.getNome());
            stmt.setString(3, instrutor.getCpf());
            stmt.setString(4, instrutor.getEspecialidade());
            stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public Instrutor buscarPorId(int id) {
        String sql = "SELECT * FROM instrutor WHERE codigo = ?";
        try (Connection conn = ConexaoBD.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return new Instrutor(rs.getInt("codigo"), rs.getString("nome"), rs.getString("cpf"), rs.getString("especialidade"));
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }

    public List<Instrutor> listarTodos() {
        List<Instrutor> lista = new ArrayList<>();
        String sql = "SELECT * FROM instrutor";
        try (Connection conn = ConexaoBD.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) lista.add(new Instrutor(rs.getInt("codigo"), rs.getString("nome"), rs.getString("cpf"), rs.getString("especialidade")));
        } catch (SQLException e) { e.printStackTrace(); }
        return lista;
    }

    public void atualizar(Instrutor instrutor) {
        String sql = "UPDATE instrutor SET nome = ?, cpf = ?, especialidade = ? WHERE codigo = ?";
        try (Connection conn = ConexaoBD.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, instrutor.getNome());
            stmt.setString(2, instrutor.getCpf());
            stmt.setString(3, instrutor.getEspecialidade());
            stmt.setInt(4, instrutor.getId());
            stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM instrutor WHERE codigo = ?";
        try (Connection conn = ConexaoBD.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
}