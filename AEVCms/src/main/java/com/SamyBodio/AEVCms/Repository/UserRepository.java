package com.SamyBodio.AEVCms.Repository;

import com.SamyBodio.AEVCms.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
