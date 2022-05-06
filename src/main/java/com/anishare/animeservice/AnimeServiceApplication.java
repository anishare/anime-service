package com.anishare.animeservice;

import com.anishare.animeservice.model.AnimeDTO;
import com.anishare.animeservice.service.AnimeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class AnimeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimeServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AnimeService animeService) {
		return args -> {
			for (int i = 0; i < 100; i++) {
				AnimeDTO anime = new AnimeDTO();
				anime.setName("Anime"+i);
				animeService.saveAnime(anime);
			}
		};
	}

}
