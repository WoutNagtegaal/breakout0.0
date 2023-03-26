package com.github.hanyaeger.tutorial.entities.powers;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.tutorial.BreakOutGame;
import com.github.hanyaeger.tutorial.entities.Bal;
import com.github.hanyaeger.tutorial.entities.SpelerBalk;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;

public abstract class Power extends DynamicSpriteEntity implements SceneBorderTouchingWatcher, Collided, Collider {

    private static final int POWER_BREEDTE = 35;
    private static final int POWER_HOOGTE = 35;

    protected Power(Coordinate2D location, Size size, String resource) {
        super(resource, location, size);
    }

    abstract void doePowerActie();

    public void dropPower() {
        final int SPEED = 8;
        final int RICHTING = 0;
        setMotion(SPEED, RICHTING);
    }

    @Override
    public void onCollision(Collider collider) {
        if (collider instanceof SpelerBalk) {
            doePowerActie();
            remove();
        }
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border) {
        if (border == SceneBorder.BOTTOM) {
            remove();
        }
    }
}