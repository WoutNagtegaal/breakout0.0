package com.github.hanyaeger.tutorial.entities.blocks;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.tutorial.entities.Player;
import com.github.hanyaeger.tutorial.entities.powers.*;
import com.github.hanyaeger.tutorial.BreakOutGame;
import com.github.hanyaeger.tutorial.scenes.levels.GameLevel;

import java.util.Random;

public class PowerBlock extends Block {

    private final BreakOutGame breakOutGame;
    private final Player spelerBalk;
    private final GameLevel level;

    private static final int POWER_BREEDTE = 35;
    private static final int POWER_HOOGTE = 35;

    public PowerBlock(Coordinate2D position, Size size, BlockConfig c) {
        super(position, size, c);
        this.breakOutGame = c.getBreakOutGame();
        this.spelerBalk = c.getBalk();
        this.level = c.getLevel();
    }

    public void doCollisionAction() {
        /*
        int power = getRandomPower();
        switch (power) {
            case 1:
                // voeg de nieuwe power-up toe aan het spel
                ExtraBal extraBal = new ExtraBal(new Coordinate2D(getX(), getY()), new Size(POWER_BREEDTE, POWER_HOOGTE), breakOutGame, spelerBalk, level);
                level.addPower(extraBal);
                extraBal.dropPower();
                break;
            case 2:
                // voeg de nieuwe power-up toe aan het spel
                VerbreedBalk verbreedBalk = new VerbreedBalk(new Coordinate2D(getX(), getY()), new Size(POWER_BREEDTE, POWER_HOOGTE), breakOutGame, spelerBalk, level);
                level.addPower(verbreedBalk);
                verbreedBalk.dropPower();
                break;
            case 3:
                // voeg de nieuwe power-down toe aan het spel
                VersmalBalk versmalBalk = new VersmalBalk(new Coordinate2D(getX(), getY()), new Size(POWER_BREEDTE, POWER_HOOGTE), breakOutGame, spelerBalk, level);
                level.addPower(versmalBalk);
                versmalBalk.dropPower();
                break;
            case 4:
                // voeg de nieuwe power-up toe aan het spel
                VersnelBalk versnelBalk = new VersnelBalk(new Coordinate2D(getX(), getY()), new Size(POWER_BREEDTE, POWER_HOOGTE), breakOutGame, spelerBalk);
                level.addPower(versnelBalk);
                versnelBalk.dropPower();
                break;
            case 5:
                // voeg de nieuwe power-down toe aan het spel
                InvertControls invertControls = new InvertControls(new Coordinate2D(getX(), getY()), new Size(POWER_BREEDTE, POWER_HOOGTE), breakOutGame, spelerBalk);
                level.addPower(invertControls);
                invertControls.dropPower();
                break;

            case 6:
                // voeg de nieuwe power_up toe aan het spel
                VergrootBal vergrootBal = new VergrootBal(new Coordinate2D(getX(), getY()), new Size(POWER_BREEDTE, POWER_HOOGTE), breakOutGame, spelerBalk, level);
                level.addPower(vergrootBal);
                vergrootBal.dropPower();
                break;
            case 7:
                // voeg de nieuwe power-down toe aan het spel
                VersmalBal versmalBal = new VersmalBal(new Coordinate2D(getX(), getY()), new Size(POWER_BREEDTE, POWER_HOOGTE), breakOutGame, spelerBalk, level);
                level.addPower(versmalBal);
                versmalBal.dropPower();
                break;


        }

         */
        Power power = getRandomPower();
        level.addPower(power);
        power.dropPower();

        explode();
    }

    public int getRandomPowerOld() {
        final int MIN_VALUE = 1;
        final int MAX_VALUE = 5;

        Random random = new Random();
        int random_number = random.nextInt(MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE;
        return random_number;
    }

    public Power getRandomPower() {
        final int MIN_VALUE = 1;
        final int MAX_VALUE = 5;

        Random random = new Random();
        int random_number = random.nextInt(MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE;
        switch (random_number) {
            case 1 -> {
                return new ExtraBal(new Coordinate2D(getX(), getY()), new Size(POWER_BREEDTE, POWER_HOOGTE), breakOutGame, spelerBalk, level);
            }
            case 2 -> {
                return new VerbreedBalk(new Coordinate2D(getX(), getY()), new Size(POWER_BREEDTE, POWER_HOOGTE), breakOutGame, spelerBalk, level);
            }
            case 3 -> {
                return new VersmalBalk(new Coordinate2D(getX(), getY()), new Size(POWER_BREEDTE, POWER_HOOGTE), breakOutGame, spelerBalk, level);
            }
            case 4 -> {
                return new VersnelBalk(new Coordinate2D(getX(), getY()), new Size(POWER_BREEDTE, POWER_HOOGTE), breakOutGame, spelerBalk);
            }
            default -> {
                return new InvertControls(new Coordinate2D(getX(), getY()), new Size(POWER_BREEDTE, POWER_HOOGTE), breakOutGame, spelerBalk);
            }
        }
    }
}
