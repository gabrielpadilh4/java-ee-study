package io.github.gabrielpadilh4.control;

import javax.enterprise.inject.Produces;

import io.github.gabrielpadilh4.entity.Color;

public class DefaultColorExposer {
    @Produces
    @Diesel
    public Color exposeDefaultColor() {
        return Color.RED;
    }
}
