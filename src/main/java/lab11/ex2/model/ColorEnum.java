package lab11.ex2.model;

import javafx.scene.paint.Color;

// Color enum to be used for making each particle a random color
public enum ColorEnum {
    RED(Color.RED),
    ORANGE(Color.ORANGE),
    YELLOW(Color.YELLOW),
    GREEN(Color.GREEN),
    BLUE(Color.TEAL),
    PURPLE(Color.PURPLE);

    private Color color;

    ColorEnum(Color color) { this.color = color; }

    public Color getColor() {
        return color;
    }
}
