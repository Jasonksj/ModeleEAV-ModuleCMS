package com.example.modeleEAV.repositories;

import com.example.modeleEAV.models.utilitiesEAV.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

//public interface AttributeRepository extends JpaRepository<Attribute, UUID> {
@Repository
public interface AttributeRepository extends JpaRepository<Attribute, Long> {
    @Query("SELECT s FROM Attribute s WHERE s.title = ?1")
    Optional<Attribute> findAttributeByTitle(String title);

    @Query("SELECT a FROM Attribute a WHERE a.attributeSet.id = :attributeSetId")
    Optional<List<Attribute>> findByAttributeSetId(Long attributeSetId);
}
