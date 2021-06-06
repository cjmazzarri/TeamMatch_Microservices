package com.teammatch.profile.service;

import com.teammatch.profile.entity.Profile;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProfileService {
    ResponseEntity<?> deleteProfile(Long profileId);
    Profile updateProfile(Long profileId, Profile profileRequest);
    Profile createProfile(Long profileId, Profile profile);
    Profile getProfileById(Long profileId);
    Profile getProfileByUsername(String username);
}
