package piDefinition.Control;

import javafx.scene.chart.ScatterChart;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import piDefinition.Model.Calculate;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    public static void actionCalculateButton(BorderPane borderPane, TextField numberField, TextField valueField){
        try{

            List<List<Double>> values = Calculate.getRandomPoints(Integer.parseInt(numberField.getText()));
            List<List<Double>> circle = addCircle(1);
            List<List<Double>> square = addSquare(1);
            if(values.get(0).size() > 14000){
                valueField.setText(String.valueOf(Calculate.countPI(values)));
            }else{
                ScatterChart<Number, Number> numberLineChart = piDefinition.View.View.addChart(circle, square, values);
                //numberLineChart.getData().add();
                borderPane.setTop(numberLineChart);
                valueField.setText(String.valueOf(Calculate.countPI(values)));
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

    private static List<List<Double>> addCircle(double radius) {
        List<List<Double>> circle= new ArrayList<>();
        List<Double> xList = new ArrayList<>();
        List<Double> yList = new ArrayList<>();
        for(double x = 0; x<=radius;x+=radius/800){
            xList.add(x);
            yList.add(Math.sqrt(Math.pow(radius, 2) - Math.pow(x,2)));
        }
        xList.add(radius);
        yList.add(0.0);

        circle.add(xList);
        circle.add(yList);
        return circle;
    }
    private static List<List<Double>> addSquare(double length) {
        List<List<Double>> circle= new ArrayList<>();
        List<Double> xList = new ArrayList<>();
        List<Double> yList = new ArrayList<>();
        for(double x = 0; x<=length;x+=length/400){
            xList.add(x);
            yList.add(length);
        }
        for(double y = 0; y<=length;y+=length/400){
            xList.add(length);
            yList.add(y);
        }
        circle.add(xList);
        circle.add(yList);
        return circle;
    }
}
