/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto.api.econtrolador;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reto.api.amodelos.Barco;
import reto.api.dservicios.ServiciosBarco;

/**
 *
 * @author yg_cr
 */
@RestController
@RequestMapping("/api/Boat")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class ControladorBarco {
    @Autowired
    private ServiciosBarco servicio;
    
    @GetMapping("/all")
    public List<Barco> getBarco(){
        return servicio.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Barco> getOptional(@PathVariable("id") int barcoId) {
        return servicio.getBarco(barcoId);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Barco save(@RequestBody Barco barco) {
        return servicio.save(barco);
    }
}