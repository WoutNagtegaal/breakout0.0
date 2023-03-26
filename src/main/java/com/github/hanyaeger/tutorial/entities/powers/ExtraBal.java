package com.github.hanyaeger.tutorial.entities.powers;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.tutorial.entities.Bal;

public class ExtraBal extends Power {
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

    protected ExtraBal(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
    }

    void doePowerActie() {
        Bal extraBal = new Bal()
        Bal bal = new Bal(breakOutGame, spelerBalk, getWidth() / 2, (getHeight() / 4) * 3);
        addEntity(bal);
    }
}
