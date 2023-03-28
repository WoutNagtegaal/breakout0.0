package com.github.hanyaeger.tutorial.entities.powers;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.tutorial.BreakOutGame;
import com.github.hanyaeger.tutorial.entities.Bal;
import com.github.hanyaeger.tutorial.entities.SpelerBalk;
import com.github.hanyaeger.tutorial.scenes.levels.GameLevel;

public class VergrootBal extends Power {

    private final BreakOutGame breakOutGame;
    private final SpelerBalk spelerBalk;
    private final int VERGROTING = 10;
    private final Bal bal;

    public VergrootBal(Coordinate2D position, Size size, BreakOutGame breakOutGame, SpelerBalk spelerBalk, GameLevel level, Bal bal) {
        super(position, size, "sprites/vergroot_bal.png");
        this.breakOutGame = breakOutGame;
        this.spelerBalk = spelerBalk;
        this.bal = bal;
    }

    void doePowerActie() {
        int huidige_grootte = bal.getGrootte();
        bal.setGrootte(huidige_grootte + VERGROTING);
        System.out.println(spelerBalk.getBreedte());
    }
}