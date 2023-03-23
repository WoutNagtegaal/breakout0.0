package com.github.hanyaeger.tutorial.entities.levels;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.api.media.SoundClip;

public class BlockEntity extends SpriteEntity implements Collider {
    SoundClip explosion = new SoundClip("audio/explosion.mp3");

    public BlockEntity(Coordinate2D location, Size size, String resource) {
        super(resource, location, size);
    }

    public void onCollision(Collider collider) {
        explosion.play();
        remove();
    }
}