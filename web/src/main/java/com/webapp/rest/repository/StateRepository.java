package com.webapp.rest.repository;

import com.modelsale.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(path = "/state")
public interface StateRepository extends JpaRepository<State, Integer> {
}
