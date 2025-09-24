package com.example.bloodbank.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import java.util.List;
import com.example.bloodbank.model.Donor;
import com.example.bloodbank.repository.DonorRepository;

@RestController
@RequestMapping("/api/donors")
public class DonorController {
    @Autowired
    private DonorRepository repo;

    @GetMapping
    public List<Donor> all(){ return repo.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Donor> get(@PathVariable String id){
        return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Donor create(@RequestBody Donor d){ return repo.save(d); }

    @PutMapping("/{id}")
    public ResponseEntity<Donor> update(@PathVariable String id, @RequestBody Donor d){
        return repo.findById(id).map(ex->{ ex.setName(d.getName()); ex.setPhone(d.getPhone()); ex.setEmail(d.getEmail()); ex.setBloodType(d.getBloodType()); repo.save(ex); return ResponseEntity.ok(ex); }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        return repo.findById(id).map(ex->{ repo.delete(ex); return ResponseEntity.ok().<Void>build(); }).orElse(ResponseEntity.notFound().build());
    }
}
