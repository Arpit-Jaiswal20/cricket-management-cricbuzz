package com.example.cricbuzz.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class TeamReponse {

    String name;

    int ranking;

    String coach;

}
