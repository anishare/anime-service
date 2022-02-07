package com.anishare.animeservice.service;

import com.anishare.animeservice.mapper.AnimeMapper;
import com.anishare.animeservice.model.AnimeDTO;
import com.anishare.animeservice.repository.AnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AnimeServiceImpl implements AnimeService {

    private final AnimeRepository animeRepository;
    private final AnimeMapper animeMapper;

    @Autowired
    public AnimeServiceImpl(AnimeRepository animeRepository, AnimeMapper animeMapper) {
        this.animeRepository = animeRepository;
        this.animeMapper = animeMapper;
    }

    @Override
    public AnimeDTO saveAnime(AnimeDTO anime) {
        return animeMapper.animeToAnimeDTO(animeRepository.save(animeMapper.animeDTOToAnime(anime)));
    }

    @Override
    public AnimeDTO getAnimeById(UUID uuid) {
        return animeMapper.animeToAnimeDTO(animeRepository.findById(uuid).orElseThrow());
    }

    @Override
    public Page<AnimeDTO> getAllAnime(Pageable pageable) {
        return animeRepository.findAll(pageable).map(animeMapper::animeToAnimeDTO);
    }

    @Override
    public void deleteAnime(UUID uuid) {
        animeRepository.deleteById(uuid);
    }
}
