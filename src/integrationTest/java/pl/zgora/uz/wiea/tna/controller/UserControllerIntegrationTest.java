package pl.zgora.uz.wiea.tna.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.*;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.test.context.ActiveProfiles;
import pl.zgora.uz.wiea.tna.model.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("integration")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = {
                "server.domain=http://localhost",
        }
)
public class UserControllerIntegrationTest {

    @LocalServerPort
    private int testServerPort;

    @Value("${server.domain}")
    private String testServerUrl;

    @Autowired
    private ObjectMapper objectMapper;

    private TestRestTemplate restTemplate;

    @BeforeAll
    void setUp(@Autowired DataSource dataSource) {
        testServerUrl = String.format("%s:%d", testServerUrl, testServerPort);
        restTemplate = new TestRestTemplate();

        try (Connection conn = dataSource.getConnection()) {
            // you'll have to make sure conn.autoCommit = true (default for e.g. H2)
            // e.g. url=jdbc:h2:mem:integration_testdb;DB_CLOSE_DELAY=-1;MODE=MySQL
            ScriptUtils.executeSqlScript(conn, new ClassPathResource("samples-integration.sql"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test
    void shouldGetAllUsers_Returns_200() throws JsonProcessingException {
        final ResponseEntity<String> response = restTemplate.getForEntity(
                testServerUrl + "/api/users",
                String.class
        );

        final User[] users = convertToPojo(response.getBody(), User[].class);

        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertTrue(users.length > 0),
                () -> assertEquals(users[0].getId(), 1L),
                () -> assertEquals(users[0].getUsername(), "test1"),
                () -> assertEquals(users[0].getPassword(), "test1")
        );
    }

    @Test
    void shouldGetShortUrlById_Returns_200() {
        final ResponseEntity<User> response = restTemplate.getForEntity(
                testServerUrl + "/api/users/1",
                User.class
        );
        final User user = response.getBody();

        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(user.getId(), 1L),
                () -> assertEquals(user.getUsername(), "test1"),
                () -> assertEquals(user.getPassword(), "test1")
        );
    }

    private <T> HttpEntity<T> createRequest(final T requestedBody) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(requestedBody, headers);
    }

    private <T> T convertToPojo(final String jsonString, Class clazz) throws JsonProcessingException {
        return (T) objectMapper.readValue(jsonString, clazz);
    }
}
