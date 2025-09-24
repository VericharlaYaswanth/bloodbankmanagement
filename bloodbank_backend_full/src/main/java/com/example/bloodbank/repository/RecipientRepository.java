package com.example.bloodbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.bloodbank.model.Recipient;

@Repository
public interface RecipientRepository extends JpaRepository<Recipient, String> { }
