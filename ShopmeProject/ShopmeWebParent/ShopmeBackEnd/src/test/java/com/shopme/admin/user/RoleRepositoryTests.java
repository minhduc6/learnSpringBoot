package com.shopme.admin.user;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.shopme.common.entity.Role;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class RoleRepositoryTests {

       @Autowired
       private RoleRepository repository;

       

       @Test
       public void testCreateRestRole()
       {
              Role roleAdmin = new Role("admin", "manage everythings");

              Role roleSaleperson = new Role("Salesperson",
                            "manage product price , customer , shipping  , orders and sale report");
              Role roleEditor = new Role("Editor",
                            "manage categories , brands , products  , articles and menu");
              Role roleShipper = new Role("Shipper",
                            "view products ,view orders  and update order status");
              Role roleAssistant = new Role("Assistant",
                            "mange question and reviews");
              repository.saveAll(List.of(roleAdmin,roleSaleperson, roleEditor, roleShipper, roleAssistant));
                            
   
       }
       
}