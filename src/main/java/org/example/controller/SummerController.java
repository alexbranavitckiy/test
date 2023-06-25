package org.example.controller;


import org.example.dto.SummerDTO;
import org.example.label.ErrorLabel;
import org.example.services.SummerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@ErrorLabel
@RequestMapping(value = "/summer", consumes = MediaType.APPLICATION_JSON_VALUE, produces =
        MediaType.APPLICATION_JSON_VALUE)
public class SummerController {

    @Autowired
    private SummerService summerService;

    @GetMapping("/getAll")
    public ResponseEntity<List<SummerDTO>> getAll() {
        return new ResponseEntity<>(summerService.getAll(), HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<SummerDTO> add(@RequestBody SummerDTO client) {
        return new ResponseEntity<>(summerService.add(client), HttpStatus.CREATED);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<Boolean> remove(@RequestBody SummerDTO client) {
        return new ResponseEntity<>(summerService.remove(client), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<SummerDTO> update(@RequestBody SummerDTO client) {
        return new ResponseEntity<>(summerService.update(client), HttpStatus.CREATED);
    }

}