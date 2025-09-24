package com.example.bloodbank.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import java.util.List;
import com.example.bloodbank.model.Recipient;
import com.example.bloodbank.repository.RecipientRepository;

@RestController
@RequestMapping("/api/recipients")
public class RecipientController {
    @Autowired
    private RecipientRepository repo;

    @GetMapping
    public List<Recipient> all(){ return repo.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Recipient> get(@PathVariable String id){
        return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Recipient create(@RequestBody Recipient r){ return repo.save(r); }

    @PutMapping("/{id}")
    public ResponseEntity<Recipient> update(@PathVariable String id, @RequestBody Recipient r){
        return repo.findById(id).map(ex->{ ex.setName(r.getName()); ex.setPhone(r.getPhone()); repo.save(ex); return ResponseEntity.ok(ex); }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        return repo.findById(id).map(ex->{ repo.delete(ex); return ResponseEntity.ok().<Void>build(); }).orElse(ResponseEntity.notFound().build());
    }
}
