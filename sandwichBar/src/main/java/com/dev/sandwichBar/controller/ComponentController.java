package com.dev.sandwichBar.controller;

import com.dev.sandwichBar.sandwich.Component;
import com.dev.sandwichBar.sandwich.ComponentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class ComponentController {

    private final Logger logger = LoggerFactory.getLogger(ComponentController.class);

    private ComponentRepository componentRepository;

    public ComponentController(ComponentRepository componentRepository) {
        this.componentRepository = componentRepository;
    }

    @GetMapping
    public ResponseEntity<List<Component>> readAllComponents() {
        logger.info("Reading all components");
        return ResponseEntity.ok(componentRepository.findAll());
    }

    @GetMapping("/{name}")
    public ResponseEntity<Component> findComponentByName(@PathVariable String name) {

        return componentRepository.findByNameIgnoreCase(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

}
