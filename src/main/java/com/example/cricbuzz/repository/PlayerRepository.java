package com.example.cricbuzz.repository;

import com.example.cricbuzz.model.Enum.Gender;
import com.example.cricbuzz.model.Enum.Speciality;
import com.example.cricbuzz.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player,Integer> {

    // custom method
    List<Player> findByGenderAndAgeGreaterThan(Gender gender, int age);

    // Query
    // a) - native query = true
//    @Query(value = "select * from player where gender = :gender AND speciality = :speciality", nativeQuery = true)
//    List<Player> getByGenderAndSpeciality(String gender,String speciality);


    // b) - native query = false
    // JPQL - java persistent query language
    @Query(value = "select p from Player p where p.gender = :gender AND p.speciality = :speciality", nativeQuery = false)
    List<Player> getByGenderAndSpeciality(Gender gender, Speciality speciality);

}
