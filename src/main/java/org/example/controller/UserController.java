package org.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.example.entiry.UserP;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Api(tags = "Пользователи", description = "API для работы с пользователями")
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Получить список пользователей", notes = "Возвращает список всех пользователей")
    public ResponseEntity<List<UserP>> getAllUsers(
            @RequestParam(defaultValue = "0", required = false) int page,
            @RequestParam(defaultValue = "10", required = false) int size,
            @RequestParam(defaultValue = "id", required = false) String sortBy,
            @RequestParam(defaultValue = "search", required = false) String search) {
        log.info("Получить список пользователей");
        return ResponseEntity.ok(userService.getAllUsers(page, size, sortBy, search));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Добавление нового пользователя")
    public ResponseEntity<UserP> createUser(@RequestBody UserP user) {
        log.info("Добавление нового пользователя");
        UserP createdUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Обновление информации о пользователе")
    public ResponseEntity<UserP> updateUser(@PathVariable long id, @RequestBody UserP user) {
        log.info("Обновление информации о пользователе");
        return ResponseEntity.ok(userService.updateUser(id, user));
    }

    @DeleteMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Удаление пользователя")
    public ResponseEntity<Void> deleteUser(@PathVariable long id) {
        log.info("Удаление пользователя");
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
