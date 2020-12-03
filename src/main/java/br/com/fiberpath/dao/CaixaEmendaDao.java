package br.com.fiberpath.dao;

import br.com.fiberpath.core.Repositorio;
import br.com.fiberpath.model.CaixaEmenda;
import br.com.fiberpath.model.Usuario;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Landgraf
 */
public class CaixaEmendaDao extends Repositorio {
    
    private static final Logger logger = Logger.getLogger(CaixaEmendaDao.class.getName());
    
    private final StringBuilder sql;
    
    public CaixaEmendaDao(StringBuilder stringBuilder) {
        this.sql = stringBuilder;
    }
    
    public ResultSet retornaTodosCaixaEmenda() {
        sql.delete(0, sql.length());
        sql.append(" SELECT ID, NOME, SENHA FROM USUARIO ");
        return executaSQL(sql.toString());
    }
    
    public ResultSet retornaCaixaEmendaPorId(Long id) {
        sql.delete(0, sql.length());
        sql.append(" SELECT ID, NOME, SENHA FROM USUARIO WHERE ID = ").append(id);
        return executaSQL(sql.toString());
    }
    
    public void incluirUsuario(CaixaEmenda caixaEmenda) {
        try {
            sql.delete(0, sql.length());
            sql.append(" INSERT INTO USUARIO(NOME, SENHA) ");
            sql.append(" VALUES('").append(usuario.getNome()).append("',");
            sql.append(" '").append(caixaEmenda.getPoste().getId()).append("') ");
            executaUpdate(sql.toString());
            commit();
            logger.log(Level.INFO, "Usuário incluído com sucesso!");
        } catch(RepositorioException ex) {
            rollback();
            logger.log(Level.WARNING, "Falha ao incluir usuário!");
        }
    }
    
}
