package kmeans.Control;

import javafx.scene.chart.ScatterChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import kmeans.Model.Calculate;
import kmeans.Model.Reader;
import kmeans.View.View;

public class Controller {
            public static void actionCalculateButton(BorderPane borderPane, TextField numberField, Label stepNumber){
        try{
            View.dots.clear();
            View.points = Reader.readFile();
            Calculate.setRandomCenters(Integer.parseInt(numberField.getText()));
            do{
                Calculate.kMeans();
            }while(!View.dots.get(View.dots.size() - 1).get(0).equals(View.dots.get(View.dots.size() - 2).get(0)));
            View.dots.remove(View.dots.size() - 1);

            stepNumber.setText("1");
            ScatterChart<Number, Number> numberLineChart = kmeans.View.View.addChart(View.dots.get(0));
            borderPane.setCenter(numberLineChart);

        }catch (IllegalArgumentException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Error: " + e.getMessage());
            alert.showAndWait();
        }catch (OutOfMemoryError e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Error: out of memory. N is too big");
            alert.showAndWait();

        }
    }
    public static void actionRandButton(BorderPane borderPane, TextField numberField, TextField pointsField, Label stepNumber){
        try{
            View.dots.clear();
            Calculate.setRandomPoints(Integer.parseInt(pointsField.getText()));
            Calculate.setRandomCenters(Integer.parseInt(numberField.getText()));
            do{
                Calculate.kMeans();
            }while(!View.dots.get(View.dots.size() - 1).get(0).equals(View.dots.get(View.dots.size() - 2).get(0)));
            View.dots.remove(View.dots.size() - 1);

            stepNumber.setText("1");
            ScatterChart<Number, Number> numberLineChart = kmeans.View.View.addChart(View.dots.get(0));
            borderPane.setCenter(numberLineChart);

        }catch (IllegalArgumentException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Error: " + e.getMessage());
            alert.showAndWait();
        }catch (OutOfMemoryError e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Error: out of memory. N is too big");
            alert.showAndWait();

        }
    }
    public static void actionBackButton(BorderPane borderPane, TextField numberField, TextField pointsField){
        try{
            View.dots.clear();
            View.points.clear();
            numberField.clear();
            pointsField.clear();
            borderPane.setBottom(View.addChooseBox(borderPane, numberField, pointsField));
        }catch (IllegalArgumentException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Error: " + e.getMessage());
            alert.showAndWait();
        }catch (OutOfMemoryError e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Error: out of memory. N is too big");
            alert.showAndWait();

        }
    }
    public static void actionNextButton(BorderPane borderPane, Label stepNumber){
        try{
            if(Integer.parseInt(stepNumber.getText()) < View.dots.size()){
                stepNumber.setText(Integer.toString(Integer.parseInt(stepNumber.getText()) + 1));
                ScatterChart<Number, Number> numberLineChart = kmeans.View.View.addChart(View.dots.get(Integer.parseInt(stepNumber.getText()) - 1));
                borderPane.setCenter(numberLineChart);
            }

        }catch (IllegalArgumentException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Error: " + e.getMessage());
            alert.showAndWait();
        }catch (OutOfMemoryError e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Error: out of memory. N is too big");
            alert.showAndWait();

        }
    }
    public static void actionPrevButton(BorderPane borderPane, Label stepNumber){
        try{
            if(Integer.parseInt(stepNumber.getText()) > 1){
                ScatterChart<Number, Number> numberLineChart = kmeans.View.View.addChart(View.dots.get(Integer.parseInt(stepNumber.getText()) - 2));
                stepNumber.setText(Integer.toString(Integer.parseInt(stepNumber.getText()) - 1));
                borderPane.setCenter(numberLineChart);
            }

        }catch (IllegalArgumentException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Error: " + e.getMessage());
            alert.showAndWait();
        }catch (OutOfMemoryError e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Error: out of memory. N is too big");
            alert.showAndWait();

        }
    }
    public static void actionFinalButton(BorderPane borderPane, Label stepNumber){
        try{
            ScatterChart<Number, Number> numberLineChart = kmeans.View.View.addChart(View.dots.get(View.dots.size() - 1));
            stepNumber.setText(Integer.toString(View.dots.size()));
            borderPane.setCenter(numberLineChart);

        }catch (IllegalArgumentException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Error: " + e.getMessage());
            alert.showAndWait();
        }catch (OutOfMemoryError e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Error: out of memory. N is too big");
            alert.showAndWait();

        }
    }
}
