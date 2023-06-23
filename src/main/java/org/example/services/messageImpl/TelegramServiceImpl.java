package org.example.services.messageImpl;


import lombok.extern.slf4j.Slf4j;
import org.example.entiry.Message;
import org.example.services.MassageService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Slf4j
@Order(3)
@Service("Telegram")
public class TelegramServiceImpl implements MassageService {


    @Override
    public boolean setMessage(Message owner) {
        log.info("Telegram");
        return false;
    }


}
