package com.example.modeleEAV.repositories;

import com.example.modeleEAV.models.utilitiesEAV.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

//public interface AttributeRepository extends JpaRepository<Attribute, UUID> {
@Repository
public interface AttributeRepository extends JpaRepository<Attribute, Long> {

    @Query("SELECT s.title FROM Attribute s ")
    List<Attribute> findAttributeByTitle();
    @Query("SELECT s FROM Attribute s WHERE s.title = ?1")
    Optional<Attribute> findAttributeByTitle(String title);
    @Query(
            value = "SELECT * FROM Attribute s WHERE s.attribute_set_id = :attributeSetId",
            nativeQuery = true
    )
    Optional<List<Attribute>> findByAttributeSetId(
            @Param("attributeSetId") Long attributeSetId
    );
}
