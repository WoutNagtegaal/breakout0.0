package com.github.hanyaeger.tutorial.scenes.levels;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import com.github.hanyaeger.tutorial.BreakOutGame;
import com.github.hanyaeger.tutorial.Constants;
import com.github.hanyaeger.tutorial.entities.Bal;
import com.github.hanyaeger.tutorial.entities.SpelerBalk;
import com.github.hanyaeger.tutorial.entities.powers.ExtraBal;
import com.github.hanyaeger.tutorial.entities.powers.InvertControls;
import com.github.hanyaeger.tutorial.entities.powers.VerbreedBalk;
import com.github.hanyaeger.tutorial.entities.powers.VersmalBalk;
import com.github.hanyaeger.tutorial.entities.powers.VersnelBalk;

public abstract class GameLevel extends DynamicScene implements TileMapContainer {

  private final BreakOutGame breakOutGame;
  SpelerBalk spelerBalk;
  int aantalBlokken;
  int aantalBallen;
  int levens;

  public GameLevel(BreakOutGame breakOutGame) {
    this.breakOutGame = breakOutGame;
    this.levens = 3;
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
    voegBalToe();
  }

  public void voegBalToe() {
    Bal bal = new Bal(breakOutGame, this, spelerBalk,getWidth() / 2, (getHeight() / 4) * 3);
    addEntity(bal);
    aantalBallen++;
  }

  public void verwijderBal() {
    aantalBallen--;
    System.out.println(aantalBallen);
    if(aantalBallen <= 0) {
      levens--;
      if(levens <= 0) {
        breakOutGame.setActiveScene(Constants.DEATH_SCREEN);
      }
      voegBalToe();
    }
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

  public void addExtraBal(ExtraBal extraBal) {
    addEntity(extraBal);
  }

  public void addBal(Bal bal) {
    addEntity(bal);
    aantalBallen++;
  }

  public void addInvertControls(InvertControls invertControls) {
    addEntity(invertControls);
  }

  public void addVerbreedBalk(VerbreedBalk verbreedBalk) {
    addEntity(verbreedBalk);
  }

  public void addVersmalBalk(VersmalBalk versmalBalk) {
    addEntity(versmalBalk);
  }

  public void addVersnelBalk(VersnelBalk versnelBalk) {
    addEntity(versnelBalk);
  }

  public void verwijderBlock() {
    aantalBlokken--;
  }

  public int getAantalBlokken() {
    return aantalBlokken;
  }
}
