package sample;

import QuoteMachine.Quote;
import QuoteMachine.QuoteMachine;
import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
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
    public Canvas canvas;
    public Label quoteText;
    public Label quoteTextSource;
    private GraphicsContext graphicsContext;

    ArrayList<Figure> canvasFigures = new ArrayList<>();
    Figure activeFigure;

    public void initialize()
    {
        // runs when application GUI is ready
        System.out.println("ready!");

        comboBoxFigure.getItems().addAll(new Line(), new Circle(), new Square());

        graphicsContext = canvas.getGraphicsContext2D();

         QuoteMachine quoteMachine = new QuoteMachine();

         QuoteUpdater quoteUpdater  = new QuoteUpdater(this, quoteMachine);
         Runnable target;
         Thread t = new Thread(quoteUpdater);
         t.start();

    }

    public void updateQuote(String quote, String source)
    {
        quoteText.setText(quote);
        quoteTextSource.setText(source);
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
                drawActiveFigure(activeFigure);
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

    private void drawActiveFigure(Figure activeFigure) {
        graphicsContext.setStroke(colorpicker.getValue());
        activeFigure.draw(graphicsContext);
    }
}
