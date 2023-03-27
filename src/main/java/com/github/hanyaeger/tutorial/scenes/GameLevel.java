package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.tutorial.BreakOutGame;
import com.github.hanyaeger.tutorial.entities.Bal;
import com.github.hanyaeger.tutorial.entities.SpelerBalk;
import com.github.hanyaeger.tutorial.entities.levels.Level3;
import javafx.scene.input.MouseButton;

public class GameLevel extends DynamicScene implements TileMapContainer, MouseButtonPressedListener {

  private final BreakOutGame breakOutGame;
  SpelerBalk spelerBalk;
  int aantalBlokken;

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
    spelerBalk = new SpelerBalk(
      new Coordinate2D(getWidth() / 2, getHeight() - 100),
            breakOutGame
    );
    addEntity(spelerBalk);

    Bal bal = new Bal(breakOutGame, spelerBalk, getWidth() / 2, (getHeight() / 4) * 3);
    addEntity(bal);
  }

  @Override
  public void setupTileMaps() {
    addTileMap(new Level3(this, breakOutGame, spelerBalk));
    aantalBlokken = berekenAantalRuimteschepen();
  }

  public int berekenAantalRuimteschepen() {
    int[][] t = getTileMaps().get(0).defineMap();
    int aantalRuimteschepen = 0;
    for(int[] rij: t) {
      for(int kolom : rij) {
        if(kolom > 0) {
          aantalRuimteschepen++;
        }
      }
    }
    return aantalRuimteschepen;
  }

  public void verwijderBlock() {
    aantalBlokken--;
  }

  public int getAantalBlokken() {
    return aantalBlokken;
  }

  @Override
  public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
    System.out.println(berekenAantalRuimteschepen());
   }
}
