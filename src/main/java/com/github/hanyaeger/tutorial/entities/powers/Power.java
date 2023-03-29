package com.github.hanyaeger.tutorial.entities.powers;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.tutorial.entities.Player;

public abstract class Power extends DynamicSpriteEntity implements SceneBorderTouchingWatcher, Collided, Collider {

    protected Power(Coordinate2D location, Size size, String resource) {
        super(resource, location, size);
    }

    abstract void playRemovalNoise();

    abstract void doPowerAction(Collider collider);

    public void dropPower() {
        final int SPEED = 8;
        final int RICHTING = 0;
        setMotion(SPEED, RICHTING);
    }

    @Override
    public void onCollision(Collider collider) {
        if (collider instanceof Player) {
            doPowerAction(collider);
            playRemovalNoise();
            remove();
        }
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border) {
        remove();
    }
}