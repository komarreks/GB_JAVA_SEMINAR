package org.example.config;

import org.example.domain.Car;
import org.example.domain.Engine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan("org.example.domain")
public class ProjectConfig {

//    @Bean
//    Engine engine(){
//        Engine engine = new Engine();
//        return engine;
//    }
//
//    @Bean() //это имя
//    Car car(){
//        Car car = new Car();
//        car.setEngine(engine());
//        car.setModel("X1");
//        car.setMade("BMW");
//        return car;
//    }
}
