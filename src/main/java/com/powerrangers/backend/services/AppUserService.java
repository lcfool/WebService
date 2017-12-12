package com.powerrangers.backend.services;

import com.powerrangers.backend.models.AppUser;

public interface AppUserService {

    AppUser getUserByUsername(String username);

    AppUser createUser(AppUser appUser);

    AppUser updateUser(AppUser appUser);

    AppUser deleteUser(String username, String password);

    AppUser resetPassword(String token);
}
