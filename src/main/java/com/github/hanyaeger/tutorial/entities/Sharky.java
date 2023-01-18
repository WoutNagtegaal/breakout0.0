package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.Random;

public class Sharky extends DynamicSpriteEntity implements Collider, SceneBorderCrossingWatcher {
  public Sharky(Coordinate2D location) {
    super("sprites/sharky.png", location, new Size(50, 50), 1, 19);
    setAutoCycle(1);
    setMotion(2, 90d);
  }

  @Override
  public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
    setAnchorLocationX(0);
    setAnchorLocationY(new Random().nextInt((int) getSceneHeight() - 81));
  }
}
