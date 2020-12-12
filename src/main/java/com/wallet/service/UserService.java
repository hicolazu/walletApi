package com.wallet.service;

import com.wallet.model.User;

import java.util.Optional;

public interface UserService {

    User save(User user);

    Optional<User> findByEmail(String email);
}
