package com.imc.imc_api.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "imc_record")
public class ImcCalculation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double poids;
    private double taille;
    private double imc;
    private String categorie;
    private LocalDate date = LocalDate.now();
    
    public double getPoids() {
        return this.poids;
    }
    public double getId() {
        return this.id;
    }
    public double getTaille() {
        return this.taille;
    }
    
    public String getCategorie() {
        return this.categorie;
    }
    public LocalDate getDate() {
        return this.date;
    }

    public double getImc() {
        return this.imc;
    }
    public void setImc(double d) {
        this.imc = d;
    }
    public void setCategorie(String categorie2) {
        categorie = categorie2;
    }
    public void setDate(LocalDate now) {
        this.date = now;
    }
    

}
