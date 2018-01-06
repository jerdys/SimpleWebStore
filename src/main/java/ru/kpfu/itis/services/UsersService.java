package ru.kpfu.itis.services;

import ru.kpfu.itis.models.User;

public interface UsersService {
    User findByEmail(String email);
    User saveUser(User user);
}
