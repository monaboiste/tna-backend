package pl.zgora.uz.wiea.tna.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import pl.zgora.uz.wiea.tna.persistence.entity.EmployeeEntity;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    @Override
    @Query("SELECT e FROM EmployeeEntity e")
    @NonNull List<EmployeeEntity> findAll();

    boolean existsByContractId(String contractId);
}
