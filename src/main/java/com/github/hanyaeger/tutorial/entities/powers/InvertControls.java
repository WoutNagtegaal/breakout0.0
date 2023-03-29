package com.github.hanyaeger.tutorial.entities.powers;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.tutorial.BreakOutGame;
import com.github.hanyaeger.tutorial.entities.SpelerBalk;

public class InvertControls extends Power {

    private SpelerBalk spelerBalk;
    private SoundClip soundEffect = new SoundClip("audio/power_down.mp4");

    public InvertControls(Coordinate2D position, Size size, BreakOutGame breakOutGame, SpelerBalk spelerBalk) {
        super(position, size, "sprites/invert_controls.png");
        this.spelerBalk = spelerBalk;
    }

    void doePowerActie(Collider collider) {
        if(collider instanceof SpelerBalk) {
            this.spelerBalk = (SpelerBalk) collider;
        }
        spelerBalk.setInverted_controls();
    }

    void speelVerwijderSound() {
        soundEffect.play();
    }
}