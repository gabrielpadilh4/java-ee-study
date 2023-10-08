package io.github.gabrielpadilh4.control;

import java.util.UUID;

import io.github.gabrielpadilh4.entity.Car;
import io.github.gabrielpadilh4.entity.Specification;

public class CarFactory {

    public Car createCar(Specification specification) {
        Car car = new Car();
        car.setIdentifier(UUID.randomUUID().toString());
        car.setColor(specification.getColor());
        car.setEngineType(specification.getEngineType());

        return car;
    }

}
