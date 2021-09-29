package pl.zgora.uz.wiea.tna.fixture;

import pl.zgora.uz.wiea.tna.model.User;
import pl.zgora.uz.wiea.tna.persistence.entity.Role;
import pl.zgora.uz.wiea.tna.persistence.entity.UserEntity;

import java.util.Objects;

public class UserFixtures {

    public static Fixture olga() {
      return new Fixture("olga", "test", Role.USER);
    }

    public static Fixture philip() {
        return new Fixture("philip", "test", Role.USER);
    }

    public static Fixture invalidUserWithNoUsername() {
        return new Fixture(null, "test", Role.USER);
    }

    public static Fixture invalidUserWithNoPassword() {
        return new Fixture("invalidUserWithNoPassword", null, Role.USER);
    }

    public static Fixture userWithDefaultRole() {
        return new Fixture("invalidUserWithNoRole", "test", null);
    }

    public static class Fixture {
        private final String username;
        private final String password;
        private final Role role;

        public Fixture(String username, String password, Role role) {
            this.username = username;
            this.password = password;
            this.role = role;
        }

        public User userResponse() {
            return User.builder()
                    .username(username)
                    .role(role)
                    .build();
        }

        public UserEntity userEntity() {
            return UserEntity.builder()
                    .username(username)
                    .password(password)
                    .role(role)
                    .build();
        }

        public String jsonRequest() {
            return String.format(
                    "{\"username\":%s,\"password\":%s,\"role\":%s}",
                    wrapWithParenthesesIfNotNull(username),
                    wrapWithParenthesesIfNotNull(password),
                    wrapWithParenthesesIfNotNull(Objects.isNull(role) ? null : role.toString())
            );
        }

        private static String wrapWithParenthesesIfNotNull(String value) {
            if (Objects.isNull(value)) {
                return "null";
            }
            return String.format("\"%s\"", value);
        }
    }
}
