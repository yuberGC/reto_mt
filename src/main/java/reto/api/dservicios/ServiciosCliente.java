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
        if(client.getIdCliente()==null){
            return metodosCrud.save(client);
        }else{
            Optional<Cliente> data= metodosCrud.getCliente(client.getIdCliente());
            if(data.isEmpty()){
                return metodosCrud.save(client);
            }else{
                return client;
            }
        }
    }
    
    public Cliente update(Cliente cliente){
        if(cliente.getIdCliente()!=null){
            Optional<Cliente> datos= metodosCrud.getCliente(cliente.getIdCliente());
            if(!datos.isEmpty()){
                if(cliente.getName()!=null){
                    datos.get().setName(cliente.getName());
                }
                if(cliente.getAge()!=null){
                    datos.get().setAge(cliente.getAge());
                }
                if(cliente.getPassword()!=null){
                    datos.get().setPassword(cliente.getPassword());
                }
                metodosCrud.save(datos.get());
                return datos.get();
            }else{
                return cliente;
            }
        }else{
            return cliente;
        }
    }

    public boolean deleteClient(int clienteId) {
        Boolean aBoolean = getClientes(clienteId).map(cliente -> {
            metodosCrud.delete(cliente);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
