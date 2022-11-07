package com.dev.sandwichBar.adapter;

import com.dev.sandwichBar.sandwich.Component;
import com.dev.sandwichBar.sandwich.ComponentRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ComponentRepositoryAdapter extends ComponentRepository, JpaRepository<Component, Integer> {

    @Override
    Optional<Component> findByNameIgnoreCase(String name);
}
