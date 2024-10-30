package com.example.criteria;

import com.example.criteria.model.User;
import com.example.criteria.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CriteriaApiApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;


    @Test
    void contextLoads() {
    }

    @Test
    void testCreateUser() throws Exception {
        User user = new User();
        user.setUsername("john_doe");
        user.setAge(30);

        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"username\":\"john_doe\",\"age\":30}"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetAllUsers() throws Exception{
        mockMvc.perform(get("/users"))
                .andExpect(status().isOk());
    }

    @Test
    void testUserById() throws Exception {
        User user = new User();
        user.setUsername("jane_doe");
        user.setAge(25);
        userRepository.save(user);

        mockMvc.perform(get("/users/" + user.getId()))
                .andExpect(status().isOk());
    }

    @Test
    void testDeleteUser() throws Exception {
        User user = new User();
        user.setUsername("john_doe");
        user.setAge(30);
        User savedUser = userRepository.save(user);

        mockMvc.perform(delete("/users/" + savedUser.getId()))
                .andExpect(status().isOk());
    }
}
