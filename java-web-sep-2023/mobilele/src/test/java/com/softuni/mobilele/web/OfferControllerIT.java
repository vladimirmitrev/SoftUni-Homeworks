package com.softuni.mobilele.web;

import com.softuni.mobilele.model.entity.OfferEntity;
import com.softuni.mobilele.model.entity.UserEntity;
import com.softuni.mobilele.util.TestDataUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class OfferControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TestDataUtils testDataUtils;

    private UserEntity testUser, testAdmin;
    private OfferEntity testOffer;

    @BeforeEach
    void setUp() {
        testUser = testDataUtils.createTestUser("user@example.com");
        testAdmin = testDataUtils.createTestUser("admin@example.com");
        var testModel = testDataUtils.createTestModel(testDataUtils.createTestBrand());
        testOffer = testDataUtils.createTestOffer(testUser, testModel);
    }

    @AfterEach
    void tearDown() {
        testDataUtils.cleanUpDatabase();
    }

    @Test
    void testDeleteByAnonymousUser_Forbidden() throws Exception {
        mockMvc.perform(delete("/offers/{id}", testOffer.getId())
                        .with(csrf()))
                .andExpect(status().is3xxRedirection());
//                .andExpect(redirectedUrl("http://localhost/users/login"));
    }

    @Test
    @WithMockUser(
            username = "admin@example.com",
            roles = {"ADMIN", "USER"})
    void testDeleteByAdmin() throws Exception {
        mockMvc.perform(delete("/offers/{id}", testOffer.getId())
                        .with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/offers/all"));
    }

    public void testDeleteByOwner() {

    }

    public void testDeleteNotOwned_Forbidden() {

    }
}
