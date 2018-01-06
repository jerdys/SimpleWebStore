package ru.kpfu.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import ru.kpfu.itis.models.User;

public interface UsersRepository extends JpaRepository<User, Long> {
    User findUserByEmail(@Param("email") String email);
}
