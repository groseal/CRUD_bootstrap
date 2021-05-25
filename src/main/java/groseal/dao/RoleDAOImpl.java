package groseal.dao;

import groseal.models.Role;
import groseal.models.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDAOImpl implements RoleDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Role getRoleById(Long id) {
        return entityManager.createQuery("select r from Role r where r.id = :id", Role.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public Role getRoleByName(String role) {
        return entityManager.createQuery("select r from Role r where r.role = :role", Role.class)
                .setParameter("role", role).getSingleResult();
    }

    @Override
    public void deleteRole(Long id) {
        entityManager.remove(getRoleById(id));
    }

    @Override
    public List<Role> getAllRoles() {
        return entityManager.createQuery("SELECT r FROM Role r", Role.class).getResultList();
    }
}
