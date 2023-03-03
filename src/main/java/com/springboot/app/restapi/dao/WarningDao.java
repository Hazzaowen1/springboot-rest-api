package com.springboot.app.restapi.dao;

import com.springboot.app.restapi.model.Graph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarningDao extends JpaRepository<Graph, Long> {
    Graph findByType(String type);

}
