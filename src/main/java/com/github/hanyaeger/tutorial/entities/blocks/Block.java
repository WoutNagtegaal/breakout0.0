package com.github.hanyaeger.tutorial.entities.blocks;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.tutorial.BreakOutGame;
import com.github.hanyaeger.tutorial.scenes.levels.GameLevel;

public class Block extends DynamicSpriteEntity implements Collider {
    private SoundClip explosion = new SoundClip("audio/explosion.mp3");
    protected GameLevel level;
    protected BreakOutGame breakOutGame;

    public Block(Coordinate2D position, Size size, BlockConfig c) {
        super(c.getResource(), position, size);
        this.level = c.getLevel();
        this.breakOutGame = c.getBreakOutGame();
        explosion.setVolume(0.25);
    }

    public void doCollisionAction() {
        explode();
    }

    protected void explode() {
        explosion.play();
        remove();
        level.removeBlock();
    }

    public double getX() {
        return getAnchorLocation().getX();
    }

    public double getY() {
        return getAnchorLocation().getY();
    }
}
