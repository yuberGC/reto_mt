/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto.api.amodelos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author yg_cr
 */
@Entity
@Table(name = "boat")
public class Barco{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column(length = 45)
    private String name;
    @Column(length = 45)
    private String brand;
    @Column(length = 4)
    private Integer year;
    @Column(length = 250)
    private String description; 
    
    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("boats")
    private Categoria category;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "boat")
    @JsonIgnoreProperties({"boat", "client"})
    private List<Mensaje> messages;
     
    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "boat")
    @JsonIgnoreProperties({"boat", "client"})
    private List<Reservaciones> reservations;
    
    /*-----get--------
    
    */
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public Integer getYear() {
        return year;
    }

    public String getDescription() {
        return description;
    }

    public Categoria getCategory() {
        return category;
    }

    public List<Mensaje> getMessages() {
        return messages;
    }

    public List<Reservaciones> getReservations() {
        return reservations;
    }
    
    /*
    -------set---------
    */
    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(Categoria category) {
        this.category = category;
    }

    public void setMessages(List<Mensaje> messages) {
        this.messages = messages;
    }

    public void setReservations(List<Reservaciones> reservations) {
        this.reservations = reservations;
    }
}
