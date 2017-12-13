package com.powerrangers.backend.services;

import com.powerrangers.backend.models.AppUser;

public interface AppUserService {

    AppUser getUserByUsername(String username);

    AppUser createUser(AppUser appUser);

    AppUser updateUser(AppUser appUser);

    void deleteUser(String username);

    void activateUser(String token);

    AppUser resetPassword(String token);
}
