package io.github.gabrielpadilh4.boundary;

import java.net.URI;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.stream.JsonCollectors;
import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import io.github.gabrielpadilh4.entity.Car;
import io.github.gabrielpadilh4.entity.Specification;

@Path("cars")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CarResource {

    @Inject
    CarManufacturer carManufacturer;

    @Context
    UriInfo uriInfo;

    @GET
    public JsonArray retrieveCars() {
        return carManufacturer.retrieveCars()
                .stream()
                .map(c -> Json.createObjectBuilder()
                        .add("color", c.getColor().name())
                        .add("engine", c.getEngineType().name())
                        .add("id", c.getIdentifier())
                        .add("key", "value")
                        .build())
                .collect(JsonCollectors.toJsonArray());
    }

    @POST
    public Response createCar(Specification specification) {
        Car car = carManufacturer.manufactureCar(specification);

        URI uri = uriInfo.getBaseUriBuilder()
                .path(CarResource.class)
                .path(CarResource.class, "retrieveCar")
                .build(car.getIdentifier());

        return Response.created(uri).build();
    }

    @GET
    @Path("{id}")
    public Car retrieveCar(@PathParam("id") String identifier) {
        return carManufacturer.retrieveCar(identifier);
    }
}
