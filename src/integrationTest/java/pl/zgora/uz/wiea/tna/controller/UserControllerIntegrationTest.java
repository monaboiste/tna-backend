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
import pl.zgora.uz.wiea.tna.model.User;
import pl.zgora.uz.wiea.tna.persistence.entity.Role;
import pl.zgora.uz.wiea.tna.persistence.entity.UserEntity;
import pl.zgora.uz.wiea.tna.persistence.repository.UserRepository;

import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static pl.zgora.uz.wiea.tna.fixture.UserFixtures.invalidUserWithNoPassword;
import static pl.zgora.uz.wiea.tna.fixture.UserFixtures.userWithDefaultRole;
import static pl.zgora.uz.wiea.tna.fixture.UserFixtures.invalidUserWithNoUsername;
import static pl.zgora.uz.wiea.tna.fixture.UserFixtures.olga;
import static pl.zgora.uz.wiea.tna.fixture.UserFixtures.philip;

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
        userRepository.saveAll(List.of(
            olga().userEntity()
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
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    @DisplayName("should return specific user when valid id is passed")
    void shouldReturnUserWhenPassedValidUser() throws Exception {
        // given
        UserEntity userInDb = userRepository.findByUsername(
                        olga().userEntity().getUsername())
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
    @DisplayName("should return 404 when invalid id is passed")
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

    @Test
    @DisplayName("should create user when valid user is passed and return user")
    void shouldCreateUserWhenValidUserIsPassedAndReturnUser() throws Exception {
        // given
        String userJson = philip().jsonRequest();
        // when
        ResultActions resultActions
                = mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userJson)
                        .with(user("admin")
                                .roles("ADMIN")
                                .password("admin")))
                .andDo(print());
        // then
        User philip = philip().userResponse();
        resultActions
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.password").doesNotExist())
                .andExpect(jsonPath("$.username").value(philip.getUsername()))
                .andExpect(jsonPath("$.role").value(philip.getRole().toString()));
    }

    @Test
    @DisplayName("should return 400 when existing user is passed")
    void shouldReturnBadRequestWhenExistingUserIsPassed() throws Exception {
        // given
        String existingUserJson = olga().jsonRequest();
        // when
        ResultActions resultActions
                = mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(existingUserJson)
                        .with(user("admin")
                                .roles("ADMIN")
                                .password("admin")))
                .andDo(print());
        // then
        resultActions
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors[*].code", containsInAnyOrder("resource.already_exists")));
    }

    @Test
    @DisplayName("should return 400 when empty is passed")
    void shouldReturnBadRequestWhenEmptyUserIsPassed() throws Exception {
        // when
        ResultActions resultActions
                = mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}")
                        .with(user("admin")
                                .roles("ADMIN")
                                .password("admin")))
                .andDo(print());
        // then
        resultActions
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors[*].code", containsInAnyOrder("attribute.not_null")));
    }

    @Test
    @DisplayName("should return 400 when invalid user with no username is passed")
    void shouldReturnBadRequestWhenUserWithoutUsernameIsPassed() throws Exception {
        // given
        String invalidRequestJson = invalidUserWithNoUsername().jsonRequest();
        // when
        ResultActions resultActions
                = mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidRequestJson)
                        .with(user("admin")
                                .roles("ADMIN")
                                .password("admin")))
                .andDo(print());
        // then
        resultActions
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors[*].code", containsInAnyOrder("attribute.not_null")));
    }


    @Test
    @DisplayName("should return 400 when invalid user with no password is passed")
    void shouldReturnBadRequestWhenUserWithoutPasswordIsPassed() throws Exception {
        // given
        String invalidRequestJson = invalidUserWithNoPassword().jsonRequest();
        // when
        ResultActions resultActions
                = mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidRequestJson)
                        .with(user("admin")
                                .roles("ADMIN")
                                .password("admin")))
                .andDo(print());
        // then
        resultActions
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors[*].code", containsInAnyOrder("attribute.not_null")));
    }

    @Test
    @DisplayName("should create user with default role")
    void shouldCreateUserWithDefaultRole() throws Exception {
        // given
        String invalidRequestJson = userWithDefaultRole().jsonRequest();
        // when
        ResultActions resultActions
                = mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidRequestJson)
                        .with(user("admin")
                                .roles("ADMIN")
                                .password("admin")))
                .andDo(print());
        // then
        resultActions
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.role").value(Role.USER.toString()));
    }
}
