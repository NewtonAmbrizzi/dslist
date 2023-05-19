package com.newton.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newton.dslist.dto.GameListDTO;
import com.newton.dslist.entities.GameList;
import com.newton.dslist.projections.GameMinProjection;
import com.newton.dslist.repositories.GameListRepository;
import com.newton.dslist.repositories.GameRepository;

@Service
public class GameListService {

    @Autowired
    GameListRepository gameListRepository;

    @Autowired
    GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(GameListDTO::new).toList();
    }
    
    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {
        
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection game = list.remove(sourceIndex);
        list.add(destinationIndex, game);

        int minIndex = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int maxIndex = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
        for (int i = minIndex; i <= maxIndex; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }

    }
}
