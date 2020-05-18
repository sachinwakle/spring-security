package io.sawa.security.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.sawa.security.app.model.UserInfo;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {

    Optional<UserInfo> findByUserName(String userName);

}
