package com.github.hanyaeger.tutorial.scenes.levels;

import com.github.hanyaeger.tutorial.BreakOutGame;
import com.github.hanyaeger.tutorial.entities.levels.LevelMap1;

public class Level1 extends GameLevel{

    private BreakOutGame breakOutGame;

    public Level1(BreakOutGame breakOutGame) {
        super(breakOutGame);
    }

    @Override
    public void setupTileMaps() {
        addTileMap(new LevelMap1(this, breakOutGame, player));
        numberOfBlocks = calculateNumberOfEnemys();
    }
}
