package io.github.gabrielpadilh4.boundary;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.github.gabrielpadilh4.entity.Car;
import io.github.gabrielpadilh4.entity.Specification;

@Path("cars")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CarResource {

    @Inject
    CarManufacturer carManufacturer;

    @GET
    public List<Car> retrieveCars() {
        return CarManufacturer.retrieveCars();
    }

    @POST
    public void createCar(Specification specification) {
        carManufacturer.manufactureCar(specification);
    }
}
