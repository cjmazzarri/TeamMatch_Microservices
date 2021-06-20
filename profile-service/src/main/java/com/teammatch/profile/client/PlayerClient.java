package com.teammatch.profile.client;

import com.teammatch.profile.model.Player;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "player-service", fallback = PlayerHystrixFallbackFactory.class)
@RequestMapping(value = "/players")
public interface PlayerClient {
    @GetMapping(value = "/{id}")
    ResponseEntity<Player> getPlayer(@PathVariable("id") long id);
}
