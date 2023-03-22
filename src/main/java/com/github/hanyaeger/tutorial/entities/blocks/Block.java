package com.github.hanyaeger.tutorial.entities.blocks;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.tutorial.BreakOutGame;

public class Block extends DynamicSpriteEntity implements Collided {
    private final BreakOutGame breakOutGame;
    private static final int BLOCK_WIDTH = 500;
    private static int BLOCK_HEIGHT = 200;
    private int color;
    public Coordinate2D position;

    public Block(BreakOutGame breakOutGame, Coordinate2D position, int color) {
        super("sprites/enemy_1.png", position, new Size(BLOCK_WIDTH, BLOCK_HEIGHT));
        this.breakOutGame = breakOutGame;
        this.color = color;
    }

    @Override
    public void onCollision(Collider collider) {
        remove();
    }
}
