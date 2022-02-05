package com.anishare.animeservice.service;

import com.anishare.animeservice.model.Anime;
import com.anishare.animeservice.repository.AnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AnimeServiceImpl implements AnimeService {

    private final AnimeRepository animeRepository;

    @Autowired
    public AnimeServiceImpl(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    public Anime saveAnime(Anime anime) {
        return animeRepository.save(anime);
    }

    public Anime getAnimeById(UUID uuid) {
        return animeRepository.findById(uuid).orElseThrow();
    }

    public Page<Anime> getAllAnime(Pageable pageable) {
        return animeRepository.findAll(pageable);
    }

    public void deleteAnime(UUID uuid) {
        animeRepository.deleteById(uuid);
    }
}
