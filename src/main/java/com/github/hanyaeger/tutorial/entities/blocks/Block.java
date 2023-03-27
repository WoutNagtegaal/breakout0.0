package com.github.hanyaeger.tutorial.entities.blocks;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.tutorial.BreakOutGame;
import com.github.hanyaeger.tutorial.entities.Bal;
import com.github.hanyaeger.tutorial.scenes.levels.GameLevel;

public class Block extends DynamicSpriteEntity implements Collider {
    private static final int BLOCK_WIDTH = 200;
    private static final int BLOCK_HEIGHT = 100;
    SoundClip explosion = new SoundClip("audio/explosion.mp3");
    GameLevel level;
    BreakOutGame breakOutGame;

    public Block(Coordinate2D position, Size size, BlockConfig c) {
        super(c.getResource(), position, size);
        this.level = c.getLevel();
        this.breakOutGame = c.getBreakOutGame();
    }

    public void doeHitActie() {
        ontplof();
    }

    protected void ontplof() {
        explosion.play();
        remove();
        level.verwijderBlock();
        if(level.getAantalBlokken() <= 0) {
            breakOutGame.setActiveScene(2);
        }
    }

    public double getX() {
        return getAnchorLocation().getX();
    }

    public double getY() {
        return getAnchorLocation().getY();
    }
}
