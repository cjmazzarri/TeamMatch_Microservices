package com.teammatch.matchmaking.service;

import com.teammatch.matchmaking.entity.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface TeamService {
    Team createTeam(Team team);
    Team getTeamById(Long teamId);
    Team updateTeam(Long teamId, Team teamRequest);
    ResponseEntity<?> deleteTeam(Long teamId);
    Page<Team> getAllTeams(Pageable pageable);
}