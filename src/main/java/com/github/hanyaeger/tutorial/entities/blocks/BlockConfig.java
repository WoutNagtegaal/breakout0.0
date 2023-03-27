package com.github.hanyaeger.tutorial.entities.blocks;

import com.github.hanyaeger.tutorial.BreakOutGame;
import com.github.hanyaeger.tutorial.entities.SpelerBalk;
import com.github.hanyaeger.tutorial.scenes.GameLevel;

public class BlockConfig {
    GameLevel level;
    BreakOutGame breakOutGame;
    SpelerBalk balk;
    String resource;

    public BlockConfig(GameLevel level, BreakOutGame breakOutGame, SpelerBalk balk, String resource) {
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

    public SpelerBalk getBalk() {
        return balk;
    }

    public String getResource() {
        return resource;
    }
}
