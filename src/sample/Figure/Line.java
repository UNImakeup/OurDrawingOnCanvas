package sample.Figure;

public class Line extends Figure{
    @Override
    public String toString() {
        return "Line";
    }

    @Override
    public Figure getCopy() {
        return new Line();
    }
}
