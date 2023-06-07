package org.example.mapper.impl;

import org.example.mapper.MapperService;
import org.example.mapper.MapperServiceHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MapperServiceHolderImpl implements MapperServiceHolder {
    private final Map<String, MapperService> mapperServices;

    @Autowired
    public MapperServiceHolderImpl(Map<String, MapperService> mapperServices) {
        this.mapperServices = mapperServices;
    }

    public MapperService getMapperService(String serviceName) {
        return mapperServices.get(serviceName);
    }


}