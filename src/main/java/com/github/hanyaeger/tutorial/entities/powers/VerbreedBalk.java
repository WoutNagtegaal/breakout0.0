package com.github.hanyaeger.tutorial.entities.powers;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.tutorial.BreakOutGame;
import com.github.hanyaeger.tutorial.entities.SpelerBalk;
import com.github.hanyaeger.tutorial.scenes.levels.GameLevel;

public class VerbreedBalk extends Power {

    private final BreakOutGame breakOutGame;
    private final SpelerBalk spelerBalk;
    private final int VERGROTING = 100;
    private final GameLevel level;

    public VerbreedBalk(Coordinate2D position, Size size, BreakOutGame breakOutGame, SpelerBalk spelerBalk, GameLevel level) {
        super(position, size, "sprites/verbreed_balk.png");
        this.breakOutGame = breakOutGame;
        this.spelerBalk = spelerBalk;
        this.level = level;
    }

    void doePowerActie() {
        double huidige_breedte = spelerBalk.getBreedte();
        spelerBalk.setBreedte(huidige_breedte + VERGROTING);
        System.out.println(spelerBalk.getBreedte());

//        Coordinate2D location = spelerBalk.getYlocation();
//        double breedte = spelerBalk.getBreedte();
//        double hoogte = spelerBalk.getHoogte();
//
//        SpelerBalk nieuweSpelerBalk = new SpelerBalk(location, breakOutGame, breedte, hoogte);
//        level.addSpelerBalk(nieuweSpelerBalk);
//        spelerBalk.remove();
    }
}