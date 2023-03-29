package com.github.hanyaeger.tutorial.scenes.levels;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import com.github.hanyaeger.tutorial.BreakOutGame;
import com.github.hanyaeger.tutorial.Constants;
import com.github.hanyaeger.tutorial.entities.Ball;
import com.github.hanyaeger.tutorial.entities.Player;
import com.github.hanyaeger.tutorial.entities.powers.Power;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public abstract class GameLevel extends DynamicScene implements TileMapContainer {

  private final BreakOutGame breakOutGame;
  Player player;
  Ball ball;
  TextEntity livesText;
  int numberOfBlocks;
  int numberOfBalls;
  int lives;
  SoundClip deathSound = new SoundClip("audio/death.mp3");
  SoundClip completedSound = new SoundClip("audio/level_geslaagd.mp3");
  private final double ORIGINAL_PLAYERWIDTH = 200;
  private double playerWidth = ORIGINAL_PLAYERWIDTH;
  private final int ORIGINAL_BALSIZE = 50;
  private int balSize = ORIGINAL_BALSIZE;
  private final int MAX_BAL_SIZE = 70;
  private final int MIN_BAL_SIZE = 10;

  public GameLevel(BreakOutGame breakOutGame) {
    this.breakOutGame = breakOutGame;
  }

  @Override
  public void setupScene() {
    setBackgroundAudio("audio/gamemusic.mp3");
    setBackgroundImage("backgrounds/game_background.jpg");

    this.lives = 3;
    this.numberOfBalls = 0;
  }

  @Override
  public void setupEntities() {
    player = new Player(
      new Coordinate2D(getWidth() / 2, getHeight() - 100),
            ORIGINAL_PLAYERWIDTH
    );
    playerWidth = ORIGINAL_PLAYERWIDTH;
    addEntity(player);

    addMainBal(getWidth() / 2, (getHeight() / 4) * 3);

//    text.setLevensText(levens);
    Coordinate2D levensPositie = new Coordinate2D(getWidth() - 100, getHeight() - 10);
    String levensTextString = "LEVENS: " + lives;
    livesText = new TextEntity(levensPositie, levensTextString);

    livesText.setAnchorPoint(AnchorPoint.BOTTOM_RIGHT);
    livesText.setFill(Color.ANTIQUEWHITE);
    livesText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 40));
    addEntity(livesText);
  }

  public void changeLivesText() {
    livesText.remove();
    livesText = new TextEntity(new Coordinate2D(getWidth() - 100, getHeight() - 10), "LEVENS: " + lives);

    livesText.setAnchorPoint(AnchorPoint.BOTTOM_RIGHT);
    livesText.setFill(Color.ANTIQUEWHITE);
    livesText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 40));
    addEntity(livesText);
  }

  public void addMainBal(double x, double y) {
    ball = new Ball(breakOutGame, this, player, x, y, ORIGINAL_BALSIZE);
    balSize = ORIGINAL_BALSIZE;
    addEntity(ball);
    numberOfBalls++;
  }

  public void addNewBal(double x, double y) {
    Ball newBall = new Ball(breakOutGame, this, player,x, y, balSize);
    addEntity(newBall);
    numberOfBalls++;
  }

  public void deleteBal() {
    numberOfBalls--;
    if(numberOfBalls <= 0) {
      lives--;
      changeLivesText();
      if(lives <= 0) {
        deathSound.play();
        breakOutGame.setActiveScene(Constants.DEATH_SCREEN);
      }
      addNewBal(getWidth() / 2, (getHeight() / 4) * 3);
    }
  }

  public int calculateNumberOfEnemys() {
    int[][] t = getTileMaps().get(0).defineMap();
    int numberOfEnemys = 0;
    for(int[] rij: t) {
      for(int kolom : rij) {
        if(kolom > 0) {
          numberOfEnemys++;
        }
      }
    }
    return numberOfEnemys;
  }

  public void addPower(Power power) {
    addEntity(power);
  }

  public void removeBlock() {
    numberOfBlocks--;
    if(getNumberOfBlocks() <= 0) {
      levelDone();
    }
  }

  public int getNumberOfBlocks() {
    return numberOfBlocks;
  }

  public void levelDone() {
    completedSound.play();
    breakOutGame.setActiveScene(Constants.LEVEL_COMPLETED);
  }

  /*
  public void veranderBalGrootte(int grootte) {
    double xPositie = bal.getX();
    double yPositie = bal.getY();

    bal.remove();
    bal = new Bal(breakOutGame, this, spelerBalk, xPositie, yPositie, balGrootte);
    addEntity(bal);
    bal.stuiter(bal.getHuidigeStuiterRichting());
  }

   */

  public void changePlayerSize(double breedte) {
    double xPositie = player.getX();
    double yPositie = player.getY();
    double oudeBreedte = player.getWidth();
    xPositie = (xPositie + (oudeBreedte / 2.0)) - (breedte / 2.0);

    player.remove();
    player = new Player(new Coordinate2D(xPositie, yPositie), breedte);
    addEntity(player);
  }

  public double getPlayerWidth() {
    return playerWidth;
  }

  public void setPlayerWidth(double playerWidth) {
    this.playerWidth = playerWidth;
  }

  public int getBalSize() {
    return balSize;
  }

  public void setBalSize(int balSize) {
    this.balSize = balSize;
  }

  public int getMAX_BAL_SIZE() {
    return MAX_BAL_SIZE;
  }

  public int getMIN_BAL_GROOTTE() {
    return MIN_BAL_SIZE;
  }
}
