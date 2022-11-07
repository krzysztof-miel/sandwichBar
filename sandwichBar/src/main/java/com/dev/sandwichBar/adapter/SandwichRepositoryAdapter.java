package com.dev.sandwichBar.adapter;

import com.dev.sandwichBar.sandwich.Sandwich;
import com.dev.sandwichBar.sandwich.SandwichRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SandwichRepositoryAdapter extends SandwichRepository, JpaRepository<Sandwich, Integer> {
}
