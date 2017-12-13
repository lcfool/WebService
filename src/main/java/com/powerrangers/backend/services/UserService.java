package com.powerrangers.backend.services;

import com.powerrangers.backend.models.AppUser;
import com.powerrangers.backend.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;

@Service
public class UserService implements AppUserService {

    private final AppUserRepository appUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(AppUserRepository appUserRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.appUserRepository = appUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    // TODO: 13.12.2017 Finish implementing methods

    @Override
    public AppUser getUserByUsername(String username) {
        return appUserRepository.findOne(username);
    }

    @Override
    public AppUser createUser(AppUser appUser) {
        if (usernameExists(appUser.getUsername()) || emailExists(appUser.getEmail())) {
            return null;
        }
        appUser.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));
        return appUserRepository.save(appUser);
    }

    @Override
    public AppUser updateUser(AppUser appUser) {
        AppUser userToUpdate = appUserRepository.findOne(appUser.getUsername());
        if (userToUpdate == null) {
            throw new NoResultException("User not found");
        }
        userToUpdate.setEmail(appUser.getEmail());
        userToUpdate.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));
        userToUpdate.setUsername(appUser.getUsername());
        userToUpdate.setFirstName(appUser.getFirstName());
        userToUpdate.setLastName(appUser.getLastName());
        userToUpdate.setAge(appUser.getAge());
        return appUserRepository.save(userToUpdate);
    }

    @Override
    public void deleteUser(String username) {
        // TODO: 13.12.2017 implement method when Email service is ready
    }

    @Override
    public void activateUser(String token) {
        // TODO: 13.12.2017 implement method when Email service is ready
    }

    @Override
    public AppUser resetPassword(String token) {
        // TODO: 13.12.2017 implement method when Email service is ready
        return null;
    }

    private boolean emailExists(String email) {
        String existingEmail;
        List<AppUser> users = appUserRepository.findAll();
        for (AppUser user : users) {
            existingEmail = user.getEmail();
            if (existingEmail.equals(email)) {
                return true;
            }
        }
        return false;
    }

    private boolean usernameExists(String username) {
        String existingUsername;
        List<AppUser> users = appUserRepository.findAll();
        for (AppUser user : users) {
            existingUsername = user.getUsername();
            if (existingUsername.equals(username)) {
                return true;
            }
        }
        return false;
    }
}
