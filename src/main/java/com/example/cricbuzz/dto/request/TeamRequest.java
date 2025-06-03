package com.example.cricbuzz.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class TeamRequest {

    String name;

    int ranking;

    int iccPoints;

    String coach;

}
