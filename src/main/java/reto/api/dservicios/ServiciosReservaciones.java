/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto.api.dservicios;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reto.api.amodelos.Reservaciones;
import reto.api.crepositorio.Contador;
import reto.api.crepositorio.RepositorioReservaciones;
import reto.api.crepositorio.StatusReservas;

/**
 *
 * @author yg_cr
 */
@Service
public class ServiciosReservaciones implements Serializable{
     @Autowired
    private RepositorioReservaciones metodosCrud;

    public List<Reservaciones> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Reservaciones> getReservation(int reservacionId) {
        return metodosCrud.getReservacion(reservacionId);
    }

    public Reservaciones save(Reservaciones reservation){
        if(reservation.getIdReservation()==null){
            return metodosCrud.save(reservation);
        }else{
            Optional<Reservaciones> data= metodosCrud.getReservacion(reservation.getIdReservation());
            if(data.isEmpty()){
                return metodosCrud.save(reservation);
            }else{
                return reservation;
            }
        }
    }  
    
    public Reservaciones update(Reservaciones reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservaciones> datos= metodosCrud.getReservacion(reservation.getIdReservation());
            if(!datos.isEmpty()){

                if(reservation.getStartDate()!=null){
                    datos.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    datos.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    datos.get().setStatus(reservation.getStatus());
                }
                metodosCrud.save(datos.get());
                return datos.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }

    public boolean delete(int reservacionId) {
        Boolean aBoolean = getReservation(reservacionId).map(reservacion -> {
            metodosCrud.delete(reservacion);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    public StatusReservas reporteStatusServicio (){
	        List<Reservaciones>completed= metodosCrud.RepositorioStatus("completed");
	        List<Reservaciones>cancelled= metodosCrud.RepositorioStatus("cancelled");
	        
	        return new StatusReservas(completed.size(), cancelled.size() );
	    }
    
    public List<Reservaciones> reporteTiempoServicio (String datoA, String datoB){
	        SimpleDateFormat parser = new SimpleDateFormat ("yyyy-MM-dd");
	        
	        Date datoUno = new Date();
	        Date datoDos = new Date();
	        
	        try{
	             datoUno = parser.parse(datoA);
	             datoDos = parser.parse(datoB);
	        }catch(ParseException evt){
	            evt.printStackTrace();
	        }if(datoUno.before(datoDos)){
	            return metodosCrud.RepositorioTiempo(datoUno, datoDos);
	        }else{
	            return new ArrayList<>();
	        
	        } 
	    }
    
    public List<Contador> reporteClientesServicio(){
	            return metodosCrud.getClientesRepo();
	        }
}
