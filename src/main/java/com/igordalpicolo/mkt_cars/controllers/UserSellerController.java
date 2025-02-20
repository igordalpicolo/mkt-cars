package com.igordalpicolo.mkt_cars.controllers;

import com.igordalpicolo.mkt_cars.dto.UserSellerDTO;
import com.igordalpicolo.mkt_cars.services.UserSellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/user/seller")
public class UserSellerController {

    @Autowired
    private UserSellerService userSellerService;

    @PostMapping
    public ResponseEntity<UserSellerDTO> createUserSeller(@RequestBody UserSellerDTO userSellerDTO) {
        userSellerDTO = userSellerService.create(userSellerDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userSellerDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(userSellerDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserSellerDTO> findUserSellerById(@PathVariable("id") Long id) {
        UserSellerDTO userSellerDTO = userSellerService.findById(id);
        return ResponseEntity.ok(userSellerDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUserSeller(@PathVariable Long id, @RequestBody UserSellerDTO userSellerDTO) {
        userSellerDTO = userSellerService.update(id, userSellerDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserSeller(@PathVariable Long id) {
        userSellerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
