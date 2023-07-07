package org.example.services.messageImpl;

import lombok.extern.slf4j.Slf4j;
import org.example.services.MassageService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;


@Slf4j
@Order(2)
@Service("Phone")
public class PhoneServiceImpl implements MassageService {


    @Override
    public boolean setMessage(String owner) {
        log.info("Phone");
        return false;
    }
}
