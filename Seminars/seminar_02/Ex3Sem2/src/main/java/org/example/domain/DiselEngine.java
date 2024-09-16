package org.example.domain;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class DiselEngine implements iEngin{

    public DiselEngine() {
        System.out.println("Создан экземпляр DiselEngine");
    }

    @Override
    public void startEngine() {
        System.out.println("Запущен дизель");
    }
}
