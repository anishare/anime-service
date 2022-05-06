package com.anishare.animeservice.controller;

import com.anishare.animeservice.model.AnimeDTO;
import com.anishare.animeservice.service.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/anime")
public class AnimeController {

    private final AnimeService animeService;

    @Autowired
    public AnimeController(AnimeService animeService) {
        this.animeService = animeService;
    }

    @GetMapping
    public Page<AnimeDTO> getAll(Pageable pageable) {
        return animeService.getAllAnime(pageable);
    }

    @GetMapping("/{id}")
    public AnimeDTO getAnimeById(@PathVariable UUID id) {
        return animeService.getAnimeById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<AnimeDTO> addAnime(@Valid @RequestBody AnimeDTO anime) {
        return ResponseEntity
                .created(URI.create(ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString()))
                .body(animeService.saveAnime(anime));
    }

    @GetMapping("/search")
    public List<AnimeDTO> search(@RequestBody AnimeDTO animeDTO) {
        return animeService.search(animeDTO);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteAnime(@PathVariable UUID id) {
        animeService.deleteAnime(id);
        return ResponseEntity.accepted().body("Entry deleted: " + id);
    }

    @PostMapping("/findAllById")
    public ResponseEntity<List<AnimeDTO>> findAllById(@RequestBody List<UUID> list) {
        return ResponseEntity.ok(animeService.findAllById(list));
    }
}
