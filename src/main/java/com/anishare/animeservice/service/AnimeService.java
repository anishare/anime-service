package com.anishare.animeservice.service;

import com.anishare.animeservice.model.AnimeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface AnimeService {
    AnimeDTO saveAnime(AnimeDTO anime);
    AnimeDTO getAnimeById(UUID uuid);
    Page<AnimeDTO> getAllAnime(Pageable pageable);
    void deleteAnime(UUID uuid);
    AnimeDTO findIfExists(AnimeDTO animeDTO);
    List<AnimeDTO> search(AnimeDTO animeDTO);
    List<AnimeDTO> findAllById(List<UUID> list);
}
