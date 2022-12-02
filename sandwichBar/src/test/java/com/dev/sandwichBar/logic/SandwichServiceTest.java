package com.dev.sandwichBar.logic;

import com.dev.sandwichBar.sandwich.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class SandwichServiceTest {

    @Mock
    private ComponentRepository componentRepository;
    @Mock
    private SandwichComponentRepository sandwichComponentRepository;
    @Mock
    private SandwichRepository sandwichRepository;

    @InjectMocks
    private SandwichService sandwichService;


    @Test
    @DisplayName("should return null when component with given name doesn't exists")
    void getComponent_incorrectComponentName_returnNull() {
        //given
        String componentName = "Sausage";
        Sandwich sandwich = new Sandwich("Sandwich");
        sandwich.setSandwichComponents(new HashSet<>());

        //when
        SandwichComponent sandwichComponent = sandwichService.getComponent(componentName, sandwich);

        //then
        assertThat(sandwichComponent).isNull();

    }

    @Test
    @DisplayName("should return null when component with given name exists on sandwich components list")
    void getComponent_correctComponentName_butComponentAddedEarlier_returnNull() {
        //given
        String componentName = "Sausage";
        SandwichComponent comp = new SandwichComponent(componentName);
        Component component = new Component(componentName, 0.0);
        List<Component> componentList = new ArrayList<>();
        componentList.add(component);

        when(componentRepository.findAll()).thenReturn(componentList);

        Sandwich sandwich = new Sandwich("Sandwich");
        sandwich.setSandwichComponents(new HashSet<>());
        sandwich.addComponent(comp);

        //when
        SandwichComponent existChecker = sandwichService.getComponent(componentName, sandwich);

        //then
        assertThat(existChecker).isNull();

    }

    @Test
    @DisplayName("should return Sandwich Component")
    void getComponent_correctComponentName_returnSandwichComponent() {
        //given
        String componentName = "Sausage";
        SandwichComponent comp = new SandwichComponent(componentName);
        Component component = new Component(componentName, 0.0);
        List<Component> componentList = new ArrayList<>();
        componentList.add(component);

        when(componentRepository.findAll()).thenReturn(componentList);

        Sandwich sandwich = new Sandwich("Sandwich");
        sandwich.setSandwichComponents(new HashSet<>());

        //when
        SandwichComponent result = sandwichService.getComponent(componentName, sandwich);

        //then
        assertThat(result).isNotNull();

    }

    @Test
    @DisplayName("should return component list")
    void readAll_returnListWithSandwichModels() {
        //given
        List<Sandwich> sandwichList = new ArrayList<>();

        when(sandwichRepository.findAll()).thenReturn(sandwichList);

        //when
        List<SandwichModel> sandwichModelList = sandwichService.readAll();

        //then
        assertThat(sandwichModelList).isNotNull();
    }
}