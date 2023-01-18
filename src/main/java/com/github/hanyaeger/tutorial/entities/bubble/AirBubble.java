package com.github.hanyaeger.tutorial.entities.bubble;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.paint.Color;

public class AirBubble extends Bubble{

  public AirBubble(Coordinate2D location, double speed) {
    super(location, speed);
    setFill(Color.WHITE);
    setStrokeColor(Color.LIGHTBLUE);
  }
}
