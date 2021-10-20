/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto.api.binterfaz;

import org.springframework.data.repository.CrudRepository;
import reto.api.amodelos.Categoria;

/**
 *
 * @author yg_cr
 */
public interface InterfazCategoria extends CrudRepository<Categoria,Integer> {
    
}
