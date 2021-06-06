package com.teammatch.profile.repository;

import com.teammatch.profile.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Profile findByFullName(String fullname);
    Profile findByUsername(String username);
    Profile findByEmail(String email);
    Profile findByPhoneNumber(String phoneNumber);
}
