package com.github.hanyaeger.tutorial.entities.powers;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.tutorial.BreakOutGame;
import com.github.hanyaeger.tutorial.entities.Player;
import com.github.hanyaeger.tutorial.scenes.levels.GameLevel;

public class VerbreedBalk extends Power {

    private final Player player;
    private final int VERGROTING = 100;
    private final GameLevel level;
    private SoundClip soundEffect = new SoundClip("audio/power_up.mp3");

    public VerbreedBalk(Coordinate2D position, Size size, BreakOutGame breakOutGame, Player player, GameLevel level) {
        super(position, size, "sprites/verbreed_balk.png");
        this.player = player;
        this.level = level;
    }

    void doePowerActie(Collider collider) {
        double max_breedte = player.getMAX_BREEDTE();
        double min_breedte = player.getMIN_BREEDTE();
        double huidige_breedte = level.getPlayerWidth();
        double nieuwe_breedte = huidige_breedte + VERGROTING;

        if (nieuwe_breedte > max_breedte) {
            System.out.println("Maximale breedte bereikt");
            level.changePlayerSize(max_breedte);
            level.setPlayerWidth(max_breedte);
        } else if (nieuwe_breedte < min_breedte) {
            System.out.println("Minimale breedte bereikt");
            level.changePlayerSize(min_breedte);
            level.setPlayerWidth(min_breedte);
        } else {
            level.changePlayerSize(nieuwe_breedte);
            level.setPlayerWidth(nieuwe_breedte);
        }
    }

    void speelVerwijderSound() {
        soundEffect.play();
    }
}