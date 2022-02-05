package com.anishare.animeservice.service;

import com.anishare.animeservice.model.Anime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface AnimeService {
    Anime saveAnime(Anime anime);
    Anime getAnimeById(UUID uuid);
    Page<Anime> getAllAnime(Pageable pageable);
    void deleteAnime(UUID uuid);
}
