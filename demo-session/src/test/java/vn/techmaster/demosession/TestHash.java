package vn.techmaster.demosession;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import vn.techmaster.demosession.security.Hashing;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

@SpringBootTest
public class TestHash {
    @Autowired private Hashing hash;

    @Test
    public void hashPassword(){
        var passwords = List.of("abc","qerty","122455");
        for(String password : passwords) {
            String hashed = hash.hashPassword(password);
            assertThat(hashed).isNotNull();

        }
        
    } 
    @Test
    public void validatePassword(){
        var passwords = List.of("abc","qerty","122455");
        for(String password : passwords) {
            String hashed = hash.hashPassword(password);
            System.out.println(hashed);
            assertThat(hash.validatePassword(password, hashed)).isTrue();
        }

        assertThat(hash.validatePassword("abc", "1000:9ff7f4525156d2716cc95cd4aaf56b25:ccab7862fd19778dd651fa9c60fe8ea637824bee655b43d54c3ab11beb0ed7dd9a42844f1c64824ef8099f388f84c0f9a05a1599412dcbae1526bcfc4baaa54c655428645")).isFalse();
    }
}
