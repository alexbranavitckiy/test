package org.example.services.ownerPack;

import lombok.extern.slf4j.Slf4j;
import org.example.dto.UserDTO;
import org.example.services.UserInit;
import org.springframework.stereotype.Component;


@Slf4j
@Component("Admin")
public class UserAdmin implements UserInit {
    @Override
    public UserDTO initOwner(UserDTO ownerDTO) {
        log.info("Admin initOwner");
        return ownerDTO;
    }
}
