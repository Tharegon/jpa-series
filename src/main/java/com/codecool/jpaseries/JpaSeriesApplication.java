package com.codecool.jpaseries;

import com.codecool.jpaseries.entity.Episode;
import com.codecool.jpaseries.entity.Season;
import com.codecool.jpaseries.repository.EpisodeRepository;
import com.codecool.jpaseries.repository.SeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class JpaSeriesApplication {

    @Autowired
    private EpisodeRepository episodeRepository;

    @Autowired
    private SeasonRepository seasonRepository;

    private Set<Episode> episodeSet = new HashSet<>();

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

            episodeSet.add(episode);

            Season season = Season.builder()
                    .numberOfSeason(1)
                    .releaseDate(LocalDate.of(2020,10,22))
                    .episodes(episodeSet).build();

            episode.setSeason(season);
            seasonRepository.save(season);
        };
    }

}
