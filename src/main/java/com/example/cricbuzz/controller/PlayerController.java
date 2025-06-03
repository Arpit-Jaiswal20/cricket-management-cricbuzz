package com.example.cricbuzz.controller;

import com.example.cricbuzz.dto.request.PlayerRequest;
import com.example.cricbuzz.dto.response.PlayerResponse;
import com.example.cricbuzz.exception.PlayerNotFoundException;
import com.example.cricbuzz.model.Enum.Gender;
import com.example.cricbuzz.model.Enum.Speciality;
import com.example.cricbuzz.service.PlayerService;
import org.apache.coyote.Response;
import org.aspectj.weaver.loadtime.Agent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apis/v1/player")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @PostMapping
    public ResponseEntity addPlayer(@RequestBody PlayerRequest playerRequest){

        return  new ResponseEntity<>(playerService.addPlayer(playerRequest),HttpStatus.CREATED);

    }

    @GetMapping("/id/{id}")
    public ResponseEntity getPlayerById(@PathVariable("id") int id){

        try{
            return new ResponseEntity<>(playerService.getPlayerById(id),HttpStatus.OK);
        }
        catch(PlayerNotFoundException p){
            return new ResponseEntity<>(p.getMessage(),HttpStatus.BAD_REQUEST);
        }
//        return playerService.getPlayerById(id);
    }

    // gender and age -> MALE , 35 -> custom method
    @GetMapping("/gender/{gender}/age/{age}")
    public List<PlayerResponse> getByGenderAndGreaterThan(@PathVariable("gender")Gender gender,
                                                         @PathVariable("age")int age){
        return playerService.getByGenderAndAgeGreaterThan(gender,age);

    }

    // speciality and gender -> BATTER, MALE -> @Query
    @GetMapping("/gender/{gender}/speciality/{speciality}")
    public List<PlayerResponse> getByGenderAndSpeciality(@PathVariable("gender") Gender gender,
                                                         @PathVariable("speciality") Speciality speciality){

        return playerService.getByGenderAndSpeciality(gender,speciality);
    }

}
