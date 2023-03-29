package com.github.hanyaeger.tutorial.scenes.levels;

import com.github.hanyaeger.tutorial.BreakOutGame;
import com.github.hanyaeger.tutorial.entities.levels.TestLevelMap;

public class TestLevel extends GameLevel{

    BreakOutGame breakOutGame;

    public TestLevel(BreakOutGame breakOutGame) {
        super(breakOutGame);
    }

    @Override
    public void setupTileMaps() {
        addTileMap(new TestLevelMap(this, breakOutGame, player));
        numberOfBlocks = calculateNumberOfEnemys();
    }
}
