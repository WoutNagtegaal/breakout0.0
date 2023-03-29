package com.github.hanyaeger.tutorial.entities.powers;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.tutorial.BreakOutGame;
import com.github.hanyaeger.tutorial.entities.Player;

public class VersnelBalk extends Power {

    private Player player;
    private final int VERSNELLING = 2;
    private SoundClip soundEffect = new SoundClip("audio/power_up.mp3");

    public VersnelBalk(Coordinate2D position, Size size, BreakOutGame breakOutGame, Player player) {
        super(position, size, "sprites/versnel_balk.png");
        this.player = player;
    }

    void doePowerActie(Collider collider) {
        if(collider instanceof Player) {
            this.player = (Player) collider;
        }
        double huidige_snelheid = player.getSnelheid();
        double nieuwe_snelheid = huidige_snelheid + VERSNELLING;
        double max_snelheid = player.getMAX_SNELHEID();

        if (nieuwe_snelheid > max_snelheid) {
            player.setSnelheid(max_snelheid);
        } else {
            player.setSnelheid(nieuwe_snelheid);
        }
    }

    void speelVerwijderSound() {
        soundEffect.play();
    }
}