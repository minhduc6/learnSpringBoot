package vn.techmaster.demosession.repository;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vn.techmaster.demosession.exception.UserException;
import vn.techmaster.demosession.model.State;
import vn.techmaster.demosession.model.User;
import vn.techmaster.demosession.service.EmailService;


@Repository
public class UserRepository {

    @Autowired
    EmailService emailService;
    private ConcurrentHashMap<String, User> users = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, String> active_code_user_id = new ConcurrentHashMap<>();



    public User addUser(String fullName, String email, String haskPassword, State state) {
        if(isEmailExist(email)){
            throw new UserException("Email đã được sử dụng");
        }
        String id = UUID.randomUUID().toString();
        User user = User.builder().id(id).fullName(fullName).email(email).haskPassWord(haskPassword).state(state)
                .build();
        if(state.equals(State.PENDING)){
            String regisCode = UUID.randomUUID().toString();
            active_code_user_id.put(regisCode,id);
            try{
                emailService.sendEmail(email,regisCode);
            }catch (Exception e){
                active_code_user_id.remove(regisCode);
                users.remove(id);
                throw new UserException("Địa chỉ email của bạn không tồn tại");
            }
        }
        users.put(id,user);
        return user;
    }

    public void checkValidate(String code){
    User user = users.get(active_code_user_id.get(code));
    user.setState(State.ACTIVE);
    users.put(active_code_user_id.get(code),user);
    active_code_user_id.remove(code);
    }
    public boolean isEmailExist(String email) {
        return users.values().stream().filter(user -> user.getEmail().equalsIgnoreCase(email)).count() > 0;
    }

    public User addUser(String fullName, String email, String haskpass) {
        return addUser(fullName, email, haskpass, State.PENDING);
    }

    public Optional<User> findByEmail(String Email) {
        return users.values().stream().filter(user -> user.getEmail().equalsIgnoreCase(Email)).findFirst();
    }

    public void update(User user){
        users.put(user.getId(),user);
    }

}
