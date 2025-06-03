package com.example.cricbuzz.dto.response;

import com.example.cricbuzz.model.Enum.Speciality;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class PlayerResponse {
    String name;

    Speciality speciality;
}

