package com.teammatch.profile.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "profile-service")
@RequestMapping(value = "/profiles")
public interface ProfileService {
    //TODO: Implementar los metodos a utilizar
}
