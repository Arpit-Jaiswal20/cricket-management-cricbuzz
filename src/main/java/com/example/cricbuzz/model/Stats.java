package com.example.cricbuzz.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE) // all the entity will be private
@Entity
@Builder

public class Stats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int runs;

    int wickets;

    double battingAverage;

    double bowlingAverage;

    @OneToOne
    @JoinColumn
            @JsonBackReference
    Player player;

}
