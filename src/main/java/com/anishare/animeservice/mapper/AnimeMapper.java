package com.anishare.animeservice.mapper;

import com.anishare.animeservice.model.Anime;
import com.anishare.animeservice.model.AnimeDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnimeMapper {
    Anime animeDTOToAnime(AnimeDTO animeDTO);
    AnimeDTO animeToAnimeDTO(Anime anime);
    List<AnimeDTO> animeListToAnimeDTOList(List<Anime> anime);
}
