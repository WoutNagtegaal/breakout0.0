package com.github.hanyaeger.tutorial.entities.blocks;

import com.github.hanyaeger.tutorial.BreakOutGame;
import com.github.hanyaeger.tutorial.entities.Player;
import com.github.hanyaeger.tutorial.scenes.levels.GameLevel;

public class BlockConfig {
    private GameLevel level;
    private BreakOutGame breakOutGame;
    private Player balk;
    private String resource;

    public BlockConfig(GameLevel level, BreakOutGame breakOutGame, Player balk, String resource) {
        this.level = level;
        this.breakOutGame = breakOutGame;
        this.balk = balk;
        this.resource = resource;
    }

    public GameLevel getLevel() {
        return level;
    }

    public BreakOutGame getBreakOutGame() {
        return breakOutGame;
    }

    public Player getPlayer() {
        return balk;
    }

    public String getResource() {
        return resource;
    }
}
