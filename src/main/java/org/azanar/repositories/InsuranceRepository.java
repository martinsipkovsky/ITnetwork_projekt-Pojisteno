package org.azanar.repositories;

import org.azanar.entities.InsuranceEntity;
import org.azanar.entities.InsurersEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InsuranceRepository extends CrudRepository<InsuranceEntity, Long> {
    Optional<InsuranceEntity> findById(Long id);
    Optional<InsuranceEntity> findByEmail(String email);
}
