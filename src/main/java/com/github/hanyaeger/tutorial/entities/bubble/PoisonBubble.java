package com.github.hanyaeger.tutorial.entities.bubble;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.paint.Color;

public class PoisonBubble extends Bubble{

  public PoisonBubble(Coordinate2D location, double speed) {
    super(location, speed);
    setFill(Color.LIGHTPINK);
    setStrokeColor(Color.PURPLE);
  }
}
