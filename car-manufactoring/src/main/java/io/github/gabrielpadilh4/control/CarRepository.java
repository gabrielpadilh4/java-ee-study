package io.github.gabrielpadilh4.control;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import io.github.gabrielpadilh4.entity.Car;
import io.github.gabrielpadilh4.entity.Color;
import io.github.gabrielpadilh4.entity.EngineType;

public class CarRepository {

    public void store(Car car) {
        if (new Random().nextBoolean()) {
            throw new IllegalStateException("Could not persist car");
        }
    }

    public List<Car> loadCars() {
        return Arrays.asList(
            createCar("x1234", Color.RED, EngineType.DIESEL),
            createCar("x4567", Color.GREY, EngineType.ELETRIC),
            createCar("x8901", Color.BLACK, EngineType.PETROL)
        )
    }

    public static Car createCar(String identifier, Color color, EngineType engineType) {
        Car car = new Car();
        car.setIdentifier(identifier);
        car.setColor(color);
        car.setEngineType(engineType);
        return car;
    }

}
