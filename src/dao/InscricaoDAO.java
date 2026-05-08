package dao;

import model.Inscricao;
import java.sql.*;

public class InscricaoDAO {
    public void inserir(Inscricao inscricao) {
        String sql = "INSERT INTO inscricao (codigo, aluno_codigo, aula_codigo, data_inscricao) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexaoBD.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, inscricao.getId());
            // Uso real dos métodos getAluno() e getAula() que estavam sem uso
            stmt.setInt(2, inscricao.getAluno().getId());
            stmt.setInt(3, inscricao.getAula().getId());
            stmt.setString(4, inscricao.getDataInscricao()); // Assumindo que você criou o getDataInscricao() na classe Inscricao
            stmt.executeUpdate();
            System.out.println("✅ Inscrição realizada com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao realizar inscrição. Verifique se o ID do Aluno e da Aula existem no banco: " + e.getMessage());
        }
    }
}