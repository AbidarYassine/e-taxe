package com.irisi.local.dao;

import com.irisi.local.bean.Redevable;
import com.irisi.local.bean.Redevable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RedevableDao extends JpaRepository<Redevable,Long> {
    Redevable findByRef(String ref);
    boolean existsByRef(String ref);
}
