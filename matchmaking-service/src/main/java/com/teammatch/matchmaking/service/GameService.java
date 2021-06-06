package com.teammatch.matchmaking.service;

import com.teammatch.matchmaking.entity.Game;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface GameService {
    ResponseEntity<?> deleteGame(Long gameId);
    Game updateGame(Long gameId, Game gameRequest);
    Game createGame(Game game);
    Game getGameById(Long gameId);
    Page<Game> getAllGames(Pageable pageable);
}