package com.vn.demo.devops.build_devpops.controller;

import com.vn.demo.devops.build_devpops.api.UserApi;
import com.vn.demo.devops.build_devpops.dto.UserRequest;
import com.vn.demo.devops.build_devpops.dto.UserResponse;
import com.vn.demo.devops.build_devpops.entity.UserEntity;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController implements UserApi {
    private final UserApi userApi;

    @PostMapping
    @Override
    public void create(@RequestBody @Valid UserRequest request) {
        userApi.create(request);
    }

    @Override
    @GetMapping
    public List<UserResponse> getUsers() {
        return userApi.getUsers();
    }

    @Override
    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable(name = "id") Long userId) {
        return userApi.getUser(userId);
    }

    @Override
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        userApi.deleteUser(userId);
    }

    @Override
    @PutMapping("/{userId}")
    public void updateUser(@RequestBody @Valid UserEntity user,@PathVariable(name = "userId") Long userId) {
         userApi.updateUser(user, userId);
    }
}
