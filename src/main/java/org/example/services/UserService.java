package org.example.services;

import org.example.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getAll();

    UserDTO add(UserDTO client);

    boolean remove(UserDTO client);

    UserDTO update(UserDTO client);

    List<UserDTO> test(UserDTO client);

}
