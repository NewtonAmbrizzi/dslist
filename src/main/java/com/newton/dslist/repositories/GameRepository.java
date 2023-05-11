package com.newton.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.newton.dslist.entities.Game;

public interface GameRepository extends JpaRepository <Game, Long>{
    
}
