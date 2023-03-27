package com.github.hanyaeger.tutorial.entities.blocks;

import com.github.hanyaeger.api.scenes.TileMap;

public abstract class BlockMap extends TileMap {
    @Override
    public void setupEntities() {
        addEntity(1, Block.class, "sprites/enemy_1.png");
        addEntity(2, GepantserdBlock.class, new HealthConfig("sprites/enemy_2.png", 3));
        addEntity(3, PowerBlock.class, "sprites/enemy_3.png");
        addEntity(4, Block.class, "sprites/enemy_4.png");
        addEntity(5, Block.class, "sprites/enemy_5.png");
    }
}
