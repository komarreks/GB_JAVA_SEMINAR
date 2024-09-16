package org.example.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
    private String model;
    private String made;
    @Autowired
    private iEngin engine;

    public Car(iEngin engine) {
        this.engine = engine;
        System.out.println("Машина создана");
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMade() {
        return made;
    }

    public void setMade(String made) {
        this.made = made;
    }

    public iEngin getEngine() {
        return engine;
    }

    public void setEngine(iEngin engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("model='").append(model).append('\'');
        sb.append(", made='").append(made).append('\'');
        sb.append(", engine=").append(engine);
        sb.append('}');
        return sb.toString();
    }

    public void go(){
        engine.startEngine();
    }
}
