package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.tutorial.BreakOutGame;

public class Bal extends DynamicSpriteEntity implements SceneBorderTouchingWatcher {
    private final BreakOutGame breakOutGame;
    private int grootte = 10;

    public Bal(BreakOutGame breakOutGame) {
//        super("sprites/ufobalk.png", location, new Size(800, 40));
        super("sprites/bal.png", new Coordinate2D(400, 400), new Size(50, 50));
        int location = 1;
        setMotion(5, 45);

        this.breakOutGame = breakOutGame;
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder sceneBorder) {
        /*
        switch (sceneBorder) {
            case TOP -> {
                setAnchorLocationY(1);
            }
            case BOTTOM -> {
                setAnchorLocationY(getSceneHeight() - getHeight() - 1);
            }
            case LEFT -> {
                setAnchorLocationX(1);
            }
            case RIGHT -> {
                setAnchorLocationX(getSceneWidth() - getWidth() - 1);
            }
        }

         */

        setDirection((getDirection() + 90) % 360);
    }
}

