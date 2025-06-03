package com.example.cricbuzz.convertor;

import com.example.cricbuzz.dto.request.StatsRequest;
import com.example.cricbuzz.dto.response.StatsResponse;
import com.example.cricbuzz.model.Stats;

public class StatsConvertor {

    public static Stats statsRequestToStats(StatsRequest statsRequest){

        return Stats.builder()
                .runs(statsRequest.getRuns())
                .wickets(statsRequest.getWickets())
                .battingAverage(statsRequest.getBattingAverage())
                .bowlingAverage(statsRequest.getBowlingAverage())
                .build();
    }

    public static StatsResponse statsToStatsResponse(Stats stats){

        return StatsResponse.builder()
                .runs(stats.getRuns())
                .wickets(stats.getWickets())
                .player(PlayerConvertor.playerToPlayerResponse(stats.getPlayer()))
                .build();
    }
}
