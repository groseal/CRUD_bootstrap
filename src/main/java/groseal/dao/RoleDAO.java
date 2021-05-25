package groseal.dao;

import groseal.models.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDAO {

    Role getRoleById(Long id);

    Role getRoleByName(String role);

    void deleteRole(Long id);

    List<Role> getAllRoles();

}
