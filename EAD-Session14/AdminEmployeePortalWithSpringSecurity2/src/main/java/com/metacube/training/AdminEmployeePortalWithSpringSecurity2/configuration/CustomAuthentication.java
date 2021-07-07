package com.metacube.training.AdminEmployeePortalWithSpringSecurity2.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.metacube.training.AdminEmployeePortalWithSpringSecurity2.model.Role;
import com.metacube.training.AdminEmployeePortalWithSpringSecurity2.service.EmployeeService;
import com.metacube.training.AdminEmployeePortalWithSpringSecurity2.service.RoleService;

@Component
public class CustomAuthentication implements AuthenticationProvider
{

    @Autowired
    EmployeeService employeeService;

    @Autowired
    RoleService roleService;

    @Override
    public Authentication authenticate(Authentication authentication)
    {
        UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) authentication;
        String email = String.valueOf(auth.getPrincipal());
        String password = String.valueOf(auth.getCredentials());

        if (!employeeService.getByEmail(email).getPassword().equals(password))
        {
            throw new BadCredentialsException(
                    "External system authentication failed");
        }

        List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
        List<Role> roleList = roleService.findByUsername(email);

        for (Role role : roleList)
        {
            roles.add(new SimpleGrantedAuthority(role.getRole()));
        }

        return new UsernamePasswordAuthenticationToken(email, password, roles);
    }

    @Override
    public boolean supports(Class<?> authentication)
    {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
