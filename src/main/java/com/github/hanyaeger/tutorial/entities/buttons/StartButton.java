package com.github.hanyaeger.tutorial.entities.buttons;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import com.github.hanyaeger.tutorial.BreakOutGame;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class StartButton extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {

  private final BreakOutGame breakOutGame;

  public StartButton(Coordinate2D initialLocation, BreakOutGame breakOutGame) {
    super(initialLocation, "Play game");
    setFill(Color.RED);
    setFont(Font.font("Roboto", FontWeight.BOLD, 30));
    setAnchorPoint(AnchorPoint.CENTER_CENTER);
    this.breakOutGame = breakOutGame;
  }

  @Override
  public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
    breakOutGame.setActiveScene(1);
  }

  @Override
  public void onMouseEntered() {
    setFill(Color.VIOLET);
    setCursor(Cursor.HAND);
  }

  @Override
  public void onMouseExited() {
    setFill(Color.RED);
    setCursor(Cursor.DEFAULT);
  }
}
