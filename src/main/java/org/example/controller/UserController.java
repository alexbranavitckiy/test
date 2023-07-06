package org.example.controller;

import org.example.dto.UserDTO;
import org.example.label.ErrorLabel;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ErrorLabel
@RequestMapping(value = "/owner")
public class UserController {

    @Autowired
    private UserService clientService;


    @GetMapping("/getAll")
    public ResponseEntity<List<UserDTO>> getAll() {
        return new ResponseEntity<>(clientService.getAll(), HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<UserDTO> add(@RequestBody UserDTO client) {
        return new ResponseEntity<>(clientService.add(client), HttpStatus.CREATED);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<Boolean> remove(@RequestBody UserDTO client) {
        return new ResponseEntity<>(clientService.remove(client), HttpStatus.OK);
    }


    @PostMapping("/update")
    public ResponseEntity<UserDTO> update(@RequestBody UserDTO client) {
        return new ResponseEntity<>(clientService.update(client), HttpStatus.CREATED);
    }


    @PostMapping("/test")
    public ResponseEntity<List<UserDTO>> test(@RequestBody UserDTO client) {
        return new ResponseEntity<>(clientService.test(client), HttpStatus.CREATED);
    }
}
