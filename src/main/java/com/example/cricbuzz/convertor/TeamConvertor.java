package com.example.cricbuzz.convertor;

import com.example.cricbuzz.dto.request.TeamRequest;
import com.example.cricbuzz.dto.response.TeamReponse;
import com.example.cricbuzz.model.Team;

public class TeamConvertor {

    public static Team teamRequestToTeam(TeamRequest teamRequest){

        return  Team.builder()
                .name(teamRequest.getName())
                .ranking(teamRequest.getRanking())
                .iccPoints(teamRequest.getIccPoints())
                .coach(teamRequest.getCoach())
                .matchesPlayed(0)
                .build();
    }

    public static TeamReponse teamToTeamResponse(Team team){
        return TeamReponse.builder()
                .name(team.getName())
                .ranking(team.getRanking())
                .coach(team.getCoach())
                .build();
    }
}
