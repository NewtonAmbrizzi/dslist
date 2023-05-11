package com.newton.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newton.dslist.dto.GameMinDTO;
import com.newton.dslist.entities.Game;
import com.newton.dslist.repositories.GameRepository;

@Service
public class GameService {

    @Autowired
    GameRepository gameRepository;

    public List<GameMinDTO> findAll() {
        List<Game> gameList = gameRepository.findAll();
        return gameList.stream().map(GameMinDTO::new).toList();
    }
    
}
