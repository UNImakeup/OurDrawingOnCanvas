package sample.Figure;

public class Circle extends Figure {
    @Override
    public String toString() {
        return("Circle");
    }

    @Override
    public Figure getCopy() {
        return new Circle();
    }
}
