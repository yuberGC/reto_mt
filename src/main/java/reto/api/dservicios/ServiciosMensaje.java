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
import reto.api.amodelos.Mensaje;
import reto.api.crepositorio.RepositorioMensaje;

/**
 *
 * @author yg_cr
 */
@Service
public class ServiciosMensaje {
    @Autowired
    private RepositorioMensaje metodosCrud;

    public List<Mensaje> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Mensaje> getMessage(int messageId) {
        return metodosCrud.getMessage(messageId);
    }

    public Mensaje save(Mensaje message){
        if(message.getIdMessage()==null){
            return metodosCrud.save(message);
        }else{
            Optional<Mensaje> data= metodosCrud.getMessage(message.getIdMessage());
            if(data.isEmpty()){
                return metodosCrud.save(message);
            }else{
                return message;
            }
        }
    }

   public Mensaje update(Mensaje message){
        if(message.getIdMessage()!=null){
            Optional<Mensaje> datos= metodosCrud.getMessage(message.getIdMessage());
            if(!datos.isEmpty()){
                if(message.getMessageText()!=null){
                    datos.get().setMessageText(message.getMessageText());
                }
                metodosCrud.save(datos.get());
                return datos.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }

    public boolean deleteMessage(int messageId) {
        Boolean aBoolean = getMessage(messageId).map(mensaje -> {
            metodosCrud.delete(mensaje);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
