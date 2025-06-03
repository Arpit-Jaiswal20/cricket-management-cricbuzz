package com.example.cricbuzz.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class StatsResponse {

    int runs;

    int wickets;

    PlayerResponse player;
}
