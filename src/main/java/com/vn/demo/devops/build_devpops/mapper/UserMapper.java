package com.vn.demo.devops.build_devpops.mapper;

import com.vn.demo.devops.build_devpops.dto.UserRequest;
import com.vn.demo.devops.build_devpops.dto.UserResponse;
import com.vn.demo.devops.build_devpops.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity mapToUserEntity(UserRequest request);
    UserResponse mapToUserResponse(UserEntity user);
}
