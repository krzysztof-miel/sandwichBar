package com.dev.sandwichBar.sandwich;

import java.util.Optional;

public interface SandwichComponentRepository {

    SandwichComponent save(SandwichComponent result);

    Optional<SandwichComponent> findByNameIgnoreCase(String name);
}
