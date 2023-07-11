package com.SamyBodio.AEVCms.Repository;

import com.SamyBodio.AEVCms.model.Entity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EntityRepository extends JpaRepository<Entity, UUID> {
}
