package groseal.service;

import groseal.dao.UserDAO;
import groseal.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public User createUser(User user) {
        userDAO.createUser(user);
        return user;
    }

    @Override
    @Transactional(readOnly = true)
    public User readUser(Long id) {
        return userDAO.readUser(id);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userDAO.deleteUser(id);
    }

    @Override
    @Transactional
    public List<User> getAllUser() {
        return userDAO.getAllUser();
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userDAO.getUserByName(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("User " + username + " not found");
//        }
//        return new org.springframework.security.core.userdetails.User(
//                user.getName(), user.getPassword(), mapRolesToAuthorities(user.getUserRoles())
//        );
        return userDAO.loadUserByUsername(username);
    }

    //делает из ролей пользователя GrantedAuthority для метода loadUserByUsername
//    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
//        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList());
//    }
}
