package com.github.hanyaeger.tutorial.entities.powers;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class Power extends DynamicSpriteEntity {

    protected Power(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
    }
}
