package com.github.hanyaeger.tutorial.entities.powers;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.tutorial.BreakOutGame;
import com.github.hanyaeger.tutorial.entities.Player;

public class InvertControls extends Power {

    private Player player;
    private SoundClip soundEffect = new SoundClip("audio/power_down.mp4");

    public InvertControls(Coordinate2D position, Size size, BreakOutGame breakOutGame, Player player) {
        super(position, size, "sprites/invert_controls.png");
        this.player = player;
    }

    void doPowerAction(Collider collider) {
        if(collider instanceof Player) {
            this.player = (Player) collider;
        }
        player.setInverted_controls();
    }

    void playRemovalNoise() {
        soundEffect.play();
    }
}