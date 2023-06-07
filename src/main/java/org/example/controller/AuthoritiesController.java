package org.example.controller;

import org.example.dto.AuthoritiesDTO;
import org.example.label.ErrorLabel;
import org.example.services.AuthoritiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@ErrorLabel
@RestController
@RequestMapping("/authorities")
public class AuthoritiesController {


    @Autowired
    private AuthoritiesService authoritiesService;


    @GetMapping("/getAll")
    public ResponseEntity<List<AuthoritiesDTO>> getAll() {
        return new ResponseEntity<>(authoritiesService.getAll(), HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<AuthoritiesDTO> add(@RequestBody String CODE) {
        return new ResponseEntity<>(authoritiesService.add(CODE), HttpStatus.CREATED);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<Boolean> remove(@RequestParam Long id,String code) {
        return new ResponseEntity<>(authoritiesService.remove(id, code), HttpStatus.OK);
    }


    @PostMapping("/update")
    public ResponseEntity<AuthoritiesDTO> update(@RequestParam Long id, @RequestParam String code) {
        return new ResponseEntity<>(authoritiesService.update(id,code), HttpStatus.CREATED);
    }

}
