package com.teammatch.profile.controller;

import com.teammatch.profile.client.PlayerClient;
import com.teammatch.profile.entity.Profile;
import com.teammatch.profile.resource.ProfileResource;
import com.teammatch.profile.resource.SaveProfileResource;
import com.teammatch.profile.service.ProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/profile/players")
@CrossOrigin

@Tag(name = "Profiles", description = "Profile API")
public class ProfileController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ProfileService profileService;

    //TODO: Conectar con player
    //@Autowired
    //private PlayerClient playerClient;

    @GetMapping("{id}/profiles")
    @Operation(summary = "Get Profile by Player Id", description = "Get Profile by the Player Id from Teammatch", tags = { "profiles" })
    public ProfileResource getProfileByPlayerId(@PathVariable(name = "id") Long playerId) {
        return convertToResource(profileService.getProfileById(playerId));
    }

    @GetMapping("{playerUsername}/profilesUsername") //TODO: revisar ruta
    @Operation(summary = "Get Profile by Player Username", description = "Get Profile by the Player Username from Teammatch", tags = { "profiles" })
    public ProfileResource getProfileByPlayerUsername(@PathVariable(name = "playerUsername") String playerUsername) {
        return convertToResource(profileService.getProfileByUsername(playerUsername));
    }

    @PostMapping("{id}/profiles")
    @Operation(summary = "Create Profile", description = "Create a new profile from player", tags = { "profiles" })
    public ProfileResource createProfile(@PathVariable(name = "id") Long playerId, @Valid @RequestBody SaveProfileResource resource)  {
        Profile profile = convertToEntity(resource);
        profile.setId(playerId);
        return convertToResource(profileService.createProfile(playerId, profile));
    }

    @PutMapping("{id}/profiles")
    @Operation(summary = "Update Profile", description = "Update a Profile from player", tags = { "profiles" })
    public ProfileResource updateProfile(@PathVariable(name = "id") Long playerId, @Valid @RequestBody SaveProfileResource resource) {
        Profile profile = convertToEntity(resource);
        return convertToResource(profileService.updateProfile(playerId, profile));
    }

    @DeleteMapping("{id}/profiles")
    @Operation(summary = "Delete a Profile", description = "Delete a profile from player", tags = { "profiles" })
    public ResponseEntity<?> deleteProfile(@PathVariable(name = "id") Long profileId) {
        return profileService.deleteProfile(profileId);
    }

    private Profile convertToEntity(SaveProfileResource resource) {
        return mapper.map(resource, Profile.class);
    }

    private ProfileResource convertToResource(Profile entity) {
        return mapper.map(entity, ProfileResource.class);
    }
}
