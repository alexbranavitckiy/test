package org.example.controller;

import org.example.dto.AuthoritiesDTO;
import org.example.entiry.Authorities;
import org.example.entiry.Owner;
import org.example.services.AuthoritiesService;
import org.example.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/authorities")
public class AuthoritiesController {


    @Autowired
    private AuthoritiesService authoritiesService;


    @GetMapping("/test")
    public ResponseEntity<String> testOk() {
        return new ResponseEntity<>("testOk", HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Authorities>> getAll() {
        return new ResponseEntity<>(authoritiesService.getAll(), HttpStatus.OK);
    }


    @PostMapping("add")
    public ResponseEntity<AuthoritiesDTO> add(@RequestBody AuthoritiesDTO client) {
        return new ResponseEntity<>(authoritiesService.add(client), HttpStatus.CREATED);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<Boolean> remove(@RequestBody AuthoritiesDTO client) {
        return new ResponseEntity<>(authoritiesService.remove(client), HttpStatus.OK);
    }


    @PostMapping("/update")
    public ResponseEntity<AuthoritiesDTO> update(@RequestBody AuthoritiesDTO client) {
        return new ResponseEntity<>(authoritiesService.update(client), HttpStatus.CREATED);
    }

}
