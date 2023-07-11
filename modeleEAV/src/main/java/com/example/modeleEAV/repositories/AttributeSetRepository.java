package com.example.modeleEAV.repositories;

import com.example.modeleEAV.models.utilitiesEAV.Attribute;
import com.example.modeleEAV.models.utilitiesEAV.AttributeSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AttributeSetRepository extends JpaRepository<AttributeSet, Long> {
    @Query("SELECT s FROM AttributeSet s WHERE s.title = ?1")
    Optional<AttributeSet> findAttributeSetByTitle(String title);

    @Query("SELECT s FROM Attribute s WHERE s.id = ?1")
    Optional<AttributeSet> findAttributeByAttributSetId(Long id);
}
