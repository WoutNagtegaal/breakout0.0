package com.github.hanyaeger.tutorial.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.tutorial.BreakOutGame;
import javafx.scene.input.MouseButton;

public class GameOverButton extends Button {

  public GameOverButton(Coordinate2D location, BreakOutGame breakOutGame) {
    super(location, breakOutGame, "Play again");
  }

  @Override
  public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
    breakOutGame.setActiveScene(0);
  }
}
