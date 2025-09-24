package com.example.bloodbank.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import java.util.List;
import com.example.bloodbank.model.Hospital;
import com.example.bloodbank.repository.HospitalRepository;

@RestController
@RequestMapping("/api/hospitals")
public class HospitalController {
    @Autowired
    private HospitalRepository repo;

    @GetMapping
    public List<Hospital> all(){ return repo.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Hospital> get(@PathVariable String id){
        return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Hospital create(@RequestBody Hospital h){ return repo.save(h); }

    @PutMapping("/{id}")
    public ResponseEntity<Hospital> update(@PathVariable String id, @RequestBody Hospital h){
        return repo.findById(id).map(ex->{ ex.setName(h.getName()); ex.setAddress(h.getAddress()); repo.save(ex); return ResponseEntity.ok(ex); }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        return repo.findById(id).map(ex->{ repo.delete(ex); return ResponseEntity.ok().<Void>build(); }).orElse(ResponseEntity.notFound().build());
    }
}
