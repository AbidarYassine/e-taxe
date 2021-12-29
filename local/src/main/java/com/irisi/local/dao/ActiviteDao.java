package com.irisi.local.dao;

import com.irisi.local.bean.Activite;
import com.irisi.local.bean.Redevable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActiviteDao extends JpaRepository<Activite,Long> {

    Activite findByRef(String ref);

}
