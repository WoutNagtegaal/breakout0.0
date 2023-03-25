package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import com.github.hanyaeger.tutorial.BreakOutGame;
import com.github.hanyaeger.tutorial.entities.Bal;
import com.github.hanyaeger.tutorial.entities.SpelerBalk;
import com.github.hanyaeger.tutorial.entities.blocks.Block;
import com.github.hanyaeger.tutorial.entities.blocks.GepantserdBlock;
import com.github.hanyaeger.tutorial.entities.levels.FirstLevelMap;

public class GameLevel extends DynamicScene implements EntitySpawnerContainer, TileMapContainer {

  private final BreakOutGame breakOutGame;

  public GameLevel(BreakOutGame breakOutGame) {
    this.breakOutGame = breakOutGame;
  }

  @Override
  public void setupScene() {
    setBackgroundAudio("audio/gamemusic.mp3");
    setBackgroundImage("backgrounds/game_background.jpg");
  }

  @Override
  public void setupEntities() {
    var spelerBalk = new SpelerBalk(
      new Coordinate2D(getWidth() / 2, getHeight() - 100),
            breakOutGame
    );
    addEntity(spelerBalk);

    Bal bal = new Bal(breakOutGame, spelerBalk, getWidth() / 2, (getHeight() / 4) * 3);
    addEntity(bal);

    for(int i = 0; i < 15; i++) {
      for(int j = 0; j < 3; j++) {
        addEntity(new GepantserdBlock(breakOutGame, new Coordinate2D(15 + 100 * i, 15 + 125 * j), 2));
      }
    }
  }

  @Override
  public void setupEntitySpawners() {
    //addEntitySpawner(new BubbleSpawner(100, getWidth(), getHeight()));
  }

  @Override
  public void setupTileMaps() {
    //addTileMap(new FirstLevelMap());
  }
}
