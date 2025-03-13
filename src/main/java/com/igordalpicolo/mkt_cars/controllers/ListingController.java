package com.igordalpicolo.mkt_cars.controllers;

import com.igordalpicolo.mkt_cars.dto.ListingDTO;
import com.igordalpicolo.mkt_cars.entities.Listing;
import com.igordalpicolo.mkt_cars.services.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/listing")
public class ListingController {

    @Autowired
    private ListingService listingService;

    @GetMapping
    public ResponseEntity<List<ListingDTO>> getAllListings() {
        List<ListingDTO> listings = listingService.getAllListings();
        return ResponseEntity.ok(listings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListingDTO> getListing(@PathVariable Long id) {
        ListingDTO listingDTO = listingService.findById(id);
        return ResponseEntity.ok(listingDTO);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteListing(@PathVariable Long id) {
        listingService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
