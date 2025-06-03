package com.example.cricbuzz.dto.request;

import com.example.cricbuzz.model.Enum.Gender;
import com.example.cricbuzz.model.Enum.Speciality;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PlayerRequest {

    String name;

    int age;

    Speciality speciality;

    Gender gender;

    String email;
}
