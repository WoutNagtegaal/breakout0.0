package com.github.hanyaeger.tutorial.entities.text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class LevensText extends TextEntity {
    public LevensText(Coordinate2D location) {
        super(location);

        setFont(Font.font("Roboto", FontWeight.NORMAL, 30));
        setFill(Color.WHITE);
        System.out.println("LevensText");
    }

    public void setLevensText(int levensText) {
        setText("Health: " + levensText);
        System.out.println("setLevensText");
    }
}
