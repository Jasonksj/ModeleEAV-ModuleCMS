package com.example.modeleEAV.repositories;

import com.example.modeleEAV.models.utilitiesEAV.Attribute;
import com.example.modeleEAV.models.utilitiesEAV.AttributeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AttributeValuesRepository extends JpaRepository<AttributeValue, UUID> {

    @Query("SELECT s FROM AttributeValue s WHERE s.title = ?1")
    Optional<AttributeValue> findAttributeValuesByTitle(String title);
}
