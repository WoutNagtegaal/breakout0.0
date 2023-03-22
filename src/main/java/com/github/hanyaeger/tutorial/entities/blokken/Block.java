package com.github.hanyaeger.tutorial.entities.blokken;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.tutorial.BreakOutGame;

public class Block extends DynamicSpriteEntity {
    private final BreakOutGame breakOutGame;
    private static final int BLOCK_WIDTH = 500;
    private static int BLOCK_HEIGHT = 200;
    private int color;
    public Coordinate2D position;

    public Block(BreakOutGame breakOutGame, Coordinate2D position, int color) {
        super("sprites/swordfish.png", position, new Size(BLOCK_WIDTH, BLOCK_HEIGHT));
        this.breakOutGame = breakOutGame;
        this.color = color;
    }

    public void onCollision(Collider collider) {
    }
}
