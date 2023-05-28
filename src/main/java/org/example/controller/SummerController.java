package org.example.controller;


import org.example.dto.SummerDTO;
import org.example.entiry.Summer;
import org.example.services.SummerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/summer")
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