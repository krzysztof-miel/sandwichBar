package com.dev.sandwichBar.sandwich;

import java.util.List;
import java.util.Optional;

public interface ComponentRepository {

    List<Component> findAll();

    Optional<Component> findById(Integer id);

    Component save (Component entity);

    Optional<Component> findByNameIgnoreCase(String name);





}
