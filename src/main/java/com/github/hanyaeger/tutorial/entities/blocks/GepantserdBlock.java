package com.github.hanyaeger.tutorial.entities.blocks;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.tutorial.BreakOutGame;

public class GepantserdBlock extends Block {
    private int health;
    public GepantserdBlock(BreakOutGame breakOutGame, Coordinate2D position, int health) {
        super(breakOutGame, position);
        this.health = health;
    }

    @Override
    public void onCollision(Collider collider) {
        health--;
        if(health <= 0) {
            ontplof();
        }
    }
}
