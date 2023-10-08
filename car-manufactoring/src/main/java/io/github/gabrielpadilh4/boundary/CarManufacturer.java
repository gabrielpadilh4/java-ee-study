package io.github.gabrielpadilh4.boundary;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import io.github.gabrielpadilh4.control.CarFactory;
import io.github.gabrielpadilh4.entity.Car;
import io.github.gabrielpadilh4.entity.CarCreated;
import io.github.gabrielpadilh4.entity.Specification;

@Stateless
public class CarManufacturer {

    @Inject
    CarFactory carFactory;

    @PersistenceContext(unitName = "prod")
    EntityManager entityManager;

    @Inject
    Event<CarCreated> carCreated;

    public Car manufactureCar(Specification specification) {
        Car car = carFactory.createCar(specification);
        entityManager.persist(car);
        carCreated.fire(new CarCreated(car.getIdentifier()));
        return car;
    }

    public List<Car> retrieveCars() {
     return entityManager.createNamedQuery(Car.FIND_ALL, Car.class).getResultList();
    }

    public Car retrieveCar(String identifier) {
        return null;
    }
}