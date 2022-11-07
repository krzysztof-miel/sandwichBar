package com.dev.sandwichBar.adapter;

import com.dev.sandwichBar.sandwich.SandwichComponent;
import com.dev.sandwichBar.sandwich.SandwichComponentRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SandwichComponentRepositoryAdapter extends SandwichComponentRepository, JpaRepository<SandwichComponent,Integer> {

    @Override
    Optional<SandwichComponent> findByNameIgnoreCase(String name);
}
