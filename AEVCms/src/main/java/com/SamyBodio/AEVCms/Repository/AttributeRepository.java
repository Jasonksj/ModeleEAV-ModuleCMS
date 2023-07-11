package com.SamyBodio.AEVCms.Repository;

import com.SamyBodio.AEVCms.model.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AttributeRepository extends JpaRepository<Attribute,UUID> {
    @Query("SELECT a FROM Attribute a WHERE a.title = :title")
    Optional<Attribute> getAttributeByTitle(String title);
    @Modifying
    @Query("DELETE FROM Attribute a WHERE a.title = :title")
    void deleteAttributeByTitle(String title);
}
