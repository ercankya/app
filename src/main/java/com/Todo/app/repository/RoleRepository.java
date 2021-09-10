package com.Todo.app.repository;

import java.util.Optional;

import com.Todo.app.model.Role;
import com.Todo.app.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName name);
}