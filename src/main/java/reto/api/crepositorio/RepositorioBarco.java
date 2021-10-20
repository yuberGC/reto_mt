/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto.api.crepositorio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reto.api.amodelos.Barco;
import reto.api.binterfaz.InterfazBarco;

/**
 *
 * @author yg_cr
 */
@Repository
public class RepositorioBarco {
    @Autowired
    private InterfazBarco crud;
    
    public List<Barco> getAll(){
        return (List<Barco>) crud.findAll();
    }
    
    public Optional<Barco> getBarco(int id){
        return crud.findById(id);
    }
    
    public Barco save(Barco barco){
        return crud.save(barco);
    }
    public void delete(Barco barco){
        crud.delete(barco);
    }
}
