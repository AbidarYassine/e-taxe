package com.irisi.local.dao;

import com.irisi.local.bean.Local;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalDao  extends JpaRepository<Local,Long> {
    Local findByRef(String ref);
    boolean existsByRef(String ref);
}
