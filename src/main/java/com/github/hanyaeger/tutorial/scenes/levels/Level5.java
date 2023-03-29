package com.github.hanyaeger.tutorial.scenes.levels;

import com.github.hanyaeger.tutorial.BreakOutGame;
import com.github.hanyaeger.tutorial.entities.levels.LevelMap5;

public class Level5 extends GameLevel{

    private BreakOutGame breakOutGame;

    public Level5(BreakOutGame breakOutGame) {
        super(breakOutGame);
    }

    @Override
    public void setupTileMaps() {
        addTileMap(new LevelMap5(this, breakOutGame, player));
        numberOfBlocks = calculateNumberOfEnemys();
    }
}
