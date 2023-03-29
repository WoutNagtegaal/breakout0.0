package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.tutorial.entities.blocks.Block;
import com.github.hanyaeger.tutorial.scenes.levels.GameLevel;

public class Ball extends DynamicSpriteEntity implements SceneBorderTouchingWatcher, Collider, Collided {

    private Player player;
    private final GameLevel level;
    private final double SPEED = 5;

    public final static double NORTH = 180;
    public final static double SOUTH = 0;
    public final static double EAST = 90;
    public final static double WEST = 270;
    public final static double NORTH_EAST = 135;
    public final static double SOUTH_EAST = 45;
    public final static double NORTH_WEST = 225;
    public final static double SOUTH_WEST = 315;

    public double startDirection = SOUTH;

    public Ball(GameLevel level, Player player, double x, double y, int size) {
        //super("sprites/ufobalk.png", location, new Size(800, 40));
        super("sprites/bal.png", new Coordinate2D(x, y), new Size(size, size));

        setMotion(SPEED, startDirection);

        this.player = player;
        this.level = level;
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder sceneBorder) {
        //Controleerd tegen welke rand is gebotst en stuitert de bal
        switch (sceneBorder) {
            case TOP -> {
                if(goingRight()) {
                    bounce(SOUTH_EAST);
                } else {
                    bounce(SOUTH_WEST);
                }
                setAnchorLocationY(1);
            }
            case BOTTOM -> {
                level.deleteBal();
                remove();
            }
            case LEFT -> {
                if(goingUp()) {
                    bounce(NORTH_EAST);
                } else {
                    bounce(SOUTH_EAST);
                }
                setAnchorLocationX(1);
            }
            case RIGHT -> {
                if(goingUp()) {
                    bounce(NORTH_WEST);
                } else {
                    bounce(SOUTH_WEST);
                }
                setAnchorLocationX(getSceneWidth() - getWidth() - 1);
            }
        }
    }

    boolean goingRight() {
        return getDirection() > SOUTH && getDirection() < NORTH;
    }

    boolean goingUp() {
        return getDirection() > EAST && getDirection() < WEST;
    }

    public void bounce(double hoek) {
        setDirection(hoek);
    }

    @Override
    public void onCollision(Collider collider) {
        //Bij de balk stuitert de bal naar linksboven wanneer de bal de balk links raakt en naar
        //rechts wanneer de bal de balk rechts raakt
        if(collider instanceof Player) {
            player = ((Player) collider);
            if (getX() + (getWidth() / 2) > player.getX() + (player.getWidth() / 2)) {
                bounce(NORTH_EAST);
            } else {
                bounce(NORTH_WEST);
            }
        }
        //Bij een blok moet de bal van de zijkant af stuiteren. Beetje rommelige manier, zal nog wel netter kunnen
        else if(collider instanceof Block) {
            decideBounceDirection(((Block) collider));
            ((Block)collider).doCollisionAction();
        }
    }

    private void decideBounceDirection(Block block) {
        double marge = 6; //snelheid van bal + 1 deze is nodig omdat de bal 5 pixels in een seconde beweegt en
        //zonder deze marge kan niet altijd bepaald worden aan welke kant de bal naar binnen is gegaan omdat de bal
        //al te ver het blok in is gegaan

        //eigenschappen van het blok uitlezen
        double blockX = block.getX();
        double blockY = block.getY();
        double blockWidth = block.getWidth();
        double blockHeight = block.getHeight();

        //de linkerkant van het blok
        if(blockX + marge > getX() + getWidth()) {
            if(goingUp()) {
                bounce(NORTH_WEST);
            } else {
                bounce(SOUTH_WEST);
            }
            //de rechterkant van het blok
        } else if(blockX + blockWidth < getX() + marge) {
            if(goingUp()) {
                bounce(NORTH_EAST);
            } else {
                bounce(SOUTH_EAST);
            }
            //de bovenkant van het blok
        } else if(blockY + marge > getY() + getHeight()) {
            if(goingRight()) {
                bounce(NORTH_EAST);
            } else {
                bounce(NORTH_WEST);
            }
            //de onderkant van het block
        } else if(blockY + blockHeight < getY() + marge) {
            if(goingRight()) {
                bounce(SOUTH_EAST);
            } else {
                bounce(SOUTH_WEST);
            }
        }
    }

    public double getX() {
        return getAnchorLocation().getX();
    }

    public double getY() {
        return getAnchorLocation().getY();
    }
}