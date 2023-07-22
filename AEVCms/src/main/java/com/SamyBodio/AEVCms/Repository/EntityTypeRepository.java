package com.SamyBodio.AEVCms.Repository;

import com.SamyBodio.AEVCms.model.Entity_Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EntityTypeRepository extends JpaRepository<Entity_Type, UUID> {
}
