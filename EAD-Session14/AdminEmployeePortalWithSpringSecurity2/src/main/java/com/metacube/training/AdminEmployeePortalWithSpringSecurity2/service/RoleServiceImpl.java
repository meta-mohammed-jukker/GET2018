package com.metacube.training.AdminEmployeePortalWithSpringSecurity2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.AdminEmployeePortalWithSpringSecurity2.model.Role;
import com.metacube.training.AdminEmployeePortalWithSpringSecurity2.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService
{
    @Autowired
    public RoleRepository<Role> roleRepository;

    @Override
    public List<Role> findByUsername(String username)
    {
        return roleRepository.findByUsername(username);
    }
    
}
