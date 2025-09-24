package com.example.bloodbank.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "recipient")
public class Recipient implements Serializable {
    @Id
    @Column(name = "recipient_id", length = 10)
    private String id;

    private String name;
    private String phone;

    public Recipient() {}
    // getters/setters
    public String getId(){return id;}
    public void setId(String id){this.id=id;}
    public String getName(){return name;}
    public void setName(String name){this.name=name;}
    public String getPhone(){return phone;}
    public void setPhone(String phone){this.phone=phone;}
}
