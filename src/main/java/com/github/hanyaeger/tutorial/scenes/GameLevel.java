package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.tutorial.Waterworld;
import com.github.hanyaeger.tutorial.entities.Hanny;
import com.github.hanyaeger.tutorial.entities.swordfish.Swordfish;
import com.github.hanyaeger.tutorial.entities.text.HealthText;

public class GameLevel extends DynamicScene {

  private HealthText healthText;
  private Waterworld waterworld;

  public GameLevel(Waterworld waterworld) {
    this.waterworld = waterworld;
  }

  @Override
  public void setupScene() {
    setBackgroundAudio("audio/waterworld.mp3");
    setBackgroundImage("backgrounds/background2.jpg");
    this.healthText = new HealthText(
      new Coordinate2D(10, 10)
    );
  }

  @Override
  public void setupEntities() {
    var swordfish = new Swordfish(
      new Coordinate2D(400, 400)
    );
    addEntity(swordfish);

    var hanny = new Hanny(
      new Coordinate2D(getWidth() / 2, getHeight() / 2),
      healthText,
      waterworld
    );
    addEntity(hanny);

    addEntity(healthText);

  }
}
