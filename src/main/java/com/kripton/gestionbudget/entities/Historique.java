package com.kripton.gestionbudget.entities;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "historique")
public class Historique implements Serializable {
    private static final long serialVersionUID = 1627384312231736921L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_historique;
    private Date timestamp;
    private String action;
    private String user;

    public Historique() {
        super();
    }

    public Historique(Date timestamp, String action, String user) {
        super();
        this.timestamp = timestamp;
        this.action = action;
        this.user = user;
    }


    public Long getId_historique() {
        return id_historique;
    }

    public void setId_historique(Long id_historique) {
        this.id_historique = id_historique;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
