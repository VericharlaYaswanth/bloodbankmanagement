package com.example.bloodbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.bloodbank.model.DonationCard;

@Repository
public interface DonationCardRepository extends JpaRepository<DonationCard, String> { }
