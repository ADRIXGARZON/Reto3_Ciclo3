package com.example.reto_3.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "category")
    @JsonIgnoreProperties("category")
    private List<Bike> bikes;

    public Integer getIdCategory() {
        return id;
    }
    public void setIdCategory(Integer idCategory) {
        this.id = idCategory;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public List<Bike> getBikes() {
        return bikes;
    }
    public void setBikes(List<Bike> bikes) {this.bikes = bikes;}

}

