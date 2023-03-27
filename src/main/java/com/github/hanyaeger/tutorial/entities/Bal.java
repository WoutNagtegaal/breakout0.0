package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.tutorial.BreakOutGame;
//import com.github.hanyaeger.tutorial.entities.levels.Block;
import com.github.hanyaeger.tutorial.entities.blocks.Block;
import com.github.hanyaeger.tutorial.scenes.levels.GameLevel;

public class Bal extends DynamicSpriteEntity implements SceneBorderTouchingWatcher, Collider, Collided {
    private final BreakOutGame breakOutGame;
    private final int GROOTTE = 50;
    private final SpelerBalk spelerBalk;
    private final GameLevel level;
    private boolean isVastgehouden;
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

    @SuppressWarnings("LanguageDetectionInspection")
    public Bal(BreakOutGame breakOutGame, GameLevel level, SpelerBalk balk, double x, double y) {
        //super("sprites/ufobalk.png", location, new Size(800, 40));
        super("sprites/bal.png", new Coordinate2D(x, y), new Size(50, 50));

        setMotion(SPEED, startDirection);

        this.breakOutGame = breakOutGame;
        this.spelerBalk = balk;
        this.isVastgehouden = true;
        this.level = level;

    }

    public void resetBal() {
        setAnchorLocationX(getSceneWidth() / 2);
        setAnchorLocationY(getSceneHeight() / 2);
        setDirection(startDirection);
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder sceneBorder) {
        //Controleerd tegen welke rand is gebosts en stuitert de bal
        switch (sceneBorder) {
            case TOP -> {
                if(gaatNaarRechts()) {
                    stuiter(SOUTH_EAST);
                } else {
                    stuiter(SOUTH_WEST);
                }
                setAnchorLocationY(1);
            }
            case BOTTOM -> {
                level.verwijderBal();
                remove();
            }
            case LEFT -> {
                if(gaatNaarBoven()) {
                    stuiter(NORTH_EAST);
                } else {
                    stuiter(SOUTH_EAST);
                }
                setAnchorLocationX(1);
            }
            case RIGHT -> {
                if(gaatNaarBoven()) {
                    stuiter(NORTH_WEST);
                } else {
                    stuiter(SOUTH_WEST);
                }
                setAnchorLocationX(getSceneWidth() - getWidth() - 1);
            }
        }
    }

    boolean gaatNaarRechts() {
        return getDirection() > SOUTH && getDirection() < NORTH;
    }

    boolean gaatNaarBoven() {
        return getDirection() > EAST && getDirection() < WEST;
    }

    public void stuiter(double hoek) {
        setDirection(hoek);
    }

    @Override
    public void onCollision(Collider collider) {
        //Bij de balk stuitert de bal naar linksboven wanneer de bal de balk links raakt en naar
        //rechts wanneer de bal de balk rechts raakt
        if(collider instanceof SpelerBalk) {
            if (getX() + (getWidth() / 2) > spelerBalk.getX() + (spelerBalk.getWidth() / 2)) {
                stuiter(NORTH_EAST);
            } else {
                stuiter(NORTH_WEST);
            }
        }
        //Bij een blok moet de bal van de zijkant af stuiteren. Beetje rommelige manier, zal nog wel netter kunnen
        else if(collider instanceof Block) {
            double marge = 6; //snelheid van bal + 1 deze is nodig omdat de bal 5 pixels in een seconde beweegt en
            //zonder deze marge kan niet altijd bepaald worden aan welke kant de bal naar binnen is gegaan omdat de bal
            //al te ver het blok in is gegaan

            //eigenschappen van het blok uitlezen
            double blockX = ((Block) collider).getX();
            double blockY = ((Block) collider).getY();
            double blockWidth = collider.getWidth();
            double blockHeight = collider.getHeight();

            //de linkerkant van het blok
            if(blockX + marge > getX() + getWidth()) {
                if(gaatNaarBoven()) {
                    stuiter(NORTH_WEST);
                } else {
                    stuiter(SOUTH_WEST);
                }
            //de rechterkant van het blok
            } else if(blockX + blockWidth < getX() + marge) {
                if(gaatNaarBoven()) {
                    stuiter(NORTH_EAST);
                } else {
                    stuiter(SOUTH_EAST);
                }
            //de bovenkant van het blok
            } else if(blockY + marge > getY() + getHeight()) {
                if(gaatNaarRechts()) {
                    stuiter(NORTH_EAST);
                } else {
                    stuiter(NORTH_WEST);
                }
            //de onderkant van het block
            } else if(blockY + blockHeight < getY() + marge) {
                if(gaatNaarRechts()) {
                    stuiter(SOUTH_EAST);
                } else {
                    stuiter(SOUTH_WEST);
                }
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