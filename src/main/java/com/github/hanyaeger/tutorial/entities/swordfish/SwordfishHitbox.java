package com.github.hanyaeger.tutorial.entities.swordfish;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SwordfishHitbox extends RectangleEntity implements Collider {
  public SwordfishHitbox(Coordinate2D location) {
    super(location);
    setWidth(60);
    setHeight(2);
    setFill(Color.TRANSPARENT);
  }
}
