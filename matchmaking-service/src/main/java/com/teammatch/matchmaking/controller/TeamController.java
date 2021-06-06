package com.teammatch.matchmaking.controller;

import com.teammatch.matchmaking.entity.Team;
import com.teammatch.matchmaking.resource.SaveTeamResource;
import com.teammatch.matchmaking.resource.TeamResource;
import com.teammatch.matchmaking.service.TeamService;
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
@RequestMapping("/api/")
@CrossOrigin
public class TeamController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private TeamService teamService;

    @PostMapping("/teams")
    public TeamResource createTeam(@RequestBody @Valid SaveTeamResource resource){
        Team team = convertToEntity(resource);
        return convertToResource(teamService.createTeam(team));
    }

    @GetMapping("/teams/{id}")
    public TeamResource getTeamById(@PathVariable(name = "id") Long teamId){
        return convertToResource(teamService.getTeamById(teamId));
    }

    @GetMapping("/teams")
    public Page<TeamResource> getAllTeams(Pageable pageable){
        Page<Team> teamsPage = teamService.getAllTeams(pageable);
        List<TeamResource> resources = teamsPage.getContent().stream().map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @PutMapping("/teams/{id}")
    public TeamResource updateTeam(@PathVariable(name = "id") Long teamId, @Valid @RequestBody SaveTeamResource resource){
        Team team = convertToEntity(resource);
        return convertToResource(teamService.updateTeam(teamId, team));
    }

    @DeleteMapping("/teams/{id}")
    public ResponseEntity<?> deleteTeam(@PathVariable(name = "id") Long teamId){
        return teamService.deleteTeam(teamId);
    }

    private TeamResource convertToResource(Team entity){
        return mapper.map(entity, TeamResource.class);
    }

    private Team convertToEntity(SaveTeamResource resource) {
        return mapper.map(resource, Team.class);
    }
}
