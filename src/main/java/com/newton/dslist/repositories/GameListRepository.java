package com.newton.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.newton.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {
    
}
