package com.codecool.jpaseries.entity;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Episode {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ElementCollection
    @Singular
    private List<String> actors;
    private Integer part;
    @Transient
    private Integer likes;
    private LocalDate releaseDate;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Season season;
}
