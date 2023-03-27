package com.github.hanyaeger.tutorial.entities.powers;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.tutorial.BreakOutGame;
import com.github.hanyaeger.tutorial.entities.Bal;
import com.github.hanyaeger.tutorial.entities.SpelerBalk;

public class VersmalBalk extends Power {

    private final BreakOutGame breakOutGame;
    private final SpelerBalk spelerBalk;
    private final int VERKLEINING = 100;

    public VersmalBalk(Coordinate2D position, Size size, BreakOutGame breakOutGame, SpelerBalk spelerBalk) {
        super(position, size, "Sprites/extra_bal.png");
        this.breakOutGame = breakOutGame;
        this.spelerBalk = spelerBalk;
    }

    void doePowerActie() {
        final double HUIDIGE_BREEDTE = spelerBalk.getBreedte();
        spelerBalk.setBreedte(HUIDIGE_BREEDTE - VERKLEINING);
    }
}