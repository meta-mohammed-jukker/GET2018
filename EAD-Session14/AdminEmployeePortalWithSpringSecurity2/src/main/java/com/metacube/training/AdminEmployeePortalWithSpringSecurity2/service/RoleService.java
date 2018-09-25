package com.metacube.training.AdminEmployeePortalWithSpringSecurity2.service;

import java.util.List;

import com.metacube.training.AdminEmployeePortalWithSpringSecurity2.model.Role;

public interface RoleService
{
    public List<Role> findByUsername(String username);
}
