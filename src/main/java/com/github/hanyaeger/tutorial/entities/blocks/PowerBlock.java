package com.github.hanyaeger.tutorial.entities.blocks;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.tutorial.entities.Bal;
import java.util.Random;

public class PowerBlock extends Block {

    public PowerBlock(Coordinate2D position, Size size, String resource) {
        super(position, size, resource);
    }

    @Override
    public void onCollision(Collider collider) {
        if (collider instanceof Bal) {
            int power = getRandomPower();
            switch (power) {
                case 1:
                    System.out.println("Power-up: Extra bal");
                    break;
                case 2:
                    System.out.println("Power-up: Balk extra breed");
                    break;
                case 3:
                    System.out.println("Power-down: Balk extra smal");
                    break;
            }
            System.out.println(power);
            ontplof();
        }
    }

    public int getRandomPower() {
        final int MIN_VALUE = 1;
        final int MAX_VALUE = 3;

        Random random = new Random();
        int random_number = random.nextInt(MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE;
        return random_number;
    }
}
