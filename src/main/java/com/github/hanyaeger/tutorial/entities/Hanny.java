package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.tutorial.BreakOutGame;
import com.github.hanyaeger.tutorial.entities.bubble.AirBubble;
import com.github.hanyaeger.tutorial.entities.map.Coral;
import com.github.hanyaeger.tutorial.entities.text.BubblesPoppedText;
import com.github.hanyaeger.tutorial.entities.text.HealthText;
import javafx.scene.input.KeyCode;

import java.util.Random;
import java.util.Set;

public class Hanny extends DynamicSpriteEntity implements KeyListener, SceneBorderTouchingWatcher,
  Newtonian, Collided, Collider {

  private BreakOutGame breakOutGame;
  private HealthText healthText;
  private BubblesPoppedText bubblesPoppedText;
  private int health = 3;
  private int bubblesPopped = 0;

  public Hanny(Coordinate2D location, HealthText healthText,
               BubblesPoppedText bubblesPoppedText, BreakOutGame breakOutGame) {
    super("sprites/hanny.png", location, new Size(20, 40), 1, 2);
    setGravityConstant(0.005);
    setFrictionConstant(0.04);

    this.breakOutGame = breakOutGame;

    this.healthText = healthText;
    healthText.setHealthText(health);

    this.bubblesPoppedText = bubblesPoppedText;
    bubblesPoppedText.setBubblesPoppedText(bubblesPopped);
  }

  @Override
  public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
    if(pressedKeys.contains(KeyCode.LEFT)) {
      setMotion(3, 270d);
      setCurrentFrameIndex(0);
    } else if (pressedKeys.contains(KeyCode.RIGHT)) {
      setMotion(3, 90);
      setCurrentFrameIndex(1);
    } else if (pressedKeys.contains(KeyCode.UP)) {
      setMotion(3, 180);
    } else if (pressedKeys.contains(KeyCode.DOWN)) {
      setMotion(3, 0);
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

  @Override
  public void onCollision(Collider collider) {
    if(collider instanceof AirBubble) {
      bubblesPopped++;
      bubblesPoppedText.setBubblesPoppedText(bubblesPopped);
    } else if (collider instanceof Coral) {
      setSpeed(0);
    } else {
      setAnchorLocation(
        new Coordinate2D(
          new Random().nextInt((int) (getSceneWidth() - getWidth())),
          new Random().nextInt((int) (getSceneHeight() - getHeight()))
        )
      );

      health--;
      if (health <= 0) {
        breakOutGame.setActiveScene(2);
      }
      healthText.setHealthText(health);
    }
  }
}
