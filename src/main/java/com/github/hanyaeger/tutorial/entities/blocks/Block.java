package com.github.hanyaeger.tutorial.entities.blocks;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.tutorial.BreakOutGame;
import com.github.hanyaeger.tutorial.entities.Bal;

public class Block extends DynamicSpriteEntity implements Collided, Collider {
    private static final int BLOCK_WIDTH = 200;
    private static final int BLOCK_HEIGHT = 100;
    SoundClip explosion = new SoundClip("audio/explosion.mp3");

    public Block(Coordinate2D position, Size size, String resource) {
        super(resource, position, size);
    }

    @Override
    public void onCollision(Collider collider) {
        if(collider instanceof Bal) {
            ontplof();
        }
    }

    protected void ontplof() {
        explosion.play();
        remove();
    }

    public double getX() {
        return getAnchorLocation().getX();
    }

    public double getY() {
        return getAnchorLocation().getY();
    }
}
