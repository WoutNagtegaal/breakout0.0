package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.tutorial.BreakOutGame;
import com.github.hanyaeger.tutorial.Constants;
import com.github.hanyaeger.tutorial.entities.buttons.Button;
import com.github.hanyaeger.tutorial.entities.buttons.QuitButton;
import com.github.hanyaeger.tutorial.entities.buttons.StartButton;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class LevelSelect extends StaticScene {

  private final BreakOutGame breakOutGame;

  public LevelSelect(BreakOutGame breakOutGame) {
    this.breakOutGame = breakOutGame;
  }

  @Override
  public void setupScene() {
    setBackgroundAudio("audio/mainmenu.mp3");
    setBackgroundImage("backgrounds/main_menu_background.jpg");
  }

  @Override
  public void setupEntities() {
    var kiesEenLevel = new TextEntity(
      new Coordinate2D(getWidth() / 2, getHeight() / 2 - 200),
      "Kies een level"
    );
    kiesEenLevel.setAnchorPoint(AnchorPoint.CENTER_CENTER);
    kiesEenLevel.setFill(Color.WHITE);
    kiesEenLevel.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));
    addEntity(kiesEenLevel);

    testKnop();

    voegLevelKnoppenToe();

    var quitbutton = new QuitButton(
      new Coordinate2D(getWidth() / 2, getHeight() / 2 + 200),
      this.breakOutGame
    );
    addEntity(quitbutton);
  }

  private void voegLevelKnoppenToe() {
    double yPos = getHeight() / 2 - 100;
    int levelNummer = 1;
    for(int i : Constants.LEVELS) {
      Button levelButton = new Button(new Coordinate2D(getWidth() / 2, yPos), breakOutGame, "Level " + levelNummer) {
        @Override
        public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
          breakOutGame.setActiveScene(i);
        }
      };
      addEntity(levelButton);
      yPos += 50;
      levelNummer++;
    }
  }

  private void testKnop() {
    var buttonTestLevel = new Button(new Coordinate2D(getWidth() / 2, getHeight() / 2 + 150), breakOutGame, "Test") {
      @Override
      public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        breakOutGame.setActiveScene(Constants.TESTLEVEL);
      }
    };
    addEntity(buttonTestLevel);
  }
}
