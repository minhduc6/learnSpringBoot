package com.shopme.admin.user;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Rollback;

import com.shopme.common.entity.Role;
import com.shopme.common.entity.User;


@DataJpaTest(showSql = false)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

       @Autowired
       private UserRepository repo;

       @Autowired
       private TestEntityManager entityManager;

       @Test
       public void testCreateUserWithOneRole()
       {
              Role roleAdmin = entityManager.find(Role.class, 1);
              User user = new User("duc@codejava.net", "1234", "DUC", "DUONG MINH");
              user.addRole(roleAdmin);

              User userSaved = repo.save(user);
              assertThat(userSaved.getId()).isGreaterThan(0);
       }
       @Test
       public void testCreateUserWithTwoRole()
       {

              User user1 = new User("thao@gmail.com", "123458", "Thao", "Duong MINH");
              Role roleEditor = new Role(3);
              Role roleAssistant = new Role(5);
              user1.addRole(roleEditor);
              user1.addRole(roleAssistant);
              User userSaved = repo.save(user1);
              assertThat(userSaved.getId()).isGreaterThan(0);
        }
       
        @Test
        public void testListUser()
        {
              Iterable<User> listUser = repo.findAll();
               listUser.forEach(user -> System.out.println(user));
        }
        
        

        @Test
        public void testGetById()
        {
               User user = repo.findById(1).get();
               System.out.println(user);
               assertThat(user).isNotNull();
        }
        
        
        @Test
        public void testUpdateUser()
        {
              User user = repo.findById(1).get();
              user.setEnabled(true);
              repo.save(user);
        }
        
         @Test
         public void testUpdateUserRole()
         {
               User user = repo.findById(2).get();
               Role roleEditor = new Role(3);
               Role roleSaleperson = new Role(2);
               user.getRoles().remove(roleEditor);
               user.addRole(roleSaleperson);
               repo.save(user);
         }
         
          @Test
          public void testDeleteUser()
          {
                 Integer userId = 3;
                 repo.deleteById(userId);
          }
          
          @Test
          public void testGetUserByEmail()
          {
        	  String email = "dmthao96@gmail.com";
        	  User user =  repo.getUserByEmail(email);
        	  assertThat(user).isNotNull();
          }
          
          @Test
          public void testCountById()
          {
        	  Integer id = 1;
        	  Long countById = repo.countById(id);
        	  
        	  assertThat(countById).isGreaterThan(0);
        	  
          }
          
          @Test 
          public void testDisableUser()
          {
        	  Integer id = 1;
        	  repo.updateEnabledStatus(id, false);
          }
          
          
          @Test 
          public void testListFirstPage()
          {
        	  int pageNumber = 0;
        	  int pageSize  = 4;
        	  Pageable pageable = PageRequest.of(pageNumber, pageSize);
        	  Page<User> page = repo.findAll(pageable);
        	  
        	  List<User> listUsers = page.getContent();
        	  
        	  listUsers.forEach(user -> System.out.println(user));
        	  assertThat(listUsers.size()).isEqualTo(pageSize);
        	  
          }
       
       
}