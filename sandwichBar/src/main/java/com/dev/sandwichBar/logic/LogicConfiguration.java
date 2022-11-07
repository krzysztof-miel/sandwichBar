package com.dev.sandwichBar.logic;

import com.dev.sandwichBar.sandwich.ComponentRepository;
import com.dev.sandwichBar.sandwich.SandwichComponentRepository;
import com.dev.sandwichBar.sandwich.SandwichRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogicConfiguration {

    @Bean
    SandwichService sandwichComponentService(
            ComponentRepository componentRepository,
            SandwichRepository sandwichRepository,
            SandwichComponentRepository sandwichComponentRepository
    ) {
        return new SandwichService(componentRepository, sandwichRepository, sandwichComponentRepository);
    }


}
