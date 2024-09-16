package org.example.domain;

import org.springframework.stereotype.Component;

@Component
public class Engine {
    private String type = "Бензин";

    public Engine() {
        System.out.println("Двигатель создан");
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Engine{");
        sb.append("type='").append(type).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
