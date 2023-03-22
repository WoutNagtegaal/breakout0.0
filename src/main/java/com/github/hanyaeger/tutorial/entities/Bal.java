package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.tutorial.BreakOutGame;

public class Bal extends DynamicSpriteEntity implements SceneBorderTouchingWatcher, Collider {
    private final BreakOutGame breakOutGame;
    private int grootte = 10;

    public Bal(BreakOutGame breakOutGame) {
        //super("sprites/ufobalk.png", location, new Size(800, 40));
        super("sprites/bal.png", new Coordinate2D(400, 400), new Size(50, 50));
        setMotion(5, 45);

        this.breakOutGame = breakOutGame;
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder sceneBorder) {

        switch (sceneBorder) {
            case TOP -> {
                if(gaatNaarLinks()) {
                    stuiter(45);
                } else {
                    stuiter(315);
                }
                setAnchorLocationY(1);
            }
            case BOTTOM -> {
                if(gaatNaarLinks()) {
                    stuiter(135);
                } else {
                    stuiter(225);
                }
                setAnchorLocationY(getSceneHeight() - getHeight() - 1);
            }
            case LEFT -> {
                if(gaatNaarBoven()) {
                    stuiter(135);
                } else {
                    stuiter(45);
                }
                setAnchorLocationX(1);
            }
            case RIGHT -> {
                if(gaatNaarBoven()) {
                    stuiter(225);
                } else {
                    stuiter(315);
                }
                setAnchorLocationX(getSceneWidth() - getWidth() - 1);
            }
        }
    }

    boolean gaatNaarLinks() {
        return getDirection() > 0 && getDirection() < 180;
    }

    boolean gaatNaarBoven() {
        return getDirection() > 90 && getDirection() < 270;
    }

    public void stuiter(double hoek) {
        setDirection(hoek);
    }
}

