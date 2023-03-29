package com.github.hanyaeger.tutorial.entities.powers;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.tutorial.BreakOutGame;
import com.github.hanyaeger.tutorial.entities.Player;

public class MakePlayerSpeedy extends Power {

    private Player player;
    private final int ACCELERATION = 2;
    private SoundClip soundEffect = new SoundClip("audio/power_up.mp3");

    public MakePlayerSpeedy(Coordinate2D position, Size size, BreakOutGame breakOutGame, Player player) {
        super(position, size, "sprites/versnel_balk.png");
        this.player = player;
    }

    void doPowerAction(Collider collider) {
        if(collider instanceof Player) {
            this.player = (Player) collider;
        }
        double currentSpeed = player.getSpeed();
        double newSpeed = currentSpeed + ACCELERATION;
        double maxSpeed = player.getMaxSpeed();

        if (newSpeed > maxSpeed) {
            player.setPlayerSpeed(maxSpeed);
        } else {
            player.setPlayerSpeed(newSpeed);
        }
    }

    void playRemovalNoise() {
        soundEffect.play();
    }
}