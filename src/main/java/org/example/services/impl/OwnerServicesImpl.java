package org.example.services.impl;


import org.example.dto.OwnerDTO;
import org.example.entiry.Owner;
import org.example.repository.OwnerRepository;
import org.example.services.OwnerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OwnerServicesImpl implements OwnerService {

    @Autowired
    private OwnerRepository clientRepository;


    public List<OwnerDTO> getAll() {//TODO
        return clientRepository.findAll().stream().map(OwnerDTO::fromOwnerDTO).collect(Collectors.toList());
    }

    public OwnerDTO add(OwnerDTO client) {//TODO
        return OwnerDTO.fromOwnerDTO(clientRepository.save(client.toOwner()));
    }

    public boolean remove(OwnerDTO client) {//TODO
        clientRepository.delete(client.toOwner());
        return true;
    }

    public OwnerDTO update(OwnerDTO client) {//TODO
        clientRepository.save(client.toOwner());
        return client;
    }

}
