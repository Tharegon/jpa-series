package com.codecool.jpaseries.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Season {
    @Id
    @GeneratedValue
    private Long id;
    private Integer numberOfSeason;
    private LocalDate releaseDate;
    @OneToMany(mappedBy = "season", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<Episode> episodes;
}
