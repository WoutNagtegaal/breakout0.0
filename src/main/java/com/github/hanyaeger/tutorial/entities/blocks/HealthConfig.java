package com.github.hanyaeger.tutorial.entities.blocks;

import com.github.hanyaeger.tutorial.BreakOutGame;
import com.github.hanyaeger.tutorial.entities.Player;
import com.github.hanyaeger.tutorial.scenes.levels.GameLevel;

public class HealthConfig extends BlockConfig {
    private final int health;

    public HealthConfig(GameLevel level, BreakOutGame breakOutGame, Player balk, String resource, int health) {
        super(level, breakOutGame, balk, resource);
        this.health = health;
    }

    public int getHealth() {
        return health;
    }
}
