package com.anishare.animeservice.repository;

import com.anishare.animeservice.model.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, UUID> {
    List<Anime> findByNameContainingIgnoreCase(String name);
    Optional<Anime> findByMalID(String malId);
}
