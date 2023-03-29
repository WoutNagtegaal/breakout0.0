package com.github.hanyaeger.tutorial.entities.blocks;

import com.github.hanyaeger.api.scenes.TileMap;
import com.github.hanyaeger.tutorial.BreakOutGame;
import com.github.hanyaeger.tutorial.entities.Player;
import com.github.hanyaeger.tutorial.scenes.levels.GameLevel;

public abstract class BlockMap extends TileMap {

    protected GameLevel level;
    protected BreakOutGame breakOutGame;
    protected Player player;

    public BlockMap(GameLevel level, BreakOutGame breakOutGame, Player player) {
        this.level = level;
        this.breakOutGame = breakOutGame;
        this.player = player;
    }

    @Override
    public void setupEntities() {
        addEntity(1, Block.class, new BlockConfig(level, breakOutGame, player, "sprites/enemy_1.png"));
        addEntity(2, HealthBlock.class, new HealthConfig(level, breakOutGame, player, "sprites/enemy_2.png", 2));
        addEntity(3, PowerBlock.class, new BlockConfig(level, breakOutGame, player, "sprites/enemy_3.png"));
    }
}
