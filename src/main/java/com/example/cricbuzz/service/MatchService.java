package com.example.cricbuzz.service;

import com.example.cricbuzz.convertor.MatchConvertor;
import com.example.cricbuzz.dto.request.MatchRequest;
import com.example.cricbuzz.dto.response.MatchReponse;
import com.example.cricbuzz.dto.response.TeamReponse;
import com.example.cricbuzz.exception.TeamNotFoundException;
import com.example.cricbuzz.model.CricketMatch;
import com.example.cricbuzz.model.Team;
import com.example.cricbuzz.repository.MatchRepository;
import com.example.cricbuzz.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MatchService {

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    MatchRepository matchRepository;

    public MatchReponse registerMatch(MatchRequest matchRequest, int teamAId, int teamBId){

        Optional<Team>optionalTeamA = teamRepository.findById(teamAId);
        Optional<Team>optionalTeamB = teamRepository.findById(teamBId);

        if(optionalTeamA.isEmpty() || optionalTeamB.isEmpty()){
            throw new TeamNotFoundException("One or more team id(s) is not valid");
        }

        Team teamA = optionalTeamA.get();
        Team teamB = optionalTeamB.get();

        CricketMatch match = MatchConvertor.matchRequestToMatch(matchRequest);
        match.getTeams().add(teamA);
        match.getTeams().add(teamB);

        teamA.setMatchesPlayed(teamA.getMatchesPlayed()+1);
        teamA.getMatches().add(match);

        teamB.setMatchesPlayed(teamB.getMatchesPlayed()+1);
        teamB.getMatches().add(match);


        CricketMatch savedMatch = matchRepository.save(match);
        teamRepository.save(teamA);
        teamRepository.save(teamB);

        return MatchConvertor.matchToMatchResponse(savedMatch);
    }
}
