package org.example.controller;

import org.example.dto.AuthoritiesDTO;
import org.example.error.NotFoundError;
import org.example.label.ErrorLabel;
import org.example.services.AuthoritiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@ErrorLabel
@RestController
@RequestMapping(value = "/authorities",consumes = MediaType.APPLICATION_JSON_VALUE, produces =
        MediaType.APPLICATION_JSON_VALUE)
public class AuthoritiesController {


    @Autowired
    private AuthoritiesService authoritiesService;


    @GetMapping(value = "/getAll")
    public ResponseEntity<List<AuthoritiesDTO>> getAll() {
        return new ResponseEntity<>(authoritiesService.getAll(), HttpStatus.OK);
    }

    @PostMapping(value = "add",consumes = MediaType.APPLICATION_JSON_VALUE, produces =
            MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthoritiesDTO> add(@RequestBody String CODE) {
        return new ResponseEntity<>(authoritiesService.add(CODE), HttpStatus.CREATED);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<Boolean> remove(@RequestParam Long id,String code) {
        return new ResponseEntity<>(authoritiesService.remove(id, code), HttpStatus.OK);
    }


    @PostMapping("/update")//Lost connection during update
    public ResponseEntity<AuthoritiesDTO> update(@RequestBody AuthoritiesDTO authoritiesDTO) throws NotFoundError {
        return new ResponseEntity<>(authoritiesService.updateCodeIfExistId(authoritiesDTO), HttpStatus.CREATED);
    }




}
