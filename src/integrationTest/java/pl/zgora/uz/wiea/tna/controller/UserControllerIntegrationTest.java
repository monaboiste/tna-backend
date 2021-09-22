package pl.zgora.uz.wiea.tna.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import pl.zgora.uz.wiea.tna.model.User;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@ActiveProfiles("integration")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@WithMockUser
class UserControllerIntegrationTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @BeforeAll
    void setUp(@Autowired final WebApplicationContext webApplicationContext) {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        objectMapper.disable(MapperFeature.USE_ANNOTATIONS);
    }

    @Test
    void shouldGetAllUsers_Returns_200() throws Exception {
        final MockHttpServletResponse response = mockMvc.perform(
                get("/users").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andReturn()
                .getResponse();

        final User[] users = convertToPojo(response.getContentAsString(), User[].class);

        assertAll(
                () -> assertEquals(HttpStatus.OK.value(), response.getStatus()),
                () -> assertTrue(users.length > 0),
                () -> assertEquals(1L, users[0].getId()),
                () -> assertEquals("test1", users[0].getUsername()),
                () -> assertEquals("test1", users[0].getPassword())
        );
    }

    @Test
    void shouldGetShortUrlById_Returns_200() throws Exception {
        final long id = 1L;
        MockHttpServletResponse response = mockMvc.perform(
                get("/users/" + id).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andReturn()
                .getResponse();

        final User user = convertToPojo(response.getContentAsString(), User.class);

        assertAll(
                () -> assertEquals(HttpStatus.OK.value(), response.getStatus()),
                () -> assertEquals(id, user.getId()),
                () -> assertEquals("test1", user.getUsername()),
                () -> assertEquals("test1", user.getPassword())
        );
    }

    private <T> T convertToPojo(final String jsonString, Class<T> clazz) throws JsonProcessingException {
        return objectMapper.readValue(jsonString, clazz);
    }
}
