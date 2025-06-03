package com.example.cricbuzz.convertor;

import com.example.cricbuzz.dto.request.MatchRequest;
import com.example.cricbuzz.dto.response.MatchReponse;
import com.example.cricbuzz.dto.response.TeamReponse;
import com.example.cricbuzz.model.CricketMatch;

import java.util.ArrayList;
import java.util.List;

public class MatchConvertor {

    public  static CricketMatch matchRequestToMatch(MatchRequest matchRequest){
        return CricketMatch.builder()
                .title(matchRequest.getTitle())
                .venue(matchRequest.getVenue())
                .teams(new ArrayList<>())
                .build();
    }

    public static MatchReponse matchToMatchResponse(CricketMatch match){

        List<TeamReponse> teams = new ArrayList<>();
        teams.add(TeamConvertor.teamToTeamResponse(match.getTeams().get(0)));
        teams.add(TeamConvertor.teamToTeamResponse(match.getTeams().get(1)));

        return MatchReponse.builder()
                .title(match.getTitle())
                .venue(match.getVenue())
                .created(match.getCreated())
                .teams(teams)
                .build();
    }
}
