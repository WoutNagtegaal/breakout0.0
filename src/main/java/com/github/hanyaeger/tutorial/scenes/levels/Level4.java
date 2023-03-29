package com.github.hanyaeger.tutorial.scenes.levels;

import com.github.hanyaeger.tutorial.BreakOutGame;
import com.github.hanyaeger.tutorial.entities.levels.LevelMap4;

public class Level4 extends GameLevel{

    BreakOutGame breakOutGame;

    public Level4(BreakOutGame breakOutGame) {
        super(breakOutGame);
    }

    @Override
    public void setupTileMaps() {
        addTileMap(new LevelMap4(this, breakOutGame, player));
        numberOfBlocks = berekenAantalRuimteschepen();
    }
}
