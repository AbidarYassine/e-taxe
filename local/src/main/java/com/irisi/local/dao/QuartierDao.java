package com.irisi.local.dao;

import com.irisi.local.bean.Local;
import com.irisi.local.bean.Quartier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuartierDao extends JpaRepository<Quartier,Long> {


}
