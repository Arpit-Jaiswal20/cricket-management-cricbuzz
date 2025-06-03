package com.example.cricbuzz.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class StatsRequest {

    int runs;

    int wickets;

    double battingAverage;

    double bowlingAverage;
}
