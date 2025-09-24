package com.example.bloodbank.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "donation_card")
public class DonationCard implements Serializable {
    @Id
    @Column(name = "card_id", length = 10)
    private String id;

    @ManyToOne
    @JoinColumn(name = "donor_id")
    private Donor donor;

    private String date; // keep as string to match original SQL; consider LocalDate for improvement

    public DonationCard() {}
    // getters/setters
    public String getId(){return id;}
    public void setId(String id){this.id=id;}
    public Donor getDonor(){return donor;}
    public void setDonor(Donor donor){this.donor=donor;}
    public String getDate(){return date;}
    public void setDate(String date){this.date=date;}
}
