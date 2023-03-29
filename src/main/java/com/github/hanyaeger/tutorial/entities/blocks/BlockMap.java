package com.github.hanyaeger.tutorial.entities.blocks;

import com.github.hanyaeger.api.scenes.TileMap;
import com.github.hanyaeger.tutorial.BreakOutGame;
import com.github.hanyaeger.tutorial.entities.Player;
import com.github.hanyaeger.tutorial.scenes.levels.GameLevel;

public abstract class BlockMap extends TileMap {

    GameLevel level;
    BreakOutGame breakOutGame;
    Player balk;

    public BlockMap(GameLevel level, BreakOutGame breakOutGame, Player balk) {
        this.level = level;
        this.breakOutGame = breakOutGame;
        this.balk = balk;
    }

    @Override
    public void setupEntities() {
        addEntity(1, Block.class, new BlockConfig(level, breakOutGame, balk, "sprites/enemy_1.png"));
        addEntity(2, GepantserdBlock.class, new HealthConfig(level, breakOutGame, balk, "sprites/enemy_2.png", 2));
        addEntity(3, PowerBlock.class, new BlockConfig(level, breakOutGame, balk, "sprites/enemy_3.png"));
    }
}
