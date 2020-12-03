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
public class Poste {
    
    private Long id;
    private String nome;
    private String numero;
    private String rua;    
}
