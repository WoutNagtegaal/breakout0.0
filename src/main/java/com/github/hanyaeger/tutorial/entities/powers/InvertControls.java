package com.github.hanyaeger.tutorial.entities.powers;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.tutorial.BreakOutGame;
import com.github.hanyaeger.tutorial.entities.SpelerBalk;

public class InvertControls extends Power {

    private final BreakOutGame breakOutGame;
    private SpelerBalk spelerBalk;

    public InvertControls(Coordinate2D position, Size size, BreakOutGame breakOutGame, SpelerBalk spelerBalk) {
        super(position, size, "sprites/invert_controls.png");
        this.breakOutGame = breakOutGame;
        this.spelerBalk = spelerBalk;
    }

    void doePowerActie(Collider collider) {
        if(collider instanceof SpelerBalk) {
            this.spelerBalk = (SpelerBalk) collider;
        }
        spelerBalk.setInverted_controls();
    }
}