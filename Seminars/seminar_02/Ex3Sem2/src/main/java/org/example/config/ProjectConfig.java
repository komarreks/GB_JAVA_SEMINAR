package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

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
