package com.github.hanyaeger.tutorial.entities.levels;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.tutorial.entities.Bal;

public class Block extends SpriteEntity implements Collider, Collided {

  SoundClip explosion = new SoundClip("audio/explosion.mp3");

  public Block(Coordinate2D location, Size size, String resource) {
    super(resource, location, size);
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
