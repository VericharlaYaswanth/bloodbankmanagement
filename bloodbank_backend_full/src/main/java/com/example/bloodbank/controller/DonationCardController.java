package com.example.bloodbank.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import java.util.List;
import com.example.bloodbank.model.DonationCard;
import com.example.bloodbank.repository.DonationCardRepository;

@RestController
@RequestMapping("/api/donationcards")
public class DonationCardController {
    @Autowired
    private DonationCardRepository repo;

    @GetMapping
    public List<DonationCard> all(){ return repo.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<DonationCard> get(@PathVariable String id){
        return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public DonationCard create(@RequestBody DonationCard d){ return repo.save(d); }

    @PutMapping("/{id}")
    public ResponseEntity<DonationCard> update(@PathVariable String id, @RequestBody DonationCard d){
        return repo.findById(id).map(ex->{ ex.setDate(d.getDate()); ex.setDonor(d.getDonor()); repo.save(ex); return ResponseEntity.ok(ex); }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        return repo.findById(id).map(ex->{ repo.delete(ex); return ResponseEntity.ok().<Void>build(); }).orElse(ResponseEntity.notFound().build());
    }
}
