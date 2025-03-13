package com.igordalpicolo.mkt_cars.services;

import com.igordalpicolo.mkt_cars.dto.ListingDTO;
import com.igordalpicolo.mkt_cars.entities.Listing;
import com.igordalpicolo.mkt_cars.entities.UserSeller;
import com.igordalpicolo.mkt_cars.exceptions.ResourceNotFoundException;
import com.igordalpicolo.mkt_cars.repositories.ListingRepository;
import com.igordalpicolo.mkt_cars.repositories.UserSellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListingService {

    @Autowired
    private UserSellerRepository userSellerRepository;
    @Autowired
    private ListingRepository listingRepository;


    public ListingDTO createListing(Long id, ListingDTO listingDTO) {
        UserSeller userSeller = userSellerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        Listing listing = new Listing();
        listing.setId(listingDTO.getId());
        listing.setBrand(listingDTO.getBrand());
        listing.setDescription(listingDTO.getDescription());
        listing.setColor(listingDTO.getColor());
        listing.setPrice(listingDTO.getPrice());
        listing.setKilometers(listingDTO.getKilometers());
        listing.setYear(listingDTO.getYear());
        listing.setModel(listingDTO.getModel());
        listing.setUserSeller(userSeller);

        listingRepository.save(listing);
        return listingDTO;
    }

    public List<ListingDTO> getAllListings() {
        List<Listing> listings = listingRepository.findAll();
        return listings.stream().map(ListingDTO::new).collect(Collectors.toList());
    }

    public ListingDTO findById(Long id) {
        if(!listingRepository.existsById(id)) {
            throw new ResourceNotFoundException(id);
        }
        return new ListingDTO(listingRepository.findById(id).get());
    }

    public ListingDTO updateListing(Long id, ListingDTO listingDTO) {
        Listing listing = listingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

      updateData(listing, listingDTO);
      listingRepository.save(listing);
      return new ListingDTO(listing);
    }

    public void updateData(Listing entity, ListingDTO dto) {
        if (dto.getBrand() != null) { entity.setBrand(dto.getBrand()); }
        if (dto.getDescription() != null) { entity.setDescription(dto.getDescription()); }
        if (dto.getColor() != null) { entity.setColor(dto.getColor()); }
        if (dto.getPrice() != null) { entity.setPrice(dto.getPrice()); }
        if (dto.getYear() != null) { entity.setYear(dto.getYear()); }
        if (dto.getModel() != null) { entity.setModel(dto.getModel()); }
        if (dto.getKilometers() != null) { entity.setKilometers(dto.getKilometers()); }
    }

    public void deleteById(Long id) {
        if(!listingRepository.existsById(id)) {
            throw new ResourceNotFoundException(id);
        }
        listingRepository.deleteById(id);
    }

}
