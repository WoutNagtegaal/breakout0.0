package com.github.hanyaeger.tutorial.scenes.levels;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import com.github.hanyaeger.tutorial.BreakOutGame;
import com.github.hanyaeger.tutorial.Constants;
import com.github.hanyaeger.tutorial.entities.Bal;
import com.github.hanyaeger.tutorial.entities.SpelerBalk;
import com.github.hanyaeger.tutorial.entities.powers.ExtraBal;
import com.github.hanyaeger.tutorial.entities.powers.Power;
import com.github.hanyaeger.tutorial.entities.text.LevensText;

public abstract class GameLevel extends DynamicScene implements TileMapContainer {

  private final BreakOutGame breakOutGame;
  SpelerBalk spelerBalk;
  Bal bal;
  int aantalBlokken;
  int aantalBallen;
  int levens;
  LevensText text;
  SoundClip death = new SoundClip("audio/death.mp3");
  SoundClip geslaagd = new SoundClip("audio/level_geslaagd.mp3");
  private final double ORIGINELE_BALKBREEDTE = 200;
  private double balkBreedte = ORIGINELE_BALKBREEDTE;
  private final int ORIGINELE_BALGROOTTE = 50;
  private int balGrootte = ORIGINELE_BALGROOTTE;
  private final int MAX_BAL_GROOTTE = 70;
  private final int MIN_BAL_GROOTTE = 10;

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
    spelerBalk = new SpelerBalk(
      new Coordinate2D(getWidth() / 2, getHeight() - 100),
            ORIGINELE_BALKBREEDTE
    );
    balkBreedte = ORIGINELE_BALKBREEDTE;
    addEntity(spelerBalk);

    voegHoofdBalToe(getWidth() / 2, (getHeight() / 4) * 3);

    text = new LevensText(new Coordinate2D(100, getWidth() - 100));
    addEntity(text);
    text.setLevensText(levens);
  }

  public void voegHoofdBalToe(double x, double y) {
    bal = new Bal(breakOutGame, this, spelerBalk, x, y, ORIGINELE_BALGROOTTE);
    balGrootte = ORIGINELE_BALGROOTTE;
    addEntity(bal);
    aantalBallen++;
    System.out.println("hoofdbal: " + aantalBallen);
  }

  public void voegBalToe(double x, double y) {
    Bal nieuweBal = new Bal(breakOutGame, this, spelerBalk,x, y, balGrootte);
    addEntity(nieuweBal);
    aantalBallen++;
    System.out.println("bal: " + aantalBallen);
  }

  public void verwijderBal() {
    aantalBallen--;
    System.out.println("verwijder bal: " + aantalBallen);
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

  public void veranderBalGrootte(int grootte) {
    double xPositie = bal.getX();
    double yPositie = bal.getY();

    bal.remove();
    bal = new Bal(breakOutGame, this, spelerBalk, xPositie, yPositie, balGrootte);
    addEntity(bal);
    bal.stuiter(bal.getHuidigeStuiterRichting());
  }

  public void veranderBalkGrootte(double breedte) {
    double xPositie = spelerBalk.getX();
    double yPositie = spelerBalk.getY();
    double oudeBreedte = spelerBalk.getBreedte();
    xPositie = (xPositie + (oudeBreedte / 2.0)) - (breedte / 2.0);

    spelerBalk.remove();
    spelerBalk = new SpelerBalk(new Coordinate2D(xPositie, yPositie), breedte);
    addEntity(spelerBalk);
  }

  public double getBalkBreedte() {
    return balkBreedte;
  }

  public void setBalkBreedte(double balkBreedte) {
    this.balkBreedte = balkBreedte;
  }

  public int getBalGrootte() {
    return balGrootte;
  }

  public void setBalGrootte(int balGrootte) {
    this.balGrootte = balGrootte;
  }

  public int getMAX_BAL_GROOTTE() {
    return MAX_BAL_GROOTTE;
  }

  public int getMIN_BAL_GROOTTE() {
    return MIN_BAL_GROOTTE;
  }
}
