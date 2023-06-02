package org.example.controller;

import org.example.dto.OwnerDTO;
import org.example.label.ErrorLabel;
import org.example.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ErrorLabel
@RequestMapping("/owner")
public class OwnerController {

    @Autowired
    private OwnerService clientService;


    @GetMapping("/getAll")
    public ResponseEntity<List<OwnerDTO>> getAll() {
        return new ResponseEntity<>(clientService.getAll(), HttpStatus.OK);
    }


    @PostMapping("add")
    public ResponseEntity<OwnerDTO> add(@RequestBody OwnerDTO client) {
        return new ResponseEntity<>(clientService.add(client), HttpStatus.CREATED);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<Boolean> remove(@RequestBody OwnerDTO client) {
        return new ResponseEntity<>(clientService.remove(client), HttpStatus.OK);
    }


    @PostMapping("/update")
    public ResponseEntity<OwnerDTO> update(@RequestBody OwnerDTO client) {
        return new ResponseEntity<>(clientService.update(client), HttpStatus.CREATED);
    }

}
