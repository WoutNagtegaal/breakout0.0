package com.github.hanyaeger.tutorial.entities.blocks;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.tutorial.entities.Bal;
import com.github.hanyaeger.tutorial.entities.powers.*;
import com.github.hanyaeger.tutorial.BreakOutGame;
import com.github.hanyaeger.tutorial.entities.SpelerBalk;
import com.github.hanyaeger.tutorial.scenes.levels.GameLevel;

import java.util.Random;

public class PowerBlock extends Block {

    private final BreakOutGame breakOutGame;
    private final SpelerBalk spelerBalk;
    private final GameLevel level;

    private static final int POWER_BREEDTE = 35;
    private static final int POWER_HOOGTE = 35;

    public PowerBlock(Coordinate2D position, Size size, BlockConfig c) {
        super(position, size, c);
        this.breakOutGame = c.getBreakOutGame();
        this.spelerBalk = c.getBalk();
        this.level = c.getLevel();
    }

    public void doeHitActie() {
        int power = getRandomPower();
        switch (power) {
            case 1:
                // voeg de nieuwe power-up toe aan het spel
                ExtraBal extraBal = new ExtraBal(new Coordinate2D(getX(), getY()), new Size(POWER_BREEDTE, POWER_HOOGTE), breakOutGame, spelerBalk, level);
                level.addPower(extraBal);
                extraBal.dropPower();
                System.out.println("Power-up: Extra bal");
                break;
            case 2:
                // voeg de nieuwe power-up toe aan het spel
                VerbreedBalk verbreedBalk = new VerbreedBalk(new Coordinate2D(getX(), getY()), new Size(POWER_BREEDTE, POWER_HOOGTE), breakOutGame, spelerBalk, level);
                level.addPower(verbreedBalk);
                verbreedBalk.dropPower();
                System.out.println("Power-up: Balk extra breed");
                break;
            case 3:
                // voeg de nieuwe power-down toe aan het spel
                VersmalBalk versmalBalk = new VersmalBalk(new Coordinate2D(getX(), getY()), new Size(POWER_BREEDTE, POWER_HOOGTE), breakOutGame, spelerBalk, level);
                level.addPower(versmalBalk);
                versmalBalk.dropPower();
                System.out.println("Power-down: Balk extra smal");
                break;
            case 4:
                // voeg de nieuwe power-up toe aan het spel
                VersnelBalk versnelBalk = new VersnelBalk(new Coordinate2D(getX(), getY()), new Size(POWER_BREEDTE, POWER_HOOGTE), breakOutGame, spelerBalk);
                level.addPower(versnelBalk);
                versnelBalk.dropPower();
                System.out.println("Power-up: Balk extra snel");
                break;
            case 5:
                // voeg de nieuwe power-down toe aan het spel
                InvertControls invertControls = new InvertControls(new Coordinate2D(getX(), getY()), new Size(POWER_BREEDTE, POWER_HOOGTE), breakOutGame, spelerBalk);
                level.addPower(invertControls);
                invertControls.dropPower();
                System.out.println("Power-down: Inverted controls");
                break;
            case 6:
                // voeg de nieuwe power_up toe aan het spel
                VergrootBal vergrootBal = new VergrootBal(new Coordinate2D(getX(), getY()), new Size(POWER_BREEDTE, POWER_HOOGTE), breakOutGame, spelerBalk, level);
                level.addPower(vergrootBal);
                vergrootBal.dropPower();
                System.out.println("Power-up: Vergroot bal");
                break;
            case 7:
                // voeg de nieuwe power-down toe aan het spel
                VersmalBal versmalBal = new VersmalBal(new Coordinate2D(getX(), getY()), new Size(POWER_BREEDTE, POWER_HOOGTE), breakOutGame, spelerBalk, level);
                level.addPower(versmalBal);
                versmalBal.dropPower();
                System.out.println("Power-down: Versmal bal");
                break;
        }
        ontplof();
    }

    public int getRandomPower() {
        final int MIN_VALUE = 6;
        final int MAX_VALUE = 7;

        Random random = new Random();
        int random_number = random.nextInt(MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE;
        return random_number;
    }
}
