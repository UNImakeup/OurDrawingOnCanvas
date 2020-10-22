package sample.Figure;

public class Square extends Figure {
    @Override
    public String toString() {
        return "Square";
    }

    @Override
    public Figure getCopy() {
        return new Square();
    }
}
