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
import reto.api.amodelos.Cliente;
import reto.api.crepositorio.RepositorioCliente;

/**
 *
 * @author yg_cr
 */
@Service
public class ServiciosCliente {
       @Autowired
     private RepositorioCliente metodosCrud;
     
     public List<Cliente> getAll(){
        return metodosCrud.getAll();
    }
     
      public Optional<Cliente> getClientes(int clientId) {
        return metodosCrud.getCliente(clientId);
    }

    public Cliente save(Cliente client){
        if(client.getIdClient()==null){
            return metodosCrud.save(client);
        }else{
            Optional<Cliente> data= metodosCrud.getCliente(client.getIdClient());
            if(data.isEmpty()){
                return metodosCrud.save(client);
            }else{
                return client;
            }
        }
    }   
}
