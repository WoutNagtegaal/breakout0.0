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

  private double snelheid = 8;
  private final double MAX_SNELHEID = 16;
  public double breedte = 800;
  private final double MAX_BREEDTE = 400;
  private final double MIN_BREEDTE = 50;
  private final double LEFT = 270d;
  private final double RIGHT = 90;
  private boolean inverted_controls = false;
  public Player(Coordinate2D location, double breedte) {
    super("sprites/ufobalk.png", location, new Size(breedte, 40));
    // verander de waardes in new Size() naar de variabelen erboven
    setPreserveAspectRatio(false);
    this.breedte = breedte;
  }

  @Override
  public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
    if(pressedKeys.contains(KeyCode.LEFT) || pressedKeys.contains(KeyCode.A)) {
      if (!inverted_controls) {
        setMotion(snelheid, LEFT);
      } else {
        setMotion(snelheid, RIGHT);
      }
    } else if (pressedKeys.contains(KeyCode.RIGHT) || pressedKeys.contains(KeyCode.D)) {
      if (!inverted_controls) {
        setMotion(snelheid, RIGHT);
      } else {
        setMotion(snelheid, LEFT);
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
    return breedte;
  }

  public double getMAX_BREEDTE() {
    return MAX_BREEDTE;
  }

  public double getMIN_BREEDTE() {
    return MIN_BREEDTE;
  }

  public void setSnelheid(double snelheid) {
    this.snelheid = snelheid;
  }

  public double getSnelheid() {
    return snelheid;
  }

  public double getMAX_SNELHEID() {
    return MAX_SNELHEID;
  }

  public void setInverted_controls() {
    inverted_controls = !inverted_controls;
  }

}
