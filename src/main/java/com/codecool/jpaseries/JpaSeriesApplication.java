package com.codecool.jpaseries;

import com.codecool.jpaseries.entity.Episode;
import com.codecool.jpaseries.repository.EpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class JpaSeriesApplication {

    @Autowired
    private EpisodeRepository episodeRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaSeriesApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(){
        return args -> {
            Episode episode = Episode.builder()
                    .name("one")
                    .part(1)
                    .releaseDate(LocalDate.of(2020,10,22))
                    .build();
            episodeRepository.save(episode);
        };
    }

}
