package com.github.hanyaeger.tutorial.entities.powers;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.tutorial.entities.Bal;
import com.github.hanyaeger.tutorial.entities.SpelerBalk;

public abstract class Power extends DynamicSpriteEntity implements Collided, Collider {

    protected Power(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
    }

    abstract void doePowerActie();

    public void dropPower() {

    }

    @Override
    public void onCollision(Collider collider) {
        if (collider instanceof SpelerBalk) {
            doePowerActie();
            remove();
        }
    }
}