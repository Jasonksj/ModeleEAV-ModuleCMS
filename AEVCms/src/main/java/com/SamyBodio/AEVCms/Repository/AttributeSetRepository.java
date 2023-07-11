package com.SamyBodio.AEVCms.Repository;

import com.SamyBodio.AEVCms.model.AttributeSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeSetRepository extends JpaRepository<AttributeSet,Long> {
}
