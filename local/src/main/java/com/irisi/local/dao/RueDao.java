package com.irisi.local.dao;

import com.irisi.local.bean.Local;
import com.irisi.local.bean.Rue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RueDao extends JpaRepository<Rue,Long> {

    Rue findByRef(String ref);
}
