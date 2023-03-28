package com.github.hanyaeger.tutorial.scenes.levels;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.tutorial.BreakOutGame;
import com.github.hanyaeger.tutorial.Constants;
import com.github.hanyaeger.tutorial.entities.Bal;
import com.github.hanyaeger.tutorial.entities.SpelerBalk;
import com.github.hanyaeger.tutorial.entities.powers.*;
import com.github.hanyaeger.tutorial.entities.text.LevensText;
import javafx.scene.input.MouseButton;

public abstract class GameLevel extends DynamicScene implements TileMapContainer, MouseButtonPressedListener {

  private final BreakOutGame breakOutGame;
  SpelerBalk spelerBalk;
  int aantalBlokken;
  int aantalBallen;
  int levens;
  LevensText text;
  SoundClip death = new SoundClip("audio/death.mp3");
  SoundClip geslaagd = new SoundClip("audio/level_geslaagd.mp3");

  public GameLevel(BreakOutGame breakOutGame) {
    this.breakOutGame = breakOutGame;
  }

  @Override
  public void setupScene() {
//    setBackgroundAudio("audio/gamemusic.mp3");
    setBackgroundImage("backgrounds/game_background.jpg");

    this.levens = 3;
    this.aantalBallen = 0;
  }

  @Override
  public void setupEntities() {
    double STARTBREEDTE = 800;
    spelerBalk = new SpelerBalk(
      new Coordinate2D(getWidth() / 2, getHeight() - 100),
            breakOutGame, STARTBREEDTE
    );
    addEntity(spelerBalk);
    voegBalToe(getWidth() / 2, (getHeight() / 4) * 3);

    text = new LevensText(new Coordinate2D(100, getWidth() - 100));
    addEntity(text);
    text.setLevensText(levens);
  }

  public void voegBalToe(double x, double y) {
    Bal bal = new Bal(breakOutGame, this, spelerBalk,x, y);
    addEntity(bal);
    aantalBallen++;
  }

  public void verwijderBal() {
    aantalBallen--;
    System.out.println(aantalBallen);
    if(aantalBallen <= 0) {
      levens--;
      text.setLevensText(levens);
      if(levens <= 0) {
        death.play();
        breakOutGame.setActiveScene(Constants.DEATH_SCREEN);
      }
      voegBalToe(getWidth() / 2, (getHeight() / 4) * 3);
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

  public void addPower(Power power) {
    addEntity(power);
  }

  public void verwijderBlock() {
    aantalBlokken--;
    if(getAantalBlokken() <= 0) {
      levelKlaar();
    }
  }

  public int getAantalBlokken() {
    return aantalBlokken;
  }

  public void levelKlaar() {
    geslaagd.play();
    breakOutGame.setActiveScene(Constants.LEVEL_GESLAAGD);
  }

  public void veranderBalkGrootte(int breedte) {
    double x = spelerBalk.getX();
    double y = spelerBalk.getY();
    double oudeBreedte = spelerBalk.getBreedte();
    x = (x + (oudeBreedte / 2)) - (breedte / 2);

    spelerBalk.remove();
    spelerBalk = new SpelerBalk(new Coordinate2D(x, y), breakOutGame, breedte);
    addEntity(spelerBalk);
  }

  @Override
  public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
    veranderBalkGrootte((int) (Math.random() * 500 + 100));
  }
}
