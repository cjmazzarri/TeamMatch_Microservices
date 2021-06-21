package com.teammatch.matchmaking.client;
import com.teammatch.matchmaking.model.Profile;
import org.springframework.http.ResponseEntity;

public class ProfileHystrixFallbackFactory implements ProfileClient {
    @Override
    public ResponseEntity<Profile> getProfile(long id) {
        Profile profile = Profile.builder()
                .fullName("none")
                .username("none")
                .description("none")
                .gender("none")
                .email("none")
                .phoneNumber("none")
                .birthDate("none").build();
        return ResponseEntity.ok(profile);
    }
}
