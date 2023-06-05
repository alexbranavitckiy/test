package org.example.services;

import org.example.dto.OwnerDTO;
import org.example.entiry.Owner;

import java.util.List;

public interface OwnerService extends MassageService {

     List<OwnerDTO> getAll() ;
     OwnerDTO add(OwnerDTO client);
     boolean remove(OwnerDTO client);
     OwnerDTO update(OwnerDTO client);


}
