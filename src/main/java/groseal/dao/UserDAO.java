package groseal.dao;

import groseal.models.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO {

    void createUser(User user);

    User readUser(Long id);

    void updateUser(User user);

    void deleteUser(Long id);

    List<User> getAllUser();

    UserDetails loadUserByUsername(String username);
}
