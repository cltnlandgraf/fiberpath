package br.com.fiberpath.teste;

import br.com.fiberpath.dao.UsuarioDao;
import br.com.fiberpath.model.Usuario;

/**
 *
 * @author Landgraf
 */
public class Teste {
    
    public static void main(String[] args) {
        Usuario usuario = new Usuario(null, "robson", "123");
        UsuarioDao usuarioDao = new UsuarioDao(new StringBuilder());
        
        usuarioDao.incluirUsuario(usuario);
    }
    
}
