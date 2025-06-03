package com.example.cricbuzz.model;

import com.example.cricbuzz.model.Enum.Gender;
import com.example.cricbuzz.model.Enum.Speciality;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    int age;

    String email;

    @Enumerated(EnumType.STRING)
    Speciality speciality;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @OneToOne(mappedBy = "player",cascade = CascadeType.ALL)
            @JsonManagedReference
    Stats stats;

    @JoinColumn
    @ManyToOne
            @JsonManagedReference
    Team team;

}
