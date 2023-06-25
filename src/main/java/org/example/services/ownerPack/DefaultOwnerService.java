package org.example.services.ownerPack;

import lombok.extern.slf4j.Slf4j;
import org.example.dto.OwnerDTO;
import org.springframework.stereotype.Component;


@Slf4j
@Component("Default")
public class DefaultOwnerService implements OwnerInit{
    @Override
    public OwnerDTO initOwner(OwnerDTO ownerDTO) {
        log.info("DefaultOwnerService initOwner");
        return ownerDTO;
    }
}
