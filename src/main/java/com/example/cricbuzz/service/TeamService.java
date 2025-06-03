package com.example.cricbuzz.service;

import com.example.cricbuzz.convertor.TeamConvertor;
import com.example.cricbuzz.dto.request.TeamRequest;
import com.example.cricbuzz.dto.response.TeamReponse;
import com.example.cricbuzz.model.Team;
import com.example.cricbuzz.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    @Autowired
    TeamRepository teamRepository;

    public TeamReponse addTeam(TeamRequest teamRequest){

        Team team = TeamConvertor.teamRequestToTeam(teamRequest);
        Team savedTeam = teamRepository.save(team);

        return TeamConvertor.teamToTeamResponse(savedTeam);
    }
}
