package com.softuni.mobilele.web;

import com.softuni.mobilele.service.EmailService;
import jakarta.servlet.http.Cookie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Locale;

import static org.mockito.Mockito.verify;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserRegistrationControllerMockBeanIT {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmailService mockEmailService;

    @Test
    void testRegistrationPageShown() throws Exception {
        mockMvc.perform(get("/users/register"))
                .andExpect(status().isOk())
                .andExpect(view().name("auth-register"));
    }

    @Test
    void testUserRegistration() throws Exception {
        mockMvc.perform(post("/users/register")
                .param("email", "johndoe@example.com")
                .param("firstName", "John")
                .param("lastName", "Doe")
                .param("password", "topsecret")
                .param("confirmPassword", "topsecret")
                        .cookie(new Cookie("lang", Locale.GERMAN.getLanguage()))
                                .with(csrf())
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));

        verify(mockEmailService).sendRegistrationEmail("johndoe@example.com",
                "John Doe", Locale.GERMAN);

    }
}
