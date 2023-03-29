package com.github.hanyaeger.tutorial.entities.powers;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.tutorial.BreakOutGame;
import com.github.hanyaeger.tutorial.entities.Player;
import com.github.hanyaeger.tutorial.scenes.levels.GameLevel;

public class MakePlayerBigger extends Power {

    private final Player player;
    private final int SIZE_CHANGE = 100;
    private final GameLevel level;
    private SoundClip soundEffect = new SoundClip("audio/power_up.mp3");

    public MakePlayerBigger(Coordinate2D position, Size size, BreakOutGame breakOutGame, Player player, GameLevel level) {
        super(position, size, "sprites/verbreed_balk.png");
        this.player = player;
        this.level = level;
    }

    void doPowerAction(Collider collider) {
        double maxWidth = player.getMaxWidth();
        double minWidth = player.getMinWidth();
        double currentWidth = level.getPlayerWidth();
        double newWidth = currentWidth + SIZE_CHANGE;

        if (newWidth > maxWidth) {
            level.changePlayerSize(maxWidth);
            level.setPlayerWidth(maxWidth);
        } else if (newWidth < minWidth) {
            level.changePlayerSize(minWidth);
            level.setPlayerWidth(minWidth);
        } else {
            level.changePlayerSize(newWidth);
            level.setPlayerWidth(newWidth);
        }
    }

    void playRemovalNoise() {
        soundEffect.play();
    }
}