package com.teammatch.profile.service.impl;

import com.teammatch.profile.client.PlayerClient;
import com.teammatch.profile.entity.Profile;
import com.teammatch.profile.exception.ResourceNotFoundException;
import com.teammatch.profile.repository.ProfileRepository;
import com.teammatch.profile.service.ProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    PlayerClient playerClient;

    @Override
    public ResponseEntity<?> deleteProfile(Long profileId) {
        Profile profile = profileRepository.findById(profileId)
                .orElseThrow(() -> new ResourceNotFoundException("Profile", "Id", profileId));
        profileRepository.delete(profile);
        return ResponseEntity.ok().build();
    }

    @Override
    public Profile updateProfile(Long profileId, Profile profileRequest) {
        Profile profile = profileRepository.findById(profileId)
                .orElseThrow(() -> new ResourceNotFoundException("Profile", "Id", profileId));
        profile.setFullName(profileRequest.getFullName());
        profile.setUsername(profileRequest.getUsername());
        profile.setDescription(profileRequest.getDescription());
        profile.setGender(profileRequest.getGender());
        profile.setEmail(profileRequest.getEmail());
        profile.setPhoneNumber(profileRequest.getPhoneNumber());
        profile.setBirthDate(profileRequest.getBirthDate());
        return profileRepository.save(profile);
    }

    @Override
    public Profile createProfile(Long playerId, Profile profile) {
        this.validatePlayer(playerId);
        return profileRepository.save(profile);
    }

    @Override
    public Profile getProfileById(Long profileId) {
        return profileRepository.findById(profileId)
                .orElseThrow(() -> new ResourceNotFoundException("Profile", "Id", profileId));
    }

    @Override
    public Profile getProfileByUsername(String username) {
        return profileRepository.findByUsername(username);
    }

    public void validatePlayer(Long playerId) {
        if(playerClient.getPlayer(playerId).getStatusCode().is4xxClientError()){
            throw new ResourceNotFoundException(
                    "Player not found with Id " + playerId
            );
        }
    }
}
