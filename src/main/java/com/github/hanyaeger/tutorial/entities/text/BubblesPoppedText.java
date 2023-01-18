package com.github.hanyaeger.tutorial.entities.text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class BubblesPoppedText extends TextEntity {
  public BubblesPoppedText(Coordinate2D location) {
    super(location);

    setFont(Font.font("Roboto", FontWeight.NORMAL, 30));
    setFill(Color.DARKBLUE);
  }

  public void setBubblesPoppedText(int bubblesPopped) {
    setText("Bubbles popped: " + bubblesPopped);
  }
}
