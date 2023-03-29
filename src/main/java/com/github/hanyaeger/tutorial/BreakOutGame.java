package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import com.github.hanyaeger.tutorial.scenes.LevelDoneScene;
import com.github.hanyaeger.tutorial.scenes.LevelSelect;
import com.github.hanyaeger.tutorial.scenes.levels.*;
import com.github.hanyaeger.tutorial.scenes.GameOverScene;
import com.github.hanyaeger.tutorial.scenes.TitleScene;

public class BreakOutGame extends YaegerGame {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("Break-Out 0.0");
        setSize(new Size(1200, 750));
    }

    @Override
    public void setupScenes() {
        addScene(Constants.MAIN_MENU, new TitleScene(this));
        addScene(Constants.LEVELS[0], new Level1(this));
        addScene(Constants.LEVELS[1], new Level2(this));
        addScene(Constants.LEVELS[2], new Level3(this));
        addScene(Constants.LEVELS[3], new Level4(this));
        addScene(Constants.LEVELS[4], new Level5(this));
        addScene(Constants.LEVEL_SELECT, new LevelSelect(this));
        addScene(Constants.DEATH_SCREEN, new GameOverScene(this));
        addScene(Constants.LEVEL_COMPLETED, new LevelDoneScene(this));
    }
}
