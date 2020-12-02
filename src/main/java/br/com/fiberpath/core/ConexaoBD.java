package br.com.fiberpath.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Landgraf
 */
public class ConexaoBD {    
    
    private static Connection connection;
    
    private ConexaoBD() {}
    
    public static Connection pegaConexao() {
        return conectarComBD();
    }
    
    public static void fechaConexao() {
        try {
            connection.close();
        } catch(SQLException ex) {
            throw new IllegalStateException("Falha ao tentar fechar a conexão com o banco de dados!", ex);
        }
    }
    
    private static Connection conectarComBD() {
        if (connection != null) {
            return connection;
        }
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fiberpath?serverTimezone=UTC&useSSL=false", "root", "29101988GD");
            connection.setAutoCommit(false);
            Logger.getLogger(ConexaoBD.class.getName()).log(Level.INFO, "Conexão com o banco de dados realizada com sucesso!");
        } catch (ClassNotFoundException ex) {            
            throw new IllegalStateException("Diver de conexão com o MySQL não foi localizado, verifique as dependências do projeto!", ex);
        } catch (SQLException ex) {            
            throw new IllegalStateException("Falha de conexão com o banco de dados, verifique URL, usuário e senha!", ex);
        }
        
        return connection;
    }        
    
}
