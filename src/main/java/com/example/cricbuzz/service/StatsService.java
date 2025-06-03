package com.example.cricbuzz.service;

import com.example.cricbuzz.convertor.StatsConvertor;
import com.example.cricbuzz.dto.request.StatsRequest;
import com.example.cricbuzz.dto.response.StatsResponse;
import com.example.cricbuzz.exception.PlayerNotFoundException;
import com.example.cricbuzz.model.Player;
import com.example.cricbuzz.model.Stats;
import com.example.cricbuzz.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class StatsService {

    @Autowired
    PlayerRepository playerRepository;


    public StatsResponse addStats(StatsRequest statsRequest, int playerId) {

        Optional<Player> optionalPlayer = playerRepository.findById(playerId);
        if(optionalPlayer.isEmpty()){
            throw new PlayerNotFoundException("Invalid player id");
        }

        Player player = optionalPlayer.get();

        Stats stats = StatsConvertor.statsRequestToStats(statsRequest);

        player.setStats(stats);
        stats.setPlayer(player);

        Player savedPlayer = playerRepository.save(player);   //save both player and stats because player have cascade

        return StatsConvertor.statsToStatsResponse(savedPlayer.getStats());
    }
}
