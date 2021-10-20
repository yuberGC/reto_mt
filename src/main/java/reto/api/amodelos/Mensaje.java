/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto.api.amodelos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author yg_cr
 */
@Entity
@Table(name = "message")
public class Mensaje implements Serializable {
      @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String messageText;
    
    @ManyToOne
    @JoinColumn(name="id")
    @JsonIgnoreProperties({"messages", "client", "reservations"})
    private Barco boat;

    @ManyToOne
    @JoinColumn(name="clientId")
    @JsonIgnoreProperties({"messages", "reservations", "client"})
    private Cliente client;
    
    
    /*
    -----------get-----------
    */

    public Integer getIdMessage() {
        return idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public Barco getBoat() {
        return boat;
    }

    public Cliente getClient() {
        return client;
    }
    
    /*
    ------------set---------
    */

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public void setBoat(Barco boat) {
        this.boat = boat;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }
    
    
}
