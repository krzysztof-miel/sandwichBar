package com.dev.sandwichBar.sandwich;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "sandwichComponents")
public class SandwichComponent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Double price;
    @ManyToOne
    @JoinColumn(name = "sandwich_id")
    @JsonBackReference
    private Sandwich sandwich;

    public SandwichComponent() {}

    public SandwichComponent(String name, Double price, Sandwich sandwich) {
        this.name = name;
        this.price = price;
        if (sandwich != null) {
            this.sandwich = sandwich;
        }
    }

    public SandwichComponent(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public SandwichComponent(String name) {
        this.name = name;
    }


    public SandwichComponent toSandwichComponent(Component component, Sandwich sandwich) {
        this.setName(component.getName());
        this.setPrice(component.getPrice());
        this.setSandwich(sandwich);

        return this;
    }

}
