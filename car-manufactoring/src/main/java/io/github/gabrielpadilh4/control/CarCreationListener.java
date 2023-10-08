package io.github.gabrielpadilh4.control;

import javax.enterprise.event.Observes;

import io.github.gabrielpadilh4.entity.CarCreated;

public class CarCreationListener {

    public void onCarCreation(@Observes CarCreated carCreated) {
        System.out.println("new car has been created with id" + carCreated.getIdentifier());
    }
}
