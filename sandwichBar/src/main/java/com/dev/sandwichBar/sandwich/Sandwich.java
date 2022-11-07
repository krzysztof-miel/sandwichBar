package com.dev.sandwichBar.sandwich;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "sandwiches")
public class Sandwich {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sandwich")
    @JsonManagedReference
    private Set<SandwichComponent> sandwichComponents;

    public Sandwich(String name) {
        this.name = name;
    }

    public boolean addComponent(SandwichComponent sandwichComponent) {
        sandwichComponents.add(sandwichComponent);
        return true;
    }

}
