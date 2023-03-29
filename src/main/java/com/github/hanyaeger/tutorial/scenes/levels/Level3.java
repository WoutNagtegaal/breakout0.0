package com.github.hanyaeger.tutorial.scenes.levels;

import com.github.hanyaeger.tutorial.BreakOutGame;
import com.github.hanyaeger.tutorial.entities.levels.LevelMap3;

public class Level3 extends GameLevel{

    private BreakOutGame breakOutGame;

    public Level3(BreakOutGame breakOutGame) {
        super(breakOutGame);
    }

    @Override
    public void setupTileMaps() {
        addTileMap(new LevelMap3(this, breakOutGame, player));
        numberOfBlocks = calculateNumberOfEnemys();
    }
}
