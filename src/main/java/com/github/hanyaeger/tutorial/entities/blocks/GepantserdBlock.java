package com.github.hanyaeger.tutorial.entities.blocks;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class GepantserdBlock extends Block {
    private int health;
    public GepantserdBlock(Coordinate2D position, Size size, HealthConfig c) {
        super(position, size, c);
        this.health = c.getHealth();
    }

    @Override
    public void doCollisionAction() {
        health--;
        if (health <= 0) {
            explode();
        }
    }
}
