package com.github.hanyaeger.tutorial.entities.powers;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.tutorial.BreakOutGame;
import com.github.hanyaeger.tutorial.entities.Player;
import com.github.hanyaeger.tutorial.scenes.levels.GameLevel;

public class MakeBallBigger extends Power {

    private final int VERGROTING = 10;
    private final GameLevel level;
    private SoundClip soundEffect = new SoundClip("audio/power_up.mp3");

    public MakeBallBigger(Coordinate2D position, Size size, BreakOutGame breakOutGame, Player player, GameLevel level) {
        super(position, size, "sprites/vergroot_bal.png");
        this.level = level;
    }

    void doPowerAction(Collider collider) {
        int max_grootte = level.getMAX_BAL_SIZE();
        int min_grootte = level.getMIN_BAL_GROOTTE();
        int huidige_grootte = level.getBalSize();
        int nieuwe_grootte = huidige_grootte + VERGROTING;

        if (nieuwe_grootte > max_grootte) {
            level.setBalSize(max_grootte);
            //level.veranderBalGrootte(max_grootte);
        } else if (nieuwe_grootte < min_grootte) {
            level.setBalSize(min_grootte);
            //level.veranderBalGrootte(min_grootte);
        } else {
            level.setBalSize(nieuwe_grootte);
            //level.veranderBalGrootte(nieuwe_grootte);
        }
    }

    void playRemovalNoise() {
        soundEffect.play();
    }
}