package com.example.cricbuzz.repository;

import com.example.cricbuzz.model.CricketMatch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<CricketMatch,Integer> {
}
