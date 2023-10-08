package io.github.gabrielpadilh4.control;

import java.util.UUID;

import javax.inject.Inject;

import io.github.gabrielpadilh4.entity.Car;
import io.github.gabrielpadilh4.entity.Color;
import io.github.gabrielpadilh4.entity.Specification;

public class CarFactory {

    @Inject
    @Diesel
    Color defaultColor;

    public Car createCar(Specification specification) {
        Car car = new Car();
        car.setIdentifier(UUID.randomUUID().toString());
        car.setColor(specification.getColor() == null ? defaultColor : specification.getColor());
        car.setEngineType(specification.getEngineType());

        return car;
    }

}
