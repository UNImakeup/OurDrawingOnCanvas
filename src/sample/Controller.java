package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import sample.Figure.Circle;
import sample.Figure.Figure;
import sample.Figure.Line;
import sample.Figure.Square;

import java.awt.*;
import java.util.ArrayList;

public class Controller {

    public Slider sliderPenSize;
    public ColorPicker colorpicker;
    public Label labelPenSize;
    public ComboBox<Figure> comboBoxFigure;

    ArrayList<Figure> canvasFigures = new ArrayList<>();
    Figure activeFigure;

    public void initialize()
    {
        // runs when application GUI is ready
        System.out.println("ready!");

        comboBoxFigure.getItems().addAll(new Line(), new Circle(), new Square());

    }

    public void setPenSize(MouseEvent mouseEvent) {
        labelPenSize.setText(""+(int)sliderPenSize.getValue());
    }

    public void setFigure(ActionEvent actionEvent) {

    }

    public void canvasClicked(MouseEvent mouseEvent) {
        System.out.println("CanvasClick " + mouseEvent.getX() + ":"+mouseEvent.getY());

        System.out.println(comboBoxFigure.getValue());
        if (comboBoxFigure.getValue() != null) {
            if (activeFigure == null) {
                activeFigure = comboBoxFigure.getValue().getCopy();
                activeFigure.start = new Point((int) mouseEvent.getX(), (int) mouseEvent.getY());
                System.out.println("activefigure start point: " + activeFigure.start.toString());
            }
            else
            {
                activeFigure.end = new Point((int) mouseEvent.getX(), (int) mouseEvent.getY());
                System.out.println("activeFigure start point is: " + activeFigure.start.toString());
                System.out.println("and end point is: " + activeFigure.end.toString());
                canvasFigures.add(activeFigure);
                activeFigure = null;
            }
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Uuups!");
            alert.setHeaderText("No figure selected!");
            alert.setContentText("Choose a figure in the combobox");

            alert.showAndWait();
        }

    }
}
