package com.vn.demo.devops.build_devpops.service;

import com.vn.demo.devops.build_devpops.api.UserApi;
import com.vn.demo.devops.build_devpops.dto.UserRequest;
import com.vn.demo.devops.build_devpops.dto.UserResponse;
import com.vn.demo.devops.build_devpops.mapper.UserMapper;
import com.vn.demo.devops.build_devpops.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements UserApi {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public void create(UserRequest request) {
        userRepository.save(userMapper.mapToUserEntity(request));
    }

    @Override
    public List<UserResponse> getUsers() {
        return userRepository.findAll().stream().map(userMapper::mapToUserResponse).collect(Collectors.toList());
    }
}
