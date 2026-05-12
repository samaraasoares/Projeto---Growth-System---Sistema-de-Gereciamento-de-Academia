package br.com.GrowthSystem.dao;
import java.sql.*;

public class ConexaoBD {
    private static final String URL = "jdbc:postgresql://localhost:5432/growth_system";
    private static final String USER = "postgres";
    private static final String PASS = "root";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}