package com.example.cricbuzz.controller;


import com.example.cricbuzz.dto.request.TeamRequest;
import com.example.cricbuzz.dto.response.TeamReponse;
import com.example.cricbuzz.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apis/v1/team")
public class TeamController {

    @Autowired
    TeamService teamService;

    // there is fix data type so we can set datatype
    @PostMapping
    public ResponseEntity<TeamReponse> addTeam(@RequestBody TeamRequest teamRequest){

        return new ResponseEntity(teamService.addTeam(teamRequest), HttpStatus.CREATED);
    }
}
