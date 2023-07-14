package org.example.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

@Slf4j
@Service
public record InitUserMethodServiceFactory(Set<UserInit> reportTemplateMethodServices) {


    //todo
//    public UserInit findReportTemplateMethodService(UserInit reportType) {
//        return reportTemplateMethodServices.stream()
//                .filter(service -> service.initOwner().equals(reportType))
//        //                .findFirst()
//        //                .orElseThrow(() -> {
//        //                    log.error("No implementation found for Report type {}", reportType);
//        //                    return new UnprocessableEntityException("No implementation found!");
//        //                });
//    }
}