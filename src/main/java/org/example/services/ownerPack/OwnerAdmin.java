package org.example.services.ownerPack;

import lombok.extern.slf4j.Slf4j;
import org.example.dto.OwnerDTO;
import org.springframework.stereotype.Component;


@Slf4j
@Component("Admin")
public class OwnerAdmin implements OwnerInit{
    @Override
    public OwnerDTO initOwner(OwnerDTO ownerDTO) {
        log.info("Admin initOwner");
        return ownerDTO;
    }
}
