package ru.kpfu.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import ru.kpfu.itis.models.Role;

public interface RolesRepository extends JpaRepository<Role, Integer> {
    Role findByRole(@Param("role") String role);
}
