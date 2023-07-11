package org.example.services.ownerPack;

import lombok.extern.slf4j.Slf4j;
import org.example.dto.UserDTO;
import org.example.entiry.UserP;
import org.example.services.UserInit;
import org.springframework.stereotype.Component;


@Slf4j
@Component("Default")
public class DefaultOwnerService implements UserInit {
    @Override
    public UserP initOwner(UserP ownerDTO) {
        log.info("DefaultOwnerService initOwner");
        return ownerDTO;
    }
}
