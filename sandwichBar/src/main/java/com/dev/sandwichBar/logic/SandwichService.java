package com.dev.sandwichBar.logic;

import com.dev.sandwichBar.sandwich.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;


public class SandwichService {

    private ComponentRepository componentRepository;
    private SandwichRepository sandwichRepository;
    private SandwichComponentRepository sandwichComponentRepository;

    public SandwichService(ComponentRepository componentRepository, SandwichRepository sandwichRepository, SandwichComponentRepository sandwichComponentRepository) {
        this.componentRepository = componentRepository;
        this.sandwichRepository = sandwichRepository;
        this.sandwichComponentRepository = sandwichComponentRepository;
    }

    public SandwichModel createSandwich(Sandwich toCreate) {
        Sandwich sandwich = sandwichRepository.save(toCreate);
        return new SandwichModel(sandwich);
    }

    public List<SandwichModel> readAll() {
        List<SandwichModel> sandwichModelList = new ArrayList<>();
        List<Sandwich> sandwichList = sandwichRepository.findAll();

        for (Sandwich sandwich: sandwichList) {
            SandwichModel model = new SandwichModel(
                    sandwich.getId(),
                    sandwich.getName(),
                    sandwich.getSandwichComponents(),
                    checkSandwichPrice(sandwich));

            sandwichModelList.add(model);
        }

        return sandwichModelList;
    }

    public SandwichModel findById(int id) {
        Optional<Sandwich> sandwich = sandwichRepository.findById(id);
        if (sandwich.isEmpty()){
            return null;
        }
        return new SandwichModel(sandwich.get().getId() ,sandwich.get().getName(), sandwich.get().getSandwichComponents(), checkSandwichPrice(sandwich.get()));
    }

    public SandwichComponent getComponent(String name, Sandwich sandwich) {
        List<Component> componentList = componentRepository.findAll();

        Component temp = new Component();

        for (Component comp : componentList) {
            if (comp.getName().toLowerCase().equals(name.toLowerCase()) ) {
                temp  = comp;
                System.out.println(temp.getName());
            }
        }
        String existChecker =  sandwich.getSandwichComponents().stream()
                .map(comp -> comp.getName())
                .filter(sandwichComponentName -> name.toLowerCase().equals(sandwichComponentName.toLowerCase()))
                .findAny()
                .orElse(null);


        SandwichComponent result = new SandwichComponent(temp.getName(), temp.getPrice(), sandwich);

        if (result.getName() != null && existChecker == null){
            System.out.println("Component added successfully");
            sandwichComponentRepository.save(result);
            return result;
        }else {
            System.out.println("Error while trying to add component");
            return null;
        }
    }

    private static double checkSandwichPrice(Sandwich sandwich) {
        Set<SandwichComponent> components = sandwich.getSandwichComponents();

        return components.stream()
                .toList().stream()
                    .mapToDouble(SandwichComponent::getPrice)
                    .sum();
    }
}
