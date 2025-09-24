package com.example.bloodbank.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "hospital")
public class Hospital implements Serializable {
    @Id
    @Column(name = "hospital_id", length = 10)
    private String id;

    @Column(nullable = false)
    private String name;

    private String address;

    public Hospital() {}
    // getters and setters
    public String getId(){return id;}
    public void setId(String id){this.id=id;}
    public String getName(){return name;}
    public void setName(String name){this.name=name;}
    public String getAddress(){return address;}
    public void setAddress(String address){this.address=address;}
}
