package com.anishare.animeservice;

import com.anishare.animeservice.model.Anime;
import com.anishare.animeservice.service.AnimeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AnimeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimeServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AnimeService animeService) {
		return args -> {
			for (int i = 0; i < 100; i++) {
				Anime anime = new Anime();
				anime.setName("Anime"+i);
				animeService.saveAnime(anime);
			}
		};
	}

}
