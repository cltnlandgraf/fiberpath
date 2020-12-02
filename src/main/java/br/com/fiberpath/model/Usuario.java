package br.com.fiberpath.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Landgraf
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    
    private Long id;
    private String nome;
    private String senha;    
    
}
