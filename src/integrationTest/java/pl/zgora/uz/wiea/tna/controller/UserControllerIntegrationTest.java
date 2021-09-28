package pl.zgora.uz.wiea.tna.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import pl.zgora.uz.wiea.tna.fixture.UserFixture;
import pl.zgora.uz.wiea.tna.persistence.entity.UserEntity;
import pl.zgora.uz.wiea.tna.persistence.repository.UserRepository;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("integration")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@WithMockUser
class UserControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository.saveAll(asList(
                UserFixture.validSimpleUserEntity(),
                UserFixture.validAdminUserEntity()
        ));
    }

    @AfterEach
    void tearDown() {
        userRepository.deleteAllInBatch();
    }

    @Test
    @DisplayName("should return all users")
    void shouldGetAllUsersAndReturn200() throws Exception {
        // when
        ResultActions resultActions
                = mockMvc.perform(get("/users")
                                .contentType(MediaType.APPLICATION_JSON))
                        .andDo(print());
        // then
        resultActions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    @DisplayName("should return specific user when valid id is passed")
    void shouldReturnUserWhenPassedValidUser() throws Exception {
        // given
        UserEntity userInDb = userRepository.findByUsername(
                        UserFixture.validSimpleUserEntity().getUsername())
                .orElse(new UserEntity());
        final long VALID_USER_ID = userInDb.getId();
        // when
        ResultActions resultActions
                = mockMvc.perform(get("/users/" + VALID_USER_ID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print());
        // then
        String expectedContent = String.format(
                "{\"id\":%d,\"username\":\"%s\",\"role\":\"%s\"}",
                VALID_USER_ID,
                userInDb.getUsername(),
                userInDb.getRole().toString()
        );
        resultActions
                .andExpect(status().isOk())
                .andExpect(content().string(expectedContent));
    }

    @Test
    @DisplayName("should return not found when invalid id is passed")
    void shouldReturnNotFoundWhenPassedInvalidUser() throws Exception {
        // given
        final long INVALID_USER_ID = 0L;
        // when
        ResultActions resultActions
                = mockMvc.perform(get("/users/" + INVALID_USER_ID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print());
        // then
        resultActions
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.errors[*].code", containsInAnyOrder("resource.not_found")));
    }
}
