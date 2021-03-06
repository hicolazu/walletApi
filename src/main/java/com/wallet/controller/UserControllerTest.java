package com.wallet.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wallet.business.dto.UserDTO;
import com.wallet.model.User;
import com.wallet.service.UserService;
import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UserControllerTest {

    private static final String USERNAME = "username";
    private static final String EMAIL = "email@mail.com";
    private static final String PASSWORD = "teste123";

    private static final String URI = "/user";

    @MockBean
    UserService service;

    @Autowired
    MockMvc mvc;

    @Test
    public void testGetAll() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders
                        .get(URI)
                        .content(getJsonPayload())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

    public User getMockUser() {
        return new User(USERNAME, EMAIL, PASSWORD);
    }

    public String getJsonPayload() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(new UserDTO(getMockUser()));
    }
}
