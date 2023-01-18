package com.github.hanyaeger.tutorial.entities.bubble;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;

public class Bubble extends DynamicCircleEntity {
  public Bubble(Coordinate2D location, double speed) {
    super(location);
    setSpeed(speed);
    setRadius(8);
    setMotion(speed, Direction.UP);
    setOpacity(0.5);
    setStrokeWidth(0.2);
  }
}
