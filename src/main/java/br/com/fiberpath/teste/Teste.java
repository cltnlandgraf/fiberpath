package br.com.fiberpath.teste;

import br.com.fiberpath.dao.PosteDao;
import br.com.fiberpath.dao.UsuarioDao;
import br.com.fiberpath.model.Poste;
import br.com.fiberpath.model.Usuario;

/**
 *
 * @author Landgraf
 */
public class Teste {
    
    public static void main(String[] args) {
        Poste poste = new Poste(null, "poste 1", "10", "arthur bauer");
        PosteDao posteDao = new PosteDao(new StringBuilder());
        
        posteDao.incluirPoste(poste);
    }
    
}