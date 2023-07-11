package org.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.AuthoritiesDTO;
import org.example.entiry.protection.Authorities;
import org.example.error.NotFoundError;
import org.example.services.AuthoritiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/authorities")
@Api(tags = "Authorities", description = "API для работы с Authorities")
public class AuthoritiesController {

    @Autowired
    private AuthoritiesService authoritiesService;

    @ApiOperation(value = "Получить все Authorities", notes = "Возвращает список всех Authorities")
    @GetMapping("/getAll")
    public ResponseEntity<List<Authorities>> getAll() {
        return new ResponseEntity<>(authoritiesService.getAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Добавить Authorities", notes = "Добавляет новый Authorities")
    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Authorities> add(@RequestBody String code) {
        return new ResponseEntity<>(authoritiesService.add(code), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Удалить Authorities", notes = "Удаляет Authorities по заданному id и code")
    @DeleteMapping("/remove")
    public ResponseEntity<Void> remove(@RequestParam Long id, @RequestParam String code) {
        authoritiesService.remove(id, code);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "Обновить Authorities", notes = "Обновляет существующий Authorities")
    @PostMapping("/update")
    public ResponseEntity<Authorities> update(@RequestBody AuthoritiesDTO authoritiesDTO) throws NotFoundError {
        return new ResponseEntity<>(authoritiesService.update(authoritiesDTO), HttpStatus.CREATED);
    }
}