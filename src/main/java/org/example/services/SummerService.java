package org.example.services;

import org.example.dto.SummerDTO;
import org.example.entiry.Owner;
import org.example.entiry.Summer;

import java.util.List;

public interface SummerService {

    List<SummerDTO> getAll() ;

    SummerDTO add(SummerDTO client);
    boolean remove(SummerDTO client);
    SummerDTO update(SummerDTO client);




}
