package com.vn.demo.devops.build_devpops.repository;

import com.vn.demo.devops.build_devpops.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
}
