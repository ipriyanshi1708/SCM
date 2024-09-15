package com.scm.services;

import org.springframework.stereotype.Service;

import com.scm.entities.User;
import java.util.List;
import java.util.Optional;

public interface UserService {

    User saveUser(User user);

    Optional<User> getUserById(String userId);

    Optional<User> updateUser(User user);

    void deleteUser(String userId);

    boolean isUserExisting(String userId);

    boolean isUserExistingByEmail(String email);

    List<User> getAllUsers();

}
