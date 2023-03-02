package com.gamepublishingproject.gpp.user.repository;

import com.gamepublishingproject.gpp.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
