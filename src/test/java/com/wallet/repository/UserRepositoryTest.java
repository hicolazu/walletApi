package com.wallet.repository;

import com.wallet.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Test
    public void testSave() {
        User user = new User("teste", "teste@mail.com", "teste123");

        User response = repository.save(user);

        assertNotNull(response);
    }
}