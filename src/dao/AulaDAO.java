package dao;

import model.Aula;
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
            System.out.println("✅ Aula registrada no banco!");
        } catch (SQLException e) {
            System.err.println("Erro ao inserir aula: " + e.getMessage());
        }
    }

    public Aula buscarPorId(int id) {
        String sql = "SELECT * FROM aula WHERE codigo = ?";
        try (Connection conn = ConexaoBD.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Aula(rs.getInt("codigo"), rs.getString("modalidade"),
                        rs.getString("horario"), rs.getInt("capacidade_max"));
            }
        } catch (SQLException e) {
            System.err.println("Erro: " + e.getMessage());
        }
        return null;
    }

    public List<Aula> listarTodos() {
        List<Aula> lista = new ArrayList<>();
        String sql = "SELECT * FROM aula";
        try (Connection conn = ConexaoBD.conectar(); PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                lista.add(new Aula(rs.getInt("codigo"), rs.getString("modalidade"),
                        rs.getString("horario"), rs.getInt("capacidade_max")));
            }
        } catch (SQLException e) {
            System.err.println("Erro: " + e.getMessage());
        }
        return lista;
    }
}