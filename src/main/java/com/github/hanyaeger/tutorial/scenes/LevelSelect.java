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

    Button buttonLevel1 = new Button(new Coordinate2D(getWidth() / 2, getHeight() / 2 - 100), breakOutGame, "Level 1") {
      @Override
      public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        breakOutGame.setActiveScene(Constants.LEVEL_1);
      }
    };
    addEntity(buttonLevel1);

    var buttonLevel2 = new Button(new Coordinate2D(getWidth() / 2, getHeight() / 2 - 50), breakOutGame, "Level 2") {
      @Override
      public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        breakOutGame.setActiveScene(Constants.LEVEL_2);
      }
    };
    addEntity(buttonLevel2);

    testKnop();

    var quitbutton = new QuitButton(
      new Coordinate2D(getWidth() / 2, getHeight() / 2 + 200),
      this.breakOutGame
    );
    addEntity(quitbutton);
  }

  private void testKnop() {
    var buttonTestLevel = new Button(new Coordinate2D(getWidth() / 2, getHeight() / 2 + 150), breakOutGame, "Testlevel") {
      @Override
      public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        breakOutGame.setActiveScene(Constants.TESTLEVEL);
      }
    };
    addEntity(buttonTestLevel);
  }
}
