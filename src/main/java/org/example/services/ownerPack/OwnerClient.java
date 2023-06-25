package org.example.services.ownerPack;

import lombok.extern.slf4j.Slf4j;
import org.example.dto.OwnerDTO;
import org.springframework.stereotype.Component;


@Slf4j
@Component("Client")
public class OwnerClient implements OwnerInit {
    @Override
    public OwnerDTO initOwner(OwnerDTO ownerDTO) {
        log.info("Client initOwner");
        return ownerDTO;
    }
}
