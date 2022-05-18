package vn.techmaster.demosession.service;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.techmaster.demosession.exception.UserException;
import vn.techmaster.demosession.model.State;
import vn.techmaster.demosession.model.User;
import vn.techmaster.demosession.repository.UserRepository;
import vn.techmaster.demosession.security.Hashing;

@Service
 // Cách Inject có lợi hơn khi sử dụng với mockito test
public class UserServiceInMemory implements UserService {
    @Autowired private UserRepository userRepo;
    @Autowired private Hashing hashing;


    @Override
    public User login(String email, String password) {
        Optional<User> o_user = userRepo.findByEmail(email);
        // Nếu user không tồn tại thì báo lỗi
        if (!o_user.isPresent()) {
            throw new UserException("Không tồn tại !");
        }
        User user = o_user.get();
        // User muốn login phải có trạng thái Active
        if(user.getState() != State.ACTIVE){
            throw new UserException("Người dùng chưa được kích hoạt");
        }
        if (hashing.validatePassword(password, user.getHaskPassWord())) {
            return user;
        }else{
            throw new UserException("Mật khẩu hoặc tên đăng nhập của bạn đã sai");
        }
    }

    @Override
    public Boolean logout(String email) {
        return null;
    }

    @Override
    public User addUser(String fullName, String email, String password) { 
        return userRepo.addUser(fullName, email, hashing.hashPassword(password));    
    }

    @Override
    public User addUserAutoActivate(String fullName, String email, String password) {     
        return userRepo.addUser(fullName, email, hashing.hashPassword(password),State.ACTIVE);  
    }


    @Override
    public Boolean activeUser(String activationCode) {

        return null;
    }

    @Override
    public Boolean updatePassword(String email, String password) {

        return null;
    }

    @Override
    public Boolean updateEmail(String email, String newEmail) {

        return null;
    }

    @Override
    public Optional<User> findByEmail(String email) {

        return null;
    }

    @Override
    public User findById(String id) {

        return null;
    }

   
}
