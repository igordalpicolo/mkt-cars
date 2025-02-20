package com.igordalpicolo.mkt_cars.controllers;

import com.igordalpicolo.mkt_cars.dto.UserBuyerDTO;
import com.igordalpicolo.mkt_cars.services.UserBuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/user/buyer")
public class UserBuyerController {

    @Autowired
    private UserBuyerService userBuyerService;

    @GetMapping("/{id}")
    public ResponseEntity<UserBuyerDTO> findUserBuyerById(@PathVariable Long id) {
        UserBuyerDTO userBuyerDTO = userBuyerService.findById(id);
        return ResponseEntity.ok(userBuyerDTO);
    }

    @PostMapping
    public ResponseEntity<UserBuyerDTO> createUserBuyer(@RequestBody UserBuyerDTO userBuyerDTO) {
        userBuyerDTO = userBuyerService.create(userBuyerDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userBuyerDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(userBuyerDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserBuyerDTO> updateUserBuyer(@PathVariable Long id, @RequestBody UserBuyerDTO userBuyerDTO) {
        userBuyerDTO = userBuyerService.update(id, userBuyerDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserBuyer(@PathVariable Long id) {
        userBuyerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
