package com.springsecurity.service;

import com.springsecurity.domain.Role;

public interface RoleService extends BasicServiceInterface<Role, Long>{
    Role getRoleByName(String name);
}
