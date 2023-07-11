package com.SamyBodio.AEVCms.Repository;

import com.SamyBodio.AEVCms.model.AttributeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeValueRepository extends JpaRepository<AttributeValue,Long> {
}
