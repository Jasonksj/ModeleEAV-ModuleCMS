package com.example.modeleEAV.repositories;

import com.example.modeleEAV.models.utilitiesEAV.AttributeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AttributeValuesRepository extends JpaRepository<AttributeValue, Long> {
}
