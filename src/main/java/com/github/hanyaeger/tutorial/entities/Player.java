package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class Player extends DynamicSpriteEntity implements KeyListener, SceneBorderTouchingWatcher, Collider {

  private double speed = 8;
  private final double MAX_SPEED = 16;
  public double width;
  private final double MAX_WIDTH = 400;
  private final double MIN_WIDTH = 50;
  private final double LEFT = 270d;
  private final double RIGHT = 90;
  private boolean invertedControls = false;
  public Player(Coordinate2D location, double width) {
    super("sprites/ufobalk.png", location, new Size(width, 40));
    // verander de waardes in new Size() naar de variabelen erboven
    setPreserveAspectRatio(false);
    this.width = width;
  }

  @Override
  public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
    if(pressedKeys.contains(KeyCode.LEFT) || pressedKeys.contains(KeyCode.A)) {
      if (!invertedControls) {
        setMotion(speed, LEFT);
      } else {
        setMotion(speed, RIGHT);
      }
    } else if (pressedKeys.contains(KeyCode.RIGHT) || pressedKeys.contains(KeyCode.D)) {
      if (!invertedControls) {
        setMotion(speed, RIGHT);
      } else {
        setMotion(speed, LEFT);
      }
    } else {
      setSpeed(0);
    }
  }

  @Override
  public void notifyBoundaryTouching(SceneBorder border) {
    setSpeed(0);
    switch (border) {
      case TOP:
        setAnchorLocationY(1);
        break;
      case BOTTOM:
        setAnchorLocationY(getSceneHeight() - getHeight() - 1);
        break;
      case LEFT:
        setAnchorLocationX(1);
        break;
      case RIGHT:
        setAnchorLocationX(getSceneWidth() - getWidth() - 1);
    }
  }
  public double getHeight() {
    return super.getHeight();
  }

  public double getX() {
    return getAnchorLocation().getX();
  }

  public double getY() {
    return getAnchorLocation().getY();
  }

  public double getWidth() {
    return width;
  }

  public double getMaxWidth() {
    return MAX_WIDTH;
  }

  public double getMinWidth() {
    return MIN_WIDTH;
  }

  public void setPlayerSpeed(double snelheid) {
    this.speed = snelheid;
  }

  public double getSpeed() {
    return speed;
  }

  public double getMaxSpeed() {
    return MAX_SPEED;
  }

  public void setInvertedControls() {
    invertedControls = !invertedControls;
  }

}
