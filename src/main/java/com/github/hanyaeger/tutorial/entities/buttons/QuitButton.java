package com.github.hanyaeger.tutorial.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.tutorial.BreakOutGame;
import javafx.scene.input.MouseButton;

public class QuitButton extends Button {

  public QuitButton(Coordinate2D initialLocation, BreakOutGame breakOutGame) {
    super(initialLocation, breakOutGame, "Quit game");
  }

  @Override
  public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
    breakOutGame.quit();
  }
}