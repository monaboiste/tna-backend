package pl.zgora.uz.wiea.tna.fixture;

import pl.zgora.uz.wiea.tna.persistence.entity.Role;
import pl.zgora.uz.wiea.tna.persistence.entity.UserEntity;

public class UserFixture {

    public static UserEntity validAdminUserEntity() {
        return UserEntity.builder()
                .username("admin")
                .password("admin")
                .role(Role.ADMIN)
                .build();
    }

    public static UserEntity validSimpleUserEntity() {
        return UserEntity.builder()
                .username("user")
                .password("test")
                .role(Role.USER)
                .build();
    }
}
