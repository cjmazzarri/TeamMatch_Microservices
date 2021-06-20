package com.teammatch.profile.client;

import com.teammatch.profile.model.Player;
import org.springframework.http.ResponseEntity;

public class PlayerHystrixFallbackFactory implements PlayerClient{

    @Override
    public ResponseEntity<Player> getPlayer(long id) {
        Player player = Player.builder()
                .username("none")
                .hours(0)
                .last_connection("none").build();
        return ResponseEntity.ok(player);
    }
}
