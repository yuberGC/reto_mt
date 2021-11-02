/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto.api.crepositorio;

import reto.api.amodelos.Cliente;

/**
 *
 * @author yg_cr
 */
public class Contador {
    private Long total;
    private Cliente client;

    public Contador(Long total, Cliente client) {
        this.total = total;
        this.client = client;
    }
   
    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }
    
}
