package com.teammatch.matchmaking.controller;

import com.teammatch.matchmaking.entity.Game;
import com.teammatch.matchmaking.resource.GameResource;
import com.teammatch.matchmaking.resource.SaveGameResource;
import com.teammatch.matchmaking.service.GameService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/matchmaking")
@CrossOrigin
public class GameController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private GameService gameService;

    @GetMapping("/games")
    public Page<GameResource> getAllGames(Pageable pageable) {
        Page<Game> gamesPage = gameService.getAllGames(pageable);
        List<GameResource> resources = gamesPage.getContent().stream().map(this::convertToResource).collect(Collectors.toList());

        return new PageImpl<>(resources, pageable, resources.size());
    }

    @GetMapping("/games/{id}")
    public GameResource getGameById(@PathVariable(name = "id") Long gameId) {
        return convertToResource(gameService.getGameById(gameId));
    }

    @PostMapping("/games")
    public GameResource createGame(@Valid @RequestBody SaveGameResource resource)  {
        Game game = convertToEntity(resource);
        return convertToResource(gameService.createGame(game));
    }

    @PutMapping("/games/{id}")
    public GameResource updateGame(@PathVariable(name = "id") Long gameId, @Valid @RequestBody SaveGameResource resource) {
        Game game = convertToEntity(resource);
        return convertToResource(gameService.updateGame(gameId, game));
    }

    @DeleteMapping("/games/{id}")
    public ResponseEntity<?> deleteGame(@PathVariable(name = "id") Long gameId) {
        return gameService.deleteGame(gameId);
    }

    private Game convertToEntity(SaveGameResource resource) {
        return mapper.map(resource, Game.class);
    }

    private GameResource convertToResource(Game entity) {
        return mapper.map(entity, GameResource.class);
    }
}
