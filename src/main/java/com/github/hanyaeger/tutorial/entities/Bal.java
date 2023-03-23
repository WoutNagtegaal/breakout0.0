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
import com.github.hanyaeger.tutorial.entities.blocks.Block;

public class Bal extends DynamicSpriteEntity implements SceneBorderTouchingWatcher, Collider, Collided {
    private final BreakOutGame breakOutGame;
    private int grootte = 10;
    private SpelerBalk spelerBalk;

    public Bal(BreakOutGame breakOutGame, SpelerBalk balk) {
        //super("sprites/ufobalk.png", location, new Size(800, 40));
        super("sprites/bal.png", new Coordinate2D(400, 400), new Size(50, 50));
        setMotion(5, 45);

        this.breakOutGame = breakOutGame;
        this.spelerBalk = balk;
    }

    public void resetBal() {
        setAnchorLocationX(400);
        setAnchorLocationY(400);
        setDirection(45);
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
                /*
                if(gaatNaarLinks()) {
                    stuiter(135);
                } else {
                    stuiter(225);
                }
                setAnchorLocationY(getSceneHeight() - getHeight() - 1);
                */
                 resetBal();
                 //breakOutGame.setActiveScene(2);
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


    @Override
    public void onCollision(Collider collider) {
        if(collider instanceof SpelerBalk) {
            if(getX() + (getWidth() / 2) > spelerBalk.getX() + (spelerBalk.getWidth() / 2)) {
                stuiter(135);
            } else {
                stuiter(225);
            }
            /*
            if(gaatNaarLinks()) {
                stuiter(135);
            } else {
                stuiter(225);
            }

             */
        }
        if(collider instanceof Block) {
            getAnchorLocation().getX();
            if(gaatNaarLinks()) {
                stuiter(45);
            } else {
                stuiter(315);
            }
        }
    }

    public double getX() {
        return getAnchorLocation().getX();
    }
}

