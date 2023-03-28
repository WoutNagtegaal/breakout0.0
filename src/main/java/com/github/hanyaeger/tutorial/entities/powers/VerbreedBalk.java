package com.github.hanyaeger.tutorial.entities.powers;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.tutorial.BreakOutGame;
import com.github.hanyaeger.tutorial.entities.SpelerBalk;
import com.github.hanyaeger.tutorial.scenes.levels.GameLevel;

public class VerbreedBalk extends Power {

    private final BreakOutGame breakOutGame;
    private final SpelerBalk spelerBalk;
    private final int VERGROTING = 100;
    private final GameLevel level;
    private SoundClip soundEffect = new SoundClip("audio/power_up.mp3");

    public VerbreedBalk(Coordinate2D position, Size size, BreakOutGame breakOutGame, SpelerBalk spelerBalk, GameLevel level) {
        super(position, size, "sprites/verbreed_balk.png");
        this.breakOutGame = breakOutGame;
        this.spelerBalk = spelerBalk;
        this.level = level;
    }

    void doePowerActie(Collider collider) {
        double max_breedte = spelerBalk.getMAX_BREEDTE();
        double min_breedte = spelerBalk.getMIN_BREEDTE();
        double huidige_breedte = level.getBalkBreedte();
        double nieuwe_breedte = huidige_breedte + VERGROTING;

        if (nieuwe_breedte > max_breedte) {
            System.out.println("Maximale breedte bereikt");
            level.veranderBalkGrootte(max_breedte);
            level.setBalkBreedte(max_breedte);
        } else if (nieuwe_breedte < min_breedte) {
            System.out.println("Minimale breedte bereikt");
            level.veranderBalkGrootte(min_breedte);
            level.setBalkBreedte(min_breedte);
        } else {
            level.veranderBalkGrootte(nieuwe_breedte);
            level.setBalkBreedte(nieuwe_breedte);
        }
    }

    void speelVerwijderSound(Collider collider) {
        soundEffect.play();
    }
}