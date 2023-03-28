package com.github.hanyaeger.tutorial.scenes.levels;

import com.github.hanyaeger.tutorial.BreakOutGame;
import com.github.hanyaeger.tutorial.entities.levels.PowerupLevelMap;

public class PowerupLevel extends GameLevel{

    BreakOutGame breakOutGame;

    public PowerupLevel(BreakOutGame breakOutGame) {
        super(breakOutGame);
    }

    @Override
    public void setupTileMaps() {
        addTileMap(new PowerupLevelMap(this, breakOutGame, spelerBalk));
        aantalBlokken = berekenAantalRuimteschepen();
    }
}
