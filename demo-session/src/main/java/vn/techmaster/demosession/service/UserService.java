package vn.techmaster.demosession.service;

import java.util.Optional;

import vn.techmaster.demosession.model.User;

public interface UserService {
    public User login(String email, String password);
    public Boolean logout(String email);

    public User addUser(String fullName, String email, String password);
    public User addUserAutoActivate(String fullName, String email, String password);
    public Boolean activeUser(String activationCode);

    public Boolean updatePassword(String email, String password);
    public Boolean updateEmail(String email, String newEmail );

    public Optional<User> findByEmail(String email);
    public User findById(String id);
}
