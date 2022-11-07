package com.dev.sandwichBar.sandwich;

import java.util.List;
import java.util.Optional;

public interface SandwichRepository {

    List<Sandwich> findAll();

    Optional<Sandwich> findById(Integer id);

    boolean existsById (Integer id);

    Sandwich save (Sandwich entity);


}

