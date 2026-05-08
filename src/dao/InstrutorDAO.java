package dao;

import model.Instrutor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InstrutorDAO {

    // 1. INSERIR
    public void inserir(Instrutor instrutor) {
        String sql = "INSERT INTO instrutor (codigo, nome, cpf, especialidade) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, instrutor.getId());
            stmt.setString(2, instrutor.getNome());
            stmt.setString(3, instrutor.getCpf());
            // Aqui assumimos que você vai criar/tem o método getEspecialidade() na classe Instrutor
            // Se não tiver, você precisará adicioná-lo lá.
            stmt.setString(4, instrutor.getEspecialidade());

            stmt.executeUpdate();
            System.out.println("✅ Instrutor salvo no banco de dados!");
        } catch (SQLException e) {
            System.err.println("❌ Erro ao inserir instrutor: " + e.getMessage());
        }
    }

    // 2. BUSCAR POR ID
    public Instrutor buscarPorId(int id) {
        String sql = "SELECT * FROM instrutor WHERE codigo = ?";
        Instrutor instrutor = null;

        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                instrutor = new Instrutor(
                        rs.getInt("codigo"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("especialidade")
                );
            }
        } catch (SQLException e) {
            System.err.println("❌ Erro ao buscar instrutor: " + e.getMessage());
        }
        return instrutor;
    }

    // 3. LISTAR TODOS
    public List<Instrutor> listarTodos() {
        String sql = "SELECT * FROM instrutor";
        List<Instrutor> lista = new ArrayList<>();

        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Instrutor instrutor = new Instrutor(
                        rs.getInt("codigo"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("especialidade")
                );
                lista.add(instrutor);
            }
        } catch (SQLException e) {
            System.err.println("❌ Erro ao listar instrutores: " + e.getMessage());
        }
        return lista;
    }

    // 4. ATUALIZAR
    public void atualizar(Instrutor instrutor) {
        String sql = "UPDATE instrutor SET nome = ?, cpf = ?, especialidade = ? WHERE codigo = ?";

        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, instrutor.getNome());
            stmt.setString(2, instrutor.getCpf());
            stmt.setString(3, instrutor.getEspecialidade());
            stmt.setInt(4, instrutor.getId());

            stmt.executeUpdate();
            System.out.println("✅ Instrutor atualizado com sucesso!");
        } catch (SQLException e) {
            System.err.println("❌ Erro ao atualizar instrutor: " + e.getMessage());
        }
    }

    // 5. EXCLUIR
    public void excluir(int id) {
        String sql = "DELETE FROM instrutor WHERE codigo = ?";

        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("✅ Instrutor excluído com sucesso!");
        } catch (SQLException e) {
            System.err.println("❌ Erro ao excluir instrutor: " + e.getMessage());
        }
    }
}