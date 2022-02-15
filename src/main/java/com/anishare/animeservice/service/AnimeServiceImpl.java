package com.anishare.animeservice.service;

import com.anishare.animeservice.mapper.AnimeMapper;
import com.anishare.animeservice.model.AnimeDTO;
import com.anishare.animeservice.repository.AnimeRepository;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
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
        AnimeDTO temp = null;
        if (anime.getMalID() != null || anime.getId() != null) temp = findIfExists(anime);
        return (temp != null) ?
                temp :
                animeMapper.animeToAnimeDTO(animeRepository.save(animeMapper.animeDTOToAnime(anime)));
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

    @Override
    public AnimeDTO findIfExists(AnimeDTO animeDTO) {
        return Strings.isNullOrEmpty(animeDTO.getMalID()) ?
                animeMapper.animeToAnimeDTO(animeRepository.findById(animeDTO.getId()).orElse(null)) :
                animeMapper.animeToAnimeDTO(animeRepository.findByMalID(animeDTO.getMalID()).orElse(null));
    }

    @Override
    public List<AnimeDTO> search(AnimeDTO animeDTO) {
        return animeMapper.animeListToAnimeDTOList(animeRepository.findByNameContainingIgnoreCase(animeDTO.getName()));
    }
}
