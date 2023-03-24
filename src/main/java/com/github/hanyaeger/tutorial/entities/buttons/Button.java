package com.github.hanyaeger.tutorial.entities.buttons;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import com.github.hanyaeger.tutorial.BreakOutGame;
import javafx.scene.Cursor;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public abstract class Button extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {
    protected BreakOutGame breakOutGame;

    public Button(Coordinate2D location, BreakOutGame breakOutGame, String text) {
        super(location, text);
        setFill(Color.RED);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        this.breakOutGame = breakOutGame;
    }

    @Override
    public void onMouseEntered() {
        setFill(Color.VIOLET);
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited() {
        setFill(Color.RED);
        setCursor(Cursor.DEFAULT);
    }
}
