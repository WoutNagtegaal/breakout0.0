package com.github.hanyaeger.tutorial.entities.powers;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.tutorial.BreakOutGame;
import com.github.hanyaeger.tutorial.entities.Player;
import com.github.hanyaeger.tutorial.scenes.levels.GameLevel;

public class ExtraBal extends Power {

    private final GameLevel level;
    private SoundClip soundEffect = new SoundClip("audio/power_up.mp3");

    public ExtraBal(Coordinate2D position, Size size, BreakOutGame breakOutGame, Player player, GameLevel level) {
        super(position, size, "sprites/extra_bal.png");
        this.level = level;
    }

    void doePowerActie(Collider collider) {
        level.voegBalToe(getWidth() / 2, (getHeight() / 4) * 2);
    }

    void speelVerwijderSound() {
        soundEffect.play();
    }

}