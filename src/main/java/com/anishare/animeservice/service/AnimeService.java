package com.anishare.animeservice.service;

import com.anishare.animeservice.model.AnimeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface AnimeService {
    AnimeDTO saveAnime(AnimeDTO anime);
    AnimeDTO getAnimeById(UUID uuid);
    Page<AnimeDTO> getAllAnime(Pageable pageable);
    void deleteAnime(UUID uuid);
}
