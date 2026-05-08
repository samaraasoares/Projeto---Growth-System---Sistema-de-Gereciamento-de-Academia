package dao;

import model.Funcionario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    public void inserir(Funcionario f) {
        String sql = "INSERT INTO funcionario (codigo, nome, cpf, departamento) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, f.getId());
            stmt.setString(2, f.getNome());
            stmt.setString(3, f.getCpf());
            stmt.setString(4, f.getDepartamento());
            stmt.executeUpdate();
            System.out.println("✅ Funcionário salvo no banco!");
        } catch (SQLException e) {
            System.err.println("Erro ao inserir: " + e.getMessage());
        }
    }

    public List<Funcionario> listarTodos() {
        List<Funcionario> lista = new ArrayList<>();
        String sql = "SELECT * FROM funcionario";
        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                lista.add(new Funcionario(rs.getInt("codigo"), rs.getString("nome"),
                        rs.getString("cpf"), rs.getString("departamento")));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar: " + e.getMessage());
        }
        return lista;
    }

    // --- NOVOS MÉTODOS ADICIONADOS ---

    public Funcionario buscarPorId(int id) {
        String sql = "SELECT * FROM funcionario WHERE codigo = ?";
        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Funcionario(
                        rs.getInt("codigo"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("departamento")
                );
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar funcionário: " + e.getMessage());
        }
        return null;
    }

    public void atualizar(Funcionario f) {
        String sql = "UPDATE funcionario SET nome = ?, cpf = ?, departamento = ? WHERE codigo = ?";
        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getCpf());
            stmt.setString(3, f.getDepartamento());
            stmt.setInt(4, f.getId());

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Funcionário atualizado com sucesso!");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar: " + e.getMessage());
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM funcionario WHERE codigo = ?";
        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Funcionário excluído com sucesso!");
            } else {
                System.out.println("⚠️ Nenhum funcionário encontrado com esse ID.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao excluir: " + e.getMessage());
        }
    }
}