package io.github.gabrielpadilh4.boundary;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import io.github.gabrielpadilh4.control.CarFactory;
import io.github.gabrielpadilh4.control.CarRepository;
import io.github.gabrielpadilh4.entity.Car;
import io.github.gabrielpadilh4.entity.CarCreated;
import io.github.gabrielpadilh4.entity.Specification;

@Stateless
public class CarManufacturer {

    @Inject
    CarFactory carFactory;

    @Inject
    CarRepository carRepository;

    @Inject
    Event<CarCreated> carCreated;

    public Car manufactureCar(Specification specification) {
        Car car = carFactory.createCar(specification);
        carRepository.store(car);
        carCreated.fire(new CarCreated(car.getIdentifier()));
        return car;
    }
}