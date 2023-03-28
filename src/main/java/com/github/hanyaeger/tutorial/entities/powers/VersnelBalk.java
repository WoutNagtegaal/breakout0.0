package com.github.hanyaeger.tutorial.entities.powers;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.tutorial.BreakOutGame;
import com.github.hanyaeger.tutorial.entities.SpelerBalk;

public class VersnelBalk extends Power {

    private final BreakOutGame breakOutGame;
    private SpelerBalk spelerBalk;
    private final int VERSNELLING = 2;
    private SoundClip soundEffect = new SoundClip("audio/power_up.mp3");

    public VersnelBalk(Coordinate2D position, Size size, BreakOutGame breakOutGame, SpelerBalk spelerBalk) {
        super(position, size, "sprites/versnel_balk.png");
        this.breakOutGame = breakOutGame;
        this.spelerBalk = spelerBalk;
    }

    void doePowerActie(Collider collider) {
        if(collider instanceof SpelerBalk) {
            this.spelerBalk = (SpelerBalk) collider;
        }
        final double HUIDIGE_SNELHEID = spelerBalk.getSnelheid();
        spelerBalk.setSnelheid(HUIDIGE_SNELHEID + VERSNELLING);
    }

    void speelVerwijderSound(Collider collider) {
        soundEffect.play();
    }
}