package com.springboot.app.restapi.dao;

import com.springboot.app.restapi.model.Threat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThreatDao extends JpaRepository<Threat, Long> {}
