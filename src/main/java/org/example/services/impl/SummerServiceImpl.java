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

    public List<SummerDTO> getAll() {//TODO
        return summerRepository.findAll().stream().map(SummerDTO::fromSummerDTO).collect(Collectors.toList());
    }

    public SummerDTO add(SummerDTO client) {//TODO
        return SummerDTO.fromSummerDTO(summerRepository.save(client.toSummerDTO()));
    }

    public boolean remove(SummerDTO client) {//TODO
        summerRepository.delete(client.toSummerDTO());
        return true;
    }

    public SummerDTO update(SummerDTO client) {//TODO
        summerRepository.save(client.toSummerDTO());
        return client;
    }

}
