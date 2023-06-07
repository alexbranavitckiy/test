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


    @Override
    public List<OwnerDTO> getAll() {
        return null;
    }

    @Override
    public OwnerDTO add(OwnerDTO client) {
        return null;
    }

    @Override
    public boolean remove(OwnerDTO client) {
        return false;
    }

    @Override
    public OwnerDTO update(OwnerDTO client) {
        return null;
    }
}
