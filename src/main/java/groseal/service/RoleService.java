package groseal.service;

import groseal.models.Role;

import java.util.List;

public interface RoleService {

    Role getRoleByName(String role);

    void deleteRole(Long id);

    List<Role> getAllRoles();

}
