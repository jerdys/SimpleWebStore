package ru.kpfu.itis.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.models.User;
import ru.kpfu.itis.repositories.RolesRepository;
import ru.kpfu.itis.repositories.UsersRepository;
import ru.kpfu.itis.services.UsersService;

import java.util.Arrays;
import java.util.Collections;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private static final String USER_ROLE = "ROLE_USER";

    @Override
    public User findByEmail(String email) {
        return usersRepository.findUserByEmail(email);
    }

    @Override
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Collections.singletonList(rolesRepository.findByRole(USER_ROLE)));

        return usersRepository.saveAndFlush(user);
    }
}
