package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import com.github.hanyaeger.tutorial.BreakOutGame;
import com.github.hanyaeger.tutorial.entities.Bal;
import com.github.hanyaeger.tutorial.entities.SpelerBalk;
import com.github.hanyaeger.tutorial.entities.blocks.Block;

public class GameLevel extends DynamicScene implements EntitySpawnerContainer, TileMapContainer {

  private final BreakOutGame breakOutGame;

  public GameLevel(BreakOutGame breakOutGame) {
    this.breakOutGame = breakOutGame;
  }

  @Override
  public void setupScene() {
    setBackgroundAudio("audio/waterworld.mp3");
    setBackgroundImage("backgrounds/game_background.jpg");
  }

  @Override
  public void setupEntities() {
    var spelerBalk = new SpelerBalk(
      new Coordinate2D(getWidth() / 2, getHeight() - 100),
            breakOutGame
    );
    addEntity(spelerBalk);

    Bal bal = new Bal(breakOutGame);
    addEntity(bal);

    Block block = new Block(breakOutGame, new Coordinate2D(15, 100));
    addEntity(block);
  }

  @Override
  public void setupEntitySpawners() {
    //addEntitySpawner(new BubbleSpawner(100, getWidth(), getHeight()));
  }

  @Override
  public void setupTileMaps() {
    //addTileMap(new CoralTileMap());
  }
}
