package com.teammatch.matchmaking.service;

import com.teammatch.matchmaking.entity.Player;
import com.teammatch.matchmaking.model.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface PlayerService {
    ResponseEntity<?> deletePlayer(Long playerId);
    Player updatePlayer(Long playerId, Player playerRequest);
    Player createPlayer(Player player);
    Player getPlayerById(Long playerId);
    Player getPlayerByUsername(String username);
    Page<Player> getAllPlayers(Pageable pageable);
    Player login(Player player);
    Player updateLastConnection(Long playerId);
}