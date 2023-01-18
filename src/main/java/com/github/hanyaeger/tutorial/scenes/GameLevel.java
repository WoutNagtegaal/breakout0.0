package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.tutorial.Waterworld;
import com.github.hanyaeger.tutorial.entities.Hanny;
import com.github.hanyaeger.tutorial.entities.Sharky;
import com.github.hanyaeger.tutorial.entities.swordfish.Swordfish;
import com.github.hanyaeger.tutorial.entities.text.HealthText;
import com.github.hanyaeger.tutorial.spawners.BubbleSpawner;

public class GameLevel extends DynamicScene implements EntitySpawnerContainer {

  private Waterworld waterworld;

  public GameLevel(Waterworld waterworld) {
    this.waterworld = waterworld;
  }

  @Override
  public void setupScene() {
    setBackgroundAudio("audio/waterworld.mp3");
    setBackgroundImage("backgrounds/background2.jpg");
  }

  @Override
  public void setupEntities() {
    var healthText = new HealthText(
      new Coordinate2D(10, 10)
    );

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

    var sharky = new Sharky(
      new Coordinate2D(50, 100)
    );
    addEntity(sharky);

  }

  @Override
  public void setupEntitySpawners() {
    addEntitySpawner(new BubbleSpawner(100, getWidth(), getHeight()));
  }
}
