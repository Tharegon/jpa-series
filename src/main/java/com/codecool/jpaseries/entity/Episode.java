package com.codecool.jpaseries.entity;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDate;

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
    private Integer part;
    private LocalDate releaseDate;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Season season;
}
