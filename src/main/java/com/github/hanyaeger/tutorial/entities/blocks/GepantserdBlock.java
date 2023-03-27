package com.github.hanyaeger.tutorial.entities.blocks;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.tutorial.BreakOutGame;
import com.github.hanyaeger.tutorial.entities.Bal;

public class GepantserdBlock extends Block {
    private int health;
    public GepantserdBlock(Coordinate2D position, Size size, String resource, int health) {
        super(position, size, resource);
        this.health = health;
    }

    public GepantserdBlock(Coordinate2D position, Size size, String resource) {
        super(position, size, resource);
        this.health = 2;
    }

    @Override
    public void onCollision(Collider collider) {
        if(collider instanceof Bal) {
            health--;
            if (health <= 0) {
                ontplof();
            }
        }
    }
}
