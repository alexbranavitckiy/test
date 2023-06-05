package org.example.services.messageImpl;


import lombok.extern.slf4j.Slf4j;
import org.example.entiry.Message;
import org.example.services.MassageService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Slf4j
@Order(1)
@Service("Email")
public class EmailServiceImpl implements MassageService {


    @Override
    public boolean setMessage(Message owner) {
        log.info("Email");
        return false;
    }


}
