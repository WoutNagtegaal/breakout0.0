package com.github.hanyaeger.tutorial.entities.powers;

import com.github.hanyaeger.api.scenes.TileMap;
import com.github.hanyaeger.tutorial.entities.blocks.Block;
import com.github.hanyaeger.tutorial.entities.blocks.GepantserdBlock;
import com.github.hanyaeger.tutorial.entities.blocks.PowerBlock;

public abstract class Powers extends TileMap {
    @Override
    public void setupEntities() {
        addEntity(1, ExtraBal.class, "sprites/extra_bal.png");
        addEntity(2, VerbreedtBalk.class, "sprites/verbreed_balk.png");
        addEntity(3, VersmalBalk.class, "sprites/versmal_balk.png");
    }
}

