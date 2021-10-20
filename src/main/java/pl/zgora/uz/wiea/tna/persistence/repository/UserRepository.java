package pl.zgora.uz.wiea.tna.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import pl.zgora.uz.wiea.tna.persistence.entity.UserEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Override
    @Query("SELECT u FROM UserEntity u")
    @NonNull List<UserEntity> findAll();

    Optional<UserEntity> findByUsername(String username);

    boolean existsByUsername(String username);
}
