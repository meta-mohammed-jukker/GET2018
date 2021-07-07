package com.metacube.training.AdminEmployeePortalWithSpringSecurity2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metacube.training.AdminEmployeePortalWithSpringSecurity2.model.Role;

public interface RoleRepository<R> extends JpaRepository<Role, Integer>
{
    public List<Role> findByUsername(String username);
}
