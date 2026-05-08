package dao;

import model.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    // 1. INSERIR (C)
    public void inserir(Aluno aluno) {
        String sql = "INSERT INTO aluno (codigo, nome, cpf) VALUES (?, ?, ?)";

        // try-with-resources: fecha conn e stmt automaticamente
        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, aluno.getId());
            stmt.setString(2, aluno.getNome());
            stmt.setString(3, aluno.getCpf());

            stmt.executeUpdate();
            System.out.println("✅ Aluno salvo no banco de dados com sucesso!");
        } catch (SQLException e) {
            System.err.println("❌ Erro ao inserir aluno no BD: " + e.getMessage());
        }
    }

    // 2. BUSCAR POR ID (R)
    public Aluno buscarPorId(int id) {
        String sql = "SELECT * FROM aluno WHERE codigo = ?";
        Aluno aluno = null;

        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Monta o objeto Aluno com os dados do banco
                aluno = new Aluno(
                        rs.getInt("codigo"),
                        rs.getString("nome"),
                        rs.getString("cpf")
                );
            }
        } catch (SQLException e) {
            System.err.println("❌ Erro ao buscar aluno: " + e.getMessage());
        }
        return aluno;
    }

    // 3. LISTAR TODOS (R)
    public List<Aluno> listarTodos() {
        String sql = "SELECT * FROM aluno";
        List<Aluno> lista = new ArrayList<>();

        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Aluno aluno = new Aluno(
                        rs.getInt("codigo"),
                        rs.getString("nome"),
                        rs.getString("cpf")
                );
                lista.add(aluno);
            }
        } catch (SQLException e) {
            System.err.println("❌ Erro ao listar alunos: " + e.getMessage());
        }
        return lista;
    }

    // 4. ATUALIZAR (U)
    public void atualizar(Aluno aluno) {
        String sql = "UPDATE aluno SET nome = ?, cpf = ? WHERE codigo = ?";

        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getCpf());
            stmt.setInt(3, aluno.getId());

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("✅ Aluno atualizado com sucesso!");
            } else {
                System.out.println("⚠️ Aluno não encontrado para atualização.");
            }
        } catch (SQLException e) {
            System.err.println("❌ Erro ao atualizar aluno: " + e.getMessage());
        }
    }

    // 5. EXCLUIR (D)
    public void excluir(int id) {
        String sql = "DELETE FROM aluno WHERE codigo = ?";

        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("✅ Aluno excluído com sucesso!");
            } else {
                System.out.println("⚠️ Aluno não encontrado para exclusão.");
            }
        } catch (SQLException e) {
            System.err.println("❌ Erro ao excluir aluno: " + e.getMessage());
        }
    }
}