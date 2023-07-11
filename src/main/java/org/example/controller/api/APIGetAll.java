package org.example.controller.api;

import io.swagger.annotations.ApiOperation;
import org.example.entiry.OrderP;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface APIGetAll<T> {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Получить список ", notes = "Возвращает список отсортированный по sortBy и поиск по search")
     ResponseEntity<List<T>> getAll(
            @RequestParam(defaultValue = "0", required = false) int offset,
            @RequestParam(defaultValue = "10", required = false) int limit,
            @RequestParam(defaultValue = "id", required = false) String sortBy,
            @RequestParam(defaultValue = " ", required = false) String search) ;


}
