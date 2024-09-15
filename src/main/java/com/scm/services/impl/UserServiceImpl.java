package com.scm.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.entities.User;
import com.scm.repositories.UserRepo;
import com.scm.services.UserService;
import com.scm.helpers.ResourceNotFoundException;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User saveUser(User user) {
        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);
        return userRepo.save(user);
    }

    @Override
    public Optional<User> getUserById(String userId) {
        return userRepo.findById(userId);
    }

    @Override
    public Optional<User> updateUser(User user) {
        User existingUser = userRepo.findById(user.getUserId()).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setAbout(user.getAbout());
        existingUser.setPhoneNumber(user.getPhoneNumber());
        existingUser.setProfilePic(user.getProfilePic());
        existingUser.setProvider(user.getProvider());
        existingUser.setProviderUserId(user.getProviderUserId());
        existingUser.setEmailVerified(user.isEmailVerified());
        existingUser.setPhoneVerified(user.isPhoneVerified());
        existingUser.setEnabled(user.isEnabled());

        return Optional.of(userRepo.save(existingUser));
    }

    @Override
    public void deleteUser(String userId) {
        userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        userRepo.deleteById(userId);
    }

    @Override
    public boolean isUserExisting(String userId) {
        User user2 = userRepo.findById(userId).orElse(null);
        return user2!=null ? true : false;
    }

    @Override
    public boolean isUserExistingByEmail(String email) {
        User user2 = userRepo.findByEmail(email).orElse(null);
        return user2!=null ? true : false;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

}
