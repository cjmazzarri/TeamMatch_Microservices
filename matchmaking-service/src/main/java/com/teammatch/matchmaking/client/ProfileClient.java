package com.teammatch.matchmaking.client;
import com.teammatch.matchmaking.model.Profile;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "profile-service", fallback = ProfileHystrixFallbackFactory.class)
@RequestMapping(value = "/profiles")
public interface ProfileClient {
    @GetMapping(value = "/{id}")
    ResponseEntity<Profile> getProfile(@PathVariable("id") long id);
}
