package com.teammatch.communication.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "communication-service")
@RequestMapping(value = "/communications")
public interface PlayerClient {
    //Aqui colocar todos los metodos a utilizar
}
