package com.example.bloodbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.bloodbank.model.Donor;

@Repository
public interface DonorRepository extends JpaRepository<Donor, String> { }
