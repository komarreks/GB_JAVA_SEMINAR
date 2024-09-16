package org.example.config;

import org.example.domain.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ProjectConfig {

    @Bean("BMW") //это имя
    Car car(){
        Car car = new Car();
        car.setModel("X1");
        car.setMade("BMW");
        return car;
    }

    @Bean(name = "AUDI") // и это имя
    Car car2(){
        Car car = new Car();
        car.setModel("S8");
        car.setMade("AUDI");
        return car;
    }

    @Bean
    @Primary //по умолчанию
    Car ca3(){
        Car car = new Car();
        car.setModel("H7");
        car.setMade("HAVAL  ");
        return car;
    }

    @Bean
    String hallo(){
        return "Hello";
    }

    @Bean
    Integer ten10(){
        return 10;
    }

}
