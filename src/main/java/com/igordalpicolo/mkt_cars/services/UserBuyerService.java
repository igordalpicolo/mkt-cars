package com.igordalpicolo.mkt_cars.services;

import com.igordalpicolo.mkt_cars.dto.UserBuyerDTO;
import com.igordalpicolo.mkt_cars.entities.UserBuyer;
import com.igordalpicolo.mkt_cars.exceptions.ResourceNotFoundException;
import com.igordalpicolo.mkt_cars.repositories.UserBuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserBuyerService {

    @Autowired
    private UserBuyerRepository userBuyerRepository;

    public UserBuyerDTO create(UserBuyerDTO userBuyerDTO) {
        UserBuyer userBuyer = new UserBuyer();
        userBuyer.setName(userBuyerDTO.getName());
        userBuyer.setEmail(userBuyerDTO.getEmail());
        userBuyer.setPhone(userBuyerDTO.getPhone());
        userBuyer.setPassword(userBuyerDTO.getPassword());
        userBuyerRepository.save(userBuyer);
        return new UserBuyerDTO(userBuyer);
    }

    public UserBuyerDTO findById(Long id) {
        if (!userBuyerRepository.existsById(id)) {
            throw new ResourceNotFoundException(id);
        }
        return new UserBuyerDTO(userBuyerRepository.findById(id).get());
    }

    public UserBuyerDTO update(Long id, UserBuyerDTO userBuyerDTO) {
       UserBuyer userBuyer = userBuyerRepository.findById(id)
                       .orElseThrow(() -> new ResourceNotFoundException(id));

       updateData(userBuyer, userBuyerDTO);
       userBuyerRepository.save(userBuyer);
       return new UserBuyerDTO(userBuyer);
    }

    private void updateData(UserBuyer entity, UserBuyerDTO dto) {
        if (dto.getName() != null) {entity.setName(dto.getName());}
        if (dto.getEmail() != null) {entity.setEmail(dto.getEmail());}
        if (dto.getPhone() != null) {entity.setPhone(dto.getPhone());}
        if (dto.getPassword() != null) {entity.setPassword(dto.getPassword());}
    }

    public List<UserBuyerDTO> findAll() {
        List<UserBuyer> userBuyers = userBuyerRepository.findAll();
        List<UserBuyerDTO> userBuyerDTOs = new ArrayList<>();
        for (UserBuyer userBuyer : userBuyers) {
            userBuyerDTOs.add(new UserBuyerDTO(userBuyer));
        }
        return userBuyerDTOs;
    }

    public void deleteById(Long id) {
       if (!userBuyerRepository.existsById(id)) {
       throw new ResourceNotFoundException(id);
       }
       userBuyerRepository.deleteById(id);
    }

}
