package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.tutorial.BreakOutGame;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class SpelerBalk extends DynamicSpriteEntity implements KeyListener, SceneBorderTouchingWatcher,
  Collided, Collider {

  private final BreakOutGame breakOutGame;
  private double snelheid = 8;
  public double breedte = 800;
  public double hoogte = 40;
  private final double MAX_BREEDTE = 1000;
  private final double MIN_BREEDTE = 500;
  private final double LEFT = 270d;
  private final double RIGHT = 90;
  private boolean inverted_controls = false;
  public SpelerBalk(Coordinate2D location, BreakOutGame breakOutGame, double breedte) {
    super("sprites/ufobalk.png", location, new Size(breedte, 40));
    // verander de waardes in new Size() naar de variabelen erboven

    this.breakOutGame = breakOutGame;

  }

  @Override
  public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
    if(pressedKeys.contains(KeyCode.LEFT) || pressedKeys.contains(KeyCode.A)) {
      if (inverted_controls == false) {
        setMotion(snelheid, LEFT);
      } else if (inverted_controls) {
        setMotion(snelheid, RIGHT);
      }
    } else if (pressedKeys.contains(KeyCode.RIGHT) || pressedKeys.contains(KeyCode.D)) {
      if (inverted_controls == false) {
        setMotion(snelheid, RIGHT);
      } else if (inverted_controls) {
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

  public Coordinate2D getYlocation() {
    return getLocationInScene();
  }

  @Override
  public void onCollision(Collider collider) {

  }

  public double getX() {
    return getAnchorLocation().getX();
  }

  public double getY() {
    return getAnchorLocation().getY();
  }

  public void setBreedte(double breedte) {
    if (breedte > MAX_BREEDTE) {
      System.out.println("Maximale breedte bereikt");
      this.breedte = MAX_BREEDTE;
    } else if (breedte < MIN_BREEDTE) {
      System.out.println("Minimale breedte bereikt");
      this.breedte = MIN_BREEDTE;
    } else {
      this.breedte = breedte;
    }
  }

  public double getBreedte() {
    return breedte;
  }

  public void setHoogte(double hoogte) {
    this.hoogte = hoogte;
  }

  public double getHoogte() {
    return hoogte;
  }

  public void setSnelheid(double snelheid) {
    this.snelheid = snelheid;
  }

  public double getSnelheid() {
    return snelheid;
  }

  public void setInverted_controls() {
    inverted_controls = !inverted_controls;
  }

}
