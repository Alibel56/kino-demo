package com.practice.kino.controller;

import com.practice.kino.dto.request.CreateUserRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "user-service",
        url = "${services.user-service.url}",
        path = "/users"
)
public interface UserClient {

    @PostMapping("/profile")
    void createUser(@RequestBody CreateUserRequest request);
}
