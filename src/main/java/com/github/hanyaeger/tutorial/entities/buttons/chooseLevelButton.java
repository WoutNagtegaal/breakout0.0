package com.github.hanyaeger.tutorial.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.tutorial.BreakOutGame;
import com.github.hanyaeger.tutorial.Constants;
import javafx.scene.input.MouseButton;

public class chooseLevelButton extends Button {

  public chooseLevelButton(Coordinate2D initialLocation, BreakOutGame breakOutGame) {
    super(initialLocation, breakOutGame,"Kies volgend level");
  }

  @Override
  public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
    breakOutGame.setActiveScene(Constants.LEVEL_SELECT);
  }
}
