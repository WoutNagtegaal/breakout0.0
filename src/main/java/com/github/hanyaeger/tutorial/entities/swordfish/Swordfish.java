package com.github.hanyaeger.tutorial.entities.swordfish;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.Random;

public class Swordfish extends DynamicCompositeEntity implements SceneBorderCrossingWatcher {
  public Swordfish(Coordinate2D location) {
    super(location);
    setMotion(2, 270d);
  }

  @Override
  protected void setupEntities() {
    addEntity(new SwordfishSprite(new Coordinate2D(0, 0)));
    addEntity(new SwordfishHitbox(new Coordinate2D(0, 39)));
  }

  @Override
  public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
    setAnchorLocationX(getSceneWidth());
    setAnchorLocationY(new Random().nextInt((int) getSceneHeight() - 81));
  }
}
