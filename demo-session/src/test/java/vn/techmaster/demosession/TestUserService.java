package vn.techmaster.demosession;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import vn.techmaster.demosession.exception.UserException;
import vn.techmaster.demosession.model.User;
import vn.techmaster.demosession.service.UserService;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class TestUserService {
    @Autowired private UserService userService;
    

    @Test
    public void addUser(){// Kiểm tra trường hợp
        User user = userService.addUser("Khiêm Nguyễn", "khiem31200@gmail.com", "123@123abc");
        assertThat(user).isNotNull();   
    }

    @Test 
    public void login(){ // Kiểm tra đông thời 2 trường hợp đăng nhập đúng và sai
        userService.addUserAutoActivate("Khiêm Nguyễn", "khiem31200@gmail.com", "123@123abc");
        assertThat(userService.login("khiem31200@gmail.com", "123@123abc")).isNotNull();
        assertThatThrownBy(() -> {
            userService.login("khiem31200@gmail.com", "123@123abc.");
        }).isInstanceOf(UserException.class)
        .hasMessageContaining("Mật khẩu hoặc tên đăng nhập của bạn đã sai");
    }

    @Test 
    public void loginPendingAccount(){// Kiểm tra trường hợp đã đăng nhập đúng nhưng tài khoản chưa được kích hoạt
        userService.addUser("Khiêm Nguyễn", "khiem31200@gmail.com", "123@123abc");
        assertThatThrownBy(() -> {
            userService.login("khiem31200@gmail.com", "123@123abc");
        }).isInstanceOf(UserException.class)
        .hasMessageContaining("Người dùng chưa được kích hoạt");
    }

    @Test 
    public void loginNotFoundAccount(){// Kiểm tra trường hợp tài khoản không có 
        assertThatThrownBy(() -> {
            userService.login("khiem31200@gmail.com", "123@123abc");
        }).isInstanceOf(UserException.class)
        .hasMessageContaining("Không tồn tại !");
    }

    @Test 
    public void loginIncorrectPassWordAccount(){// Chỉ kiểm tra trường hợp bị sai
        userService.addUserAutoActivate("Khiêm Nguyễn", "khiem31200@gmail.com", "123@123abc");
        assertThatThrownBy(() -> {
            userService.login("khiem31200@gmail.com", "123@123abc.");
        }).isInstanceOf(UserException.class)
        .hasMessageContaining("Mật khẩu hoặc tên đăng nhập của bạn đã sai");
    }

}
