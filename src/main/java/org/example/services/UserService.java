package org.example.services;

import org.example.dto.UserDTO;
import org.example.entiry.UserP;

import java.util.List;

public interface UserService {

    UserDTO add(UserDTO client);

    List<UserP> getAllUsers(int page, int size, String sortBy, String search);

    UserP createUser(UserP user);

    UserP deleteUser(long id);

    UserP updateUser(long id, UserP user);
}
