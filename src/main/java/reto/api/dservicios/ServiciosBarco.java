/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto.api.dservicios;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reto.api.amodelos.Barco;
import reto.api.crepositorio.RepositorioBarco;

/**
 *
 * @author yg_cr
 */
@Service
public class ServiciosBarco {
    @Autowired
    private RepositorioBarco metodosCrud;
    
    public List<Barco> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Barco> getBarco(int barcoid) {
        return metodosCrud.getBarco(barcoid);
    }
    
    public Barco save(Barco barco){
        if(barco.getId()==null){
            return metodosCrud.save(barco);
        }else{
            Optional<Barco> data=metodosCrud.getBarco(barco.getId());
            if(data.isEmpty()){
                return metodosCrud.save(barco);
            }else{
                return barco;
            }
        }
    }
}
