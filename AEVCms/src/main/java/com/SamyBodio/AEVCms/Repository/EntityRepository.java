package com.SamyBodio.AEVCms.Repository;

import com.SamyBodio.AEVCms.model.Entity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EntityRepository extends JpaRepository<Entity, UUID> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO entity_attribute(attribute_id,entity_id)" +
            " VALUES(:attribute_id,:entity_id)",nativeQuery = true)
    void insertEntityInAttribute(@Param("attribute_id") UUID attributeId,
                                 @Param("entity_id") UUID entityId);

}
