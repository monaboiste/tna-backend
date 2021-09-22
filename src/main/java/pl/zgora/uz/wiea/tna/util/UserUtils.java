package pl.zgora.uz.wiea.tna.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.zgora.uz.wiea.tna.model.User;
import pl.zgora.uz.wiea.tna.persistence.entity.UserEntity;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserUtils {

    public static User mapUserEntityToUser(final UserEntity userEntity) {
        return User.builder()
                .id(userEntity.getId())
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                .role(userEntity.getRole())
                .build();
    }

    public static UserEntity mapUserToUserEntity(final User user) {
        return UserEntity.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .role(user.getRole())
                .build();
    }
}
