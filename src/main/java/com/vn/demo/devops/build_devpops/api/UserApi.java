package com.vn.demo.devops.build_devpops.api;

import com.vn.demo.devops.build_devpops.dto.UserRequest;
import com.vn.demo.devops.build_devpops.dto.UserResponse;

import java.util.List;

public interface UserApi {
     void create(UserRequest request);
     List<UserResponse> getUsers();
}
