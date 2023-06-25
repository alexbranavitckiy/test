package org.example.services.impl;

import org.example.dto.SummerDTO;
import org.example.entiry.Owner;
import org.example.entiry.Summer;
import org.example.repository.OwnerRepository;
import org.example.repository.SummerRepository;
import org.example.services.OwnerService;
import org.example.services.SummerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class SummerServiceImpl implements SummerService {

    @Autowired
    private SummerRepository summerRepository;

    @Override
    public List<SummerDTO> getAll() {
        return null;
    }

    @Override
    public SummerDTO add(SummerDTO client) {
        return null;
    }

    @Override
    public boolean remove(SummerDTO client) {
        return false;
    }

    @Override
    public SummerDTO update(SummerDTO client) {
        return null;
    }
}
