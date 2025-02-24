package org.azanar.repositories;

import org.azanar.entities.InsurersEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InsurersRepository extends CrudRepository<InsurersEntity, Long> {

    //Optional<InsurersEntity> findById(Long id);
}