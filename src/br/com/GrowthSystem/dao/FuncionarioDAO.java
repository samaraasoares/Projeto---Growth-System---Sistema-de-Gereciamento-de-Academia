package br.com.GrowthSystem.dao;

import br.com.GrowthSystem.model.Funcionario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {
    public void inserir(Funcionario f) {
        String sql = "INSERT INTO funcionario (codigo, nome, cpf, departamento) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexaoBD.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, f.getId());
            stmt.setString(2, f.getNome());
            stmt.setString(3, f.getCpf());
            stmt.setString(4, f.getDepartamento());
            stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public Funcionario buscarPorId(int id) {
        String sql = "SELECT * FROM funcionario WHERE codigo = ?";
        try (Connection conn = ConexaoBD.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return new Funcionario(rs.getInt("codigo"), rs.getString("nome"), rs.getString("cpf"), rs.getString("departamento"));
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }

    public List<Funcionario> listarTodos() {
        List<Funcionario> lista = new ArrayList<>();
        String sql = "SELECT * FROM funcionario";
        try (Connection conn = ConexaoBD.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) lista.add(new Funcionario(rs.getInt("codigo"), rs.getString("nome"), rs.getString("cpf"), rs.getString("departamento")));
        } catch (SQLException e) { e.printStackTrace(); }
        return lista;
    }

    public void atualizar(Funcionario f) {
        String sql = "UPDATE funcionario SET nome = ?, cpf = ?, departamento = ? WHERE codigo = ?";
        try (Connection conn = ConexaoBD.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getCpf());
            stmt.setString(3, f.getDepartamento());
            stmt.setInt(4, f.getId());
            stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM funcionario WHERE codigo = ?";
        try (Connection conn = ConexaoBD.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
}