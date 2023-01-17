package com.github.hanyaeger.tutorial.entities.buttons;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import com.github.hanyaeger.tutorial.Waterworld;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GameOverButton extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {

  private Waterworld waterworld;

  public GameOverButton(Coordinate2D location, Waterworld waterworld) {
    super(location, "Play again");
    setFill(Color.PURPLE);
    setFont(Font.font("Roboto", FontWeight.BOLD, 30));
    setAnchorPoint(AnchorPoint.CENTER_CENTER);
    this.waterworld = waterworld;
  }

  @Override
  public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
    waterworld.setActiveScene(0);
  }

  @Override
  public void onMouseEntered() {
    setFill(Color.VIOLET);
    setCursor(Cursor.HAND);
  }

  @Override
  public void onMouseExited() {
    setFill(Color.PURPLE);
    setCursor(Cursor.DEFAULT);
  }
}
