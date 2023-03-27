package com.github.hanyaeger.tutorial.entities.powers;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.tutorial.BreakOutGame;
import com.github.hanyaeger.tutorial.entities.Bal;
import com.github.hanyaeger.tutorial.entities.SpelerBalk;
import com.github.hanyaeger.tutorial.scenes.levels.GameLevel;

public class ExtraBal extends Power implements Collider{

    private final BreakOutGame breakOutGame;
    private final SpelerBalk spelerBalk;
    private final GameLevel level;

    public ExtraBal(Coordinate2D position, Size size, BreakOutGame breakOutGame, SpelerBalk spelerBalk, GameLevel level) {
        super(position, size, "Sprites/extra_bal.png");
        this.breakOutGame = breakOutGame;
        this.spelerBalk = spelerBalk;
        this.level = level;
    }

    void doePowerActie() {
        /*
        Bal extraBal = new Bal(breakOutGame, level, spelerBalk, getWidth() / 2, (getHeight() / 4) * 3);
        level.addBal(extraBal);

         */
        level.voegBalToe();
    }

}