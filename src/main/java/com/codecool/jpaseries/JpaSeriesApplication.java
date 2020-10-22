package com.codecool.jpaseries;

import com.codecool.jpaseries.entity.Episode;
import com.codecool.jpaseries.entity.Genres;
import com.codecool.jpaseries.entity.Season;
import com.codecool.jpaseries.entity.Series;
import com.codecool.jpaseries.repository.EpisodeRepository;
import com.codecool.jpaseries.repository.SeasonRepository;
import com.codecool.jpaseries.repository.SeriesRepository;
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
    private SeriesRepository seriesRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaSeriesApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(){
        Set<Episode> episodeSet = new HashSet<>();
        Set<Season> seasonSet = new HashSet<>();

        return args -> {
            Episode episode = Episode.builder()
                    .name("one")
                    .part(1)
                    .releaseDate(LocalDate.of(2020,10,22))
                    .build();

            Episode episode2 = Episode.builder()
                    .name("two")
                    .part(2)
                    .releaseDate(LocalDate.of(2020,10,23))
                    .build();

            episodeSet.add(episode);
            episodeSet.add(episode2);

            Season season = Season.builder()
                    .numberOfSeason(1)
                    .releaseDate(LocalDate.of(2020,10,22))
                    .episodes(episodeSet).build();
            seasonSet.add(season);

            episode.setSeason(season);
            episode2.setSeason(season);

            Series series = Series.builder()
                    .name("numbers")
                    .releaseDate(LocalDate.of(2020,10,22))
                    .season(season)
                    .genres(Genres.ACTION)
                    .build();

            season.setSeries(series);
            seriesRepository.save(series);
        };
    }

}
