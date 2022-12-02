package com.dev.sandwichBar.controller;

import com.dev.sandwichBar.logic.SandwichService;
import com.dev.sandwichBar.sandwich.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/sandwiches")
public class SandwichController {


    private final Logger logger = LoggerFactory.getLogger(SandwichController.class);

    private SandwichRepository sandwichRepository;
    private ComponentRepository componentRepository;
    private SandwichService sandwichService;


    public SandwichController(SandwichRepository sandwichRepository, ComponentRepository componentRepository, SandwichService sandwichService) {
        this.sandwichRepository = sandwichRepository;
        this.componentRepository = componentRepository;
        this.sandwichService = sandwichService;
    }

    @PostMapping
    ResponseEntity<SandwichModel> createSandwich(@RequestBody String sandwichName) {
        logger.info("Add new sandwich");
        Sandwich sandwich = new Sandwich(sandwichName);
        SandwichModel result = sandwichService.createSandwich(sandwich);
        return ResponseEntity.created(URI.create("/" + sandwich.getId())).body(result);
    }

    @GetMapping
    public ResponseEntity<List<SandwichModel>> readAllSandwiches() {
        logger.info("Reading all sandwiches");
        return ResponseEntity.ok(sandwichService.readAll());
    }

    @PutMapping("/{id}")
    ResponseEntity<Boolean> addComponentToSandwich(@PathVariable int id,@RequestBody String compName) {

        if (!sandwichRepository.existsById(id) || compName.isBlank()) {
            return ResponseEntity.notFound().build();
        }

        Sandwich sandwich =  sandwichRepository.findById(id).get();
        SandwichComponent sandwichComponent = sandwichService.getComponent(compName, sandwich);


        if (sandwichComponent == null) {
            System.out.println("Error while adding component");
            return ResponseEntity.notFound().build();
        }

        System.out.println("Component added correctly");
        return ResponseEntity.ok(sandwich.addComponent(sandwichComponent));

    }

    @GetMapping("/{id}")
    ResponseEntity<SandwichModel> readSandwich(@PathVariable int id) {
        SandwichModel model = sandwichService.findById(id);
        if (model == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(model);
    }

}
