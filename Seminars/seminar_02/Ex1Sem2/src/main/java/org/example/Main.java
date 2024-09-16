package org.example;

import org.example.config.ProjectConfig;
import org.example.domain.Car;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        //без спринг коры
//        Car bmw = new Car();
//        bmw.setModel("X1");
//        bmw.setMade("BMW");

        //с корой
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Car carPrimary = context.getBean(Car.class);
        System.out.println(carPrimary);

        Car bmw = context.getBean("BMW", Car.class);
        System.out.println(bmw);

        String hello = context.getBean(String.class);
        System.out.println(hello);

        Integer i = context.getBean(Integer.class);
        System.out.println(i);
    }
}