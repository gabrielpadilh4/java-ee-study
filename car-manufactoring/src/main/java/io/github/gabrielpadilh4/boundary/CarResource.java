package io.github.gabrielpadilh4.boundary;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.stream.JsonCollectors;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.github.gabrielpadilh4.entity.Color;
import io.github.gabrielpadilh4.entity.EngineType;
import io.github.gabrielpadilh4.entity.Specification;

@Path("cars")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CarResource {

    @Inject
    CarManufacturer carManufacturer;

    @GET
    public JsonArray retrieveCars() {
        return CarManufacturer.retrieveCars()
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
    public void createCar(JsonObject jsonObject) {
        Color color = Color.valueOf(jsonObject.getString("color"));
        EngineType engineType = EngineType.valueOf(jsonObject.getString("engine"));

        carManufacturer.manufactureCar(new Specification(color, engineType));
    }
}
