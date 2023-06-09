package com.github.hanyaeger.tutorial.scenes.levels;

import com.github.hanyaeger.tutorial.BreakOutGame;
import com.github.hanyaeger.tutorial.entities.levels.LevelMap2;

public class Level2 extends GameLevel{

    private BreakOutGame breakOutGame;

    public Level2(BreakOutGame breakOutGame) {
        super(breakOutGame);
    }

    @Override
    public void setupTileMaps() {
        addTileMap(new LevelMap2(this, breakOutGame, player));
        numberOfBlocks = calculateNumberOfEnemys();
    }
}
