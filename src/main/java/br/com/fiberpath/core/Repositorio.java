package br.com.fiberpath.core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Landgraf
 */
public abstract class Repositorio {
    
    private static Statement statement;
    
    public static ResultSet executaSQL(String sql) {
        try {
            statement = ConexaoBD.pegaConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            return statement.executeQuery(sql);
        } catch(SQLException ex) {
            throw new RepositorioException("Falha de execução em comando SQL! (SELECT)", ex);
        }
    }
    
    public static int executaUpdate(String sql) {
        try {
            statement = ConexaoBD.pegaConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            return statement.executeUpdate(sql);
        } catch(SQLException ex) {
            throw new RepositorioException("Falha de execução em comando SQL! (INSERT, UPDATE ou DELETE)", ex);
        }
    }
    
    public static void commit() {
        try {
            ConexaoBD.pegaConexao().commit();
        } catch(SQLException ex) {
            throw new RepositorioException("Falha ao realizar commit da transação!", ex);
        }
    }
    
    public static void rollback() {
        try {
            ConexaoBD.pegaConexao().rollback();
        } catch(SQLException ex) {
            throw new RepositorioException("Falha ao realizar rollback da transação!", ex);
        }
    }
    
    public static class RepositorioException extends RuntimeException {                
        private RepositorioException(String message, SQLException ex) {
            super(message, ex);
        }
    }
    
}
