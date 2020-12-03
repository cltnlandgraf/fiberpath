package br.com.fiberpath.dao;

import br.com.fiberpath.core.Repositorio;
import br.com.fiberpath.model.Poste;
import br.com.fiberpath.model.Usuario;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Landgraf
 */
public class PosteDao extends Repositorio {
    
    private static final Logger logger = Logger.getLogger(PosteDao.class.getName());
    
    private final StringBuilder sql;
    
    public PosteDao(StringBuilder stringBuilder) {
        this.sql = stringBuilder;
    }
    
    public ResultSet retornaTodosPoste() {
        sql.delete(0, sql.length());
        sql.append(" SELECT ID, NOME, NUMERO, RUA FROM POSTE ");
        return executaSQL(sql.toString());
    }
    
    public ResultSet retornaPostePorId(Long id) {
        sql.delete(0, sql.length());
        sql.append(" SELECT ID, NOME, NUMERO, RUA FROM POSTE WHERE ID = ").append(id);
        return executaSQL(sql.toString());
    }
    
    public void incluirPoste(Poste poste) {
        try {
            sql.delete(0, sql.length());
            sql.append(" INSERT INTO POSTE(NOME, NUMERO, RUA) ");
            sql.append(" VALUES('").append(poste.getNome()).append("',");
            sql.append(" '").append(poste.getNumero()).append("', ");
            sql.append(" '").append(poste.getRua()).append("') ");
            executaUpdate(sql.toString());
            commit();
            logger.log(Level.INFO, "Poste incluído com sucesso!");
        } catch(RepositorioException ex) {
            rollback();
            logger.log(Level.WARNING, "Falha ao incluir poste!");
        }
    }
    
}
