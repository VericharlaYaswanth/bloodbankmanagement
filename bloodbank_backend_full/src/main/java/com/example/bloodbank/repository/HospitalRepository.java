package com.example.bloodbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.bloodbank.model.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, String> { }
