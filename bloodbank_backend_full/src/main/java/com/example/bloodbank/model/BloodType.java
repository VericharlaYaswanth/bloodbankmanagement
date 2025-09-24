package com.example.bloodbank.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "blood_type")
public class BloodType implements Serializable {
    @Id
    @Column(name = "blood_type_id", length = 10)
    private String id;

    @Column(nullable = false)
    private String name;

    public BloodType() {}

    public BloodType(String id, String name) { this.id = id; this.name = name; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
