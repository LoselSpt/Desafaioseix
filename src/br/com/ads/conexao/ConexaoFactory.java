package br.com.ads.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
    
    // ATENÇÃO: Verifique a senha do seu banco de dados local
    private static final String URL = "jdbc:mysql://localhost:3306/estoque_ads";
    private static final String USER = "root"; 
    private static final String PASS = "123456"; // Em muitos XAMPP/WAMP a senha é vazia

    public static Connection getConnection() {
        try {
            // Tenta conectar
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            System.err.println("ERRO CRÍTICO: Não foi possível conectar ao banco.");
            System.err.println("Verifique se o MySQL está rodando e se o driver JDBC foi importado.");
            throw new RuntimeException("Erro de conexão", e);
        }
    }
}

