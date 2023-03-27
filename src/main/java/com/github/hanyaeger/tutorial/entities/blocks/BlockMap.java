package com.github.hanyaeger.tutorial.entities.blocks;

import com.github.hanyaeger.api.scenes.TileMap;
import com.github.hanyaeger.tutorial.BreakOutGame;
import com.github.hanyaeger.tutorial.entities.SpelerBalk;
import com.github.hanyaeger.tutorial.scenes.GameLevel;

public abstract class BlockMap extends TileMap {

    GameLevel level;
    BreakOutGame breakOutGame;
    SpelerBalk balk;

    public BlockMap(GameLevel level, BreakOutGame breakOutGame, SpelerBalk balk) {
        this.level = level;
        this.breakOutGame = breakOutGame;
        this.balk = balk;
    }

    @Override
    public void setupEntities() {
        addEntity(1, Block.class, new BlockConfig(level, breakOutGame, balk, "sprites/enemy_1.png"));
        addEntity(2, GepantserdBlock.class, new HealthConfig(level, breakOutGame, balk, "sprites/enemy_2.png", 3));
        addEntity(3, PowerBlock.class, new BlockConfig(level, breakOutGame, balk, "sprites/enemy_3.png"));
        addEntity(4, Block.class, "sprites/enemy_4.png");
        addEntity(5, Block.class, "sprites/enemy_5.png");
    }
}
