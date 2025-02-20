package com.igordalpicolo.mkt_cars.services;

import com.igordalpicolo.mkt_cars.dto.UserSellerDTO;
import com.igordalpicolo.mkt_cars.entities.UserSeller;
import com.igordalpicolo.mkt_cars.exceptions.ResourceNotFoundException;
import com.igordalpicolo.mkt_cars.repositories.UserSellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserSellerService {

    @Autowired
    private UserSellerRepository userSellerRepository;

    public UserSellerDTO create(UserSellerDTO userSellerDTO) {
        UserSeller userSeller = new UserSeller();
        userSeller.setName(userSellerDTO.getName());
        userSeller.setEmail(userSellerDTO.getEmail());
        userSeller.setPassword(userSellerDTO.getPassword());
        userSeller.setAddress(userSellerDTO.getAddress());
        userSeller.setPhone(userSellerDTO.getPhone());
        userSellerRepository.save(userSeller);
        return new UserSellerDTO(userSeller);
    }

    public UserSellerDTO findById(Long id) {
        if (!userSellerRepository.existsById(id)) {
            throw new ResourceNotFoundException(id);
        }
        return new UserSellerDTO(userSellerRepository.findById(id).get());
    }

    public List<UserSellerDTO> findAll() {
        List<UserSeller> userSellers = userSellerRepository.findAll();
        List<UserSellerDTO> userSellerDTOs = new ArrayList<>();
        for (UserSeller userSeller : userSellers) {
            userSellerDTOs.add(new UserSellerDTO(userSeller));
        }
        return userSellerDTOs;
    }

    public void deleteById(Long id) {
        if (!userSellerRepository.existsById(id)) {
            throw new ResourceNotFoundException(id);
        }
        userSellerRepository.deleteById(id);
    }

    public UserSellerDTO update(Long id, UserSellerDTO userSellerDTO) {
        UserSeller userSeller = userSellerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        updateData(userSeller, userSellerDTO);
        userSellerRepository.save(userSeller);
        return new UserSellerDTO(userSeller);
    }

    private void updateData(UserSeller entity, UserSellerDTO dto) {
        if (dto.getName() != null) { entity.setName(dto.getName()); }
        if (dto.getEmail() != null) { entity.setEmail(dto.getEmail()); }
        if (dto.getAddress() != null) { entity.setAddress(dto.getAddress()); }
        if (dto.getPhone() != null) { entity.setPhone(dto.getPhone()); }
    }
}
