package com.example.bloodbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.bloodbank.model.RecipientTransaction;

@Repository
public interface RecipientTransactionRepository extends JpaRepository<RecipientTransaction, String> { }
