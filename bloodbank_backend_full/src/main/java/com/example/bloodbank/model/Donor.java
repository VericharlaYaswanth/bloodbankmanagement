package com.example.bloodbank.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "donor")
public class Donor implements Serializable {
    @Id
    @Column(name = "donor_id", length = 10)
    private String id;

    private String name;
    private String phone;
    private String email;

    @ManyToOne
    @JoinColumn(name = "blood_type_id")
    private BloodType bloodType;

    public Donor() {}
    // getters/setters
    public String getId(){return id;}
    public void setId(String id){this.id=id;}
    public String getName(){return name;}
    public void setName(String name){this.name=name;}
    public String getPhone(){return phone;}
    public void setPhone(String phone){this.phone=phone;}
    public String getEmail(){return email;}
    public void setEmail(String email){this.email=email;}
    public BloodType getBloodType(){return bloodType;}
    public void setBloodType(BloodType bloodType){this.bloodType=bloodType;}
}
