package pl.zgora.uz.wiea.tna.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import pl.zgora.uz.wiea.tna.persistence.entity.UserEntity;
import pl.zgora.uz.wiea.tna.persistence.repository.UserRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.zgora.uz.wiea.tna.fixture.UserFixtures.olga;
import static pl.zgora.uz.wiea.tna.fixture.UserFixtures.philip;

@ActiveProfiles("integration")
@DataJpaTest
class UserRepositoryIntegrationTest {

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository.saveAll(List.of(
                olga().userEntity(),
                philip().userEntity()));
    }

    @Test
    void shouldGetAllUsers() {
        List<UserEntity> actual = userRepository.findAll();
        assertThat(actual).hasSize(2);
    }
}
