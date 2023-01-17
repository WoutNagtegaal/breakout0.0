package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.tutorial.Waterworld;
import com.github.hanyaeger.tutorial.entities.buttons.GameOverButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GameOverScene extends StaticScene {

    private Waterworld waterworld;

    public GameOverScene(Waterworld waterworld) {
        this.waterworld = waterworld;
    }

    @Override
    public void setupScene() {
        setBackgroundAudio("audio/ocean.mp3");
        setBackgroundImage("backgrounds/background3.jpg");
    }

    @Override
    public void setupEntities() {
        var gameOver = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 2 - 50),
                "Game Over"
        );
        gameOver.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        gameOver.setFill(Color.DARKBLUE);
        gameOver.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));
        addEntity(gameOver);

        var restartButton = new GameOverButton(
                new Coordinate2D(getWidth() / 2, getHeight() / 2 + 50),
                this.waterworld
        );
        addEntity(restartButton);
    }
}
