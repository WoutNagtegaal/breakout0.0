package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.tutorial.BreakOutGame;
import com.github.hanyaeger.tutorial.entities.buttons.QuitButton;
import com.github.hanyaeger.tutorial.entities.buttons.StartButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TitleScene extends StaticScene {

  private final BreakOutGame breakOutGame;

  public TitleScene(BreakOutGame breakOutGame) {
    this.breakOutGame = breakOutGame;
  }

  @Override
  public void setupScene() {
    setBackgroundAudio("audio/ocean.mp3");
    setBackgroundImage("backgrounds/main_menu_background.jpg");
  }

  @Override
  public void setupEntities() {
    var waterworldText = new TextEntity(
      new Coordinate2D(getWidth() / 2, getHeight() / 2 - 50),
      "Break Out 0.0"
    );
    waterworldText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
    waterworldText.setFill(Color.WHITE);
    waterworldText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));
    addEntity(waterworldText);
    var startButton = new StartButton(
      new Coordinate2D(getWidth() / 2, getHeight() / 2 + 50),
      this.breakOutGame
    );
    addEntity(startButton);

    var quitbutton = new QuitButton(
      new Coordinate2D(getWidth() / 2, getHeight() / 2 + 100),
      this.breakOutGame
    );
    addEntity(quitbutton);
  }
}
