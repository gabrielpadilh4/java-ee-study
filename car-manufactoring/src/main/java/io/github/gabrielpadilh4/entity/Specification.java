package io.github.gabrielpadilh4.entity;

import javax.validation.constraints.NotNull;

public class Specification {

    @NotNull
    private Color color;

    @NotNull
    private EngineType engineType;

    public Specification() {
        super();
    }

    public Specification(Color color, EngineType engineType) {
        this.color = color;
        this.engineType = engineType;
    }

    public Color getColor() {
        return color;
    }

    public EngineType getEngineType() {
        return engineType;
    }
}
