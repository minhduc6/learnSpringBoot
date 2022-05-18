package vn.techmaster.demosession;

import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

import vn.techmaster.demosession.model.State;
import vn.techmaster.demosession.model.User;
import vn.techmaster.demosession.repository.UserRepository;


import static org.assertj.core.api.Assertions.*;
@SpringBootTest// Tự động lắp ghép các dependency injection
public class TestUserRepo {
   

    @Test
    public void addUser(){
        UserRepository userRepo = new UserRepository();
        User user = userRepo.addUser("Khiêm", "Khiem31200@gmail.com", "123", State.PENDING);
        assertThat(user).isNotNull();
        System.out.print(user.getId());
        assertThat(user.getId()).isNotBlank();
    }

    @Test
    public void isEmailExist(){
        UserRepository userRepo = new UserRepository();
        userRepo.addUser("Khiem", "khiem31200@gmail.com", "123");
        userRepo.addUser("Khiem", "khiemfh31200@gmail.com", "123");
        assertThat(userRepo.isEmailExist("kHiem31200@gmaIl.com"));
        assertThat(userRepo.isEmailExist("kHiem31200Fh@gmaIl.com"));

    }

    @Test
    public void addUserWithState(){
        UserRepository userRepo = new UserRepository();
        User user = userRepo.addUser("Khiem", "khiem31200@gmail.com", "123",State.PENDING);
        assertThat(user).isNotNull();
        assertThat(user.getId()).isNotBlank();
        assertThat(user.getState()).isEqualTo(State.PENDING);
    }

    @Test 
    public void findByEmail(){
        UserRepository userRepo = new UserRepository();
        userRepo.addUser("Khiem", "khiem31200@gmail.com", "123");
        userRepo.addUser("Khiem", "khiemfh31200@gmail.com", "123");
        assertThat(userRepo.findByEmail("khiem312900@gmail.com")).isNotPresent();
        assertThat(userRepo.findByEmail("khiemfh31200@gmail.com")).isPresent();
    }


    
}
