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
  protected Player player;
  private TextEntity livesText;
  private TextEntity enemysText;
  private TextEntity scoreText;
  protected static int score;
  protected static int increasement = 1;
  protected int STARTER_INCREASEMENT = 1;
  protected int numberOfBlocks;
  private int numberOfBalls;
  private int lives;
  private final SoundClip deathSound = new SoundClip("audio/death.mp3");
  private final SoundClip completedSound = new SoundClip("audio/level_geslaagd.mp3");
  private final double ORIGINAL_PLAYERWIDTH = 200;
  private double playerWidth = ORIGINAL_PLAYERWIDTH;
  private final int ORIGINAL_BALLSIZE = 50;

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

    addNewBal(getWidth() / 2, (getHeight() / 4) * 3);

    livesText = new TextEntity(new Coordinate2D(getWidth() - 100, getHeight() - 10), "LEVENS: " + lives);

    livesText.setAnchorPoint(AnchorPoint.BOTTOM_RIGHT);
    livesText.setFill(Color.ANTIQUEWHITE);
    livesText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 40));
    addEntity(livesText);

    enemysText = new TextEntity(new Coordinate2D(100, getHeight() - 10), "VIJANDEN: " + numberOfBlocks);

    scoreText = new TextEntity(new Coordinate2D(getWidth() / 2, getHeight() - 10), "SCORE: " + score);

    scoreText.setAnchorPoint(AnchorPoint.BOTTOM_CENTER);
    scoreText.setFill(Color.ANTIQUEWHITE);
    scoreText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 40));
    addEntity(scoreText);
  }

  public void changeEnemysText() {
    enemysText.remove();
    enemysText = new TextEntity(new Coordinate2D(100, getHeight() - 10), "VIJANDEN: " + numberOfBlocks);

    enemysText.setAnchorPoint(AnchorPoint.BOTTOM_LEFT);
    enemysText.setFill(Color.ANTIQUEWHITE);
    enemysText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 40));
    addEntity(enemysText);
  }

  public void changeScoreText() {
    scoreText.remove();
    scoreText = new TextEntity(new Coordinate2D(getWidth() / 2, getHeight() - 10), "SCORE: " + score);

    scoreText.setAnchorPoint(AnchorPoint.BOTTOM_CENTER);
    scoreText.setFill(Color.ANTIQUEWHITE);
    scoreText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 40));
    addEntity(scoreText);
  }

  public void changeLivesText() {
    livesText.remove();
    livesText = new TextEntity(new Coordinate2D(getWidth() - 100, getHeight() - 10), "LEVENS: " + lives);

    livesText.setAnchorPoint(AnchorPoint.BOTTOM_RIGHT);
    livesText.setFill(Color.ANTIQUEWHITE);
    livesText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 40));
    addEntity(livesText);
  }

  public void addNewBal(double x, double y) {
    Ball newBall = new Ball(this, player,x, y, ORIGINAL_BALLSIZE);
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
        resetScore();
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

  public void increaseScore() {
    int verhoging = 10;
    score = score + (verhoging * increasement);
    changeScoreText();
  }

  public void resetScore() {
    score = 0;
    increasement = STARTER_INCREASEMENT;
  }

  public void addPower(Power power) {
    addEntity(power);
  }

  public void removeBlock() {
    numberOfBlocks--;
    increaseScore();
    changeEnemysText();
    if(getNumberOfBlocks() <= 0) {
      levelDone();
    }
  }

  public int getNumberOfBlocks() {
    return numberOfBlocks;
  }

  public void levelDone() {
    completedSound.play();
    increasement++;
    breakOutGame.setActiveScene(Constants.LEVEL_COMPLETED);
  }

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

}
