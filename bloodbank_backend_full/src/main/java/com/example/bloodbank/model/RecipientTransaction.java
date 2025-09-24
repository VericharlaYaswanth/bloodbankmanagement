package com.example.bloodbank.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "recipient_transactions")
public class RecipientTransaction implements Serializable {
    @Id
    @Column(name = "recipient_trans_id", length = 10)
    private String id;

    @ManyToOne
    @JoinColumn(name = "recipient_id")
    private Recipient recipient;

    @Column(name = "recipient_request")
    private String recipientRequest;

    private String date;

    @ManyToOne
    @JoinColumn(name = "donor_card_id")
    private DonationCard donorCard;

    @ManyToOne
    @JoinColumn(name = "blood_type_id")
    private BloodType bloodType;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    public RecipientTransaction() {}
    // getters/setters
    public String getId(){return id;}
    public void setId(String id){this.id=id;}
    public Recipient getRecipient(){return recipient;}
    public void setRecipient(Recipient r){this.recipient=r;}
    public String getRecipientRequest(){return recipientRequest;}
    public void setRecipientRequest(String s){this.recipientRequest=s;}
    public String getDate(){return date;}
    public void setDate(String date){this.date=date;}
    public DonationCard getDonorCard(){return donorCard;}
    public void setDonorCard(DonationCard d){this.donorCard=d;}
    public BloodType getBloodType(){return bloodType;}
    public void setBloodType(BloodType b){this.bloodType=b;}
    public Hospital getHospital(){return hospital;}
    public void setHospital(Hospital h){this.hospital=h;}
}
