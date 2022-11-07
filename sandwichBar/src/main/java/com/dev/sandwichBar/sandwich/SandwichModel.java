package com.dev.sandwichBar.sandwich;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class SandwichModel {
    private int id;
    private String name;
    private Set<SandwichComponent> sandwichComponentSet;
    private double price;


    public SandwichModel(int id, String name, Set<SandwichComponent> sandwichComponentSet) {
        this.id = id;
        this.name = name;
        this.sandwichComponentSet = sandwichComponentSet;
    }

    public SandwichModel(Sandwich sandwich) {
        name = sandwich.getName();
        sandwichComponentSet = sandwich.getSandwichComponents();
    }

    public SandwichModel(String name) {
        this.name = name;
    }

    public Sandwich toSandwich() {
        return new Sandwich(name);
    }
}
