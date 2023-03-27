package com.github.hanyaeger.tutorial.entities.blocks;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.tutorial.entities.Bal;
import com.github.hanyaeger.tutorial.entities.powers.ExtraBal;
//import com.github.hanyaeger.tutorial.BreakOutGame;
//import com.github.hanyaeger.tutorial.entities.SpelerBalk;
import java.util.Random;

public class PowerBlock extends Block {

//    private final BreakOutGame breakOutGame;
//    private final SpelerBalk spelerBalk;

    public PowerBlock(Coordinate2D position, Size size, String resource) {
        super(position, size, resource);
//        this.breakOutGame = breakOutGame;
//        this.spelerBalk = spelerBalk;
    }

    @Override
    public void onCollision(Collider collider) {
        if (collider instanceof Bal) {
            int power = getRandomPower();
            switch (power) {
                case 1:
                    // voeg de nieuwe power-up toe aan het spel
                    System.out.println("Power-up: Extra bal");
                    break;
                case 2:
                    // voeg de nieuwe power-up toe aan het spel
                    System.out.println("Power-up: Balk extra breed");
                    break;
                case 3:
                    // voeg de nieuwe power-down toe aan het spel
                    System.out.println("Power-down: Balk extra smal");
                    break;
                case 4:
                    // voeg de nieuwe power-up toe aan het spel
                    System.out.println("Power-up: Balk extra snel");
                    break;
                case 5:
                    // voeg de nieuwe power-down toe aan het spel
                    System.out.println("Power-down: Inverted controls");
                    break;
            }
//            System.out.println(power);
            ontplof();
        }
    }

    public int getRandomPower() {
        final int MIN_VALUE = 1;
        final int MAX_VALUE = 5;

        Random random = new Random();
        int random_number = random.nextInt(MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE;
        return random_number;
    }
}
