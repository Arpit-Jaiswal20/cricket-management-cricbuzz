package com.example.cricbuzz.repository;

import com.example.cricbuzz.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team,Integer> {


}
