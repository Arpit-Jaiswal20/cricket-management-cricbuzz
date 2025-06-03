package com.example.cricbuzz.controller;

import com.example.cricbuzz.dto.request.StatsRequest;
import com.example.cricbuzz.dto.response.StatsResponse;
import com.example.cricbuzz.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apis/v1/stats")

public class StatsController {

    @Autowired
    StatsService statsService;

    @PostMapping
    public StatsResponse addStats(@RequestBody StatsRequest statsRequest,
                                  @RequestParam("player-id") int playerId){

        return statsService.addStats(statsRequest,playerId);
    }
}
