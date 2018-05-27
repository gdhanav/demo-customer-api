package com.java.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
