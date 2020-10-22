package sample.Figure;

import javafx.scene.canvas.GraphicsContext;

public class Line extends Figure{
    @Override
    public String toString() {
        return "Line";
    }

    @Override
    public Figure getCopy() {
        return new Line();
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.strokeLine(start.getX(), start.getY(), end.getX(), end.getY());
    }
}
