package com.naluri.circle_project.repo;

import com.naluri.circle_project.entity.MainEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MainRepo extends JpaRepository<MainEntity, UUID> {

    Optional<MainEntity> findByKey(String key);

}
