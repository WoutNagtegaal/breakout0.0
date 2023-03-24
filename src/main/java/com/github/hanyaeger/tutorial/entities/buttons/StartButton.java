package com.github.hanyaeger.tutorial.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.tutorial.BreakOutGame;
import javafx.scene.input.MouseButton;

public class StartButton extends Button {

  public StartButton(Coordinate2D initialLocation, BreakOutGame breakOutGame) {
    super(initialLocation, breakOutGame,"Play game");
  }

  @Override
  public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
    breakOutGame.setActiveScene(1);
  }
}
