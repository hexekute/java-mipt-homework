package piDefinition.View;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import piDefinition.Control.Controller;

import java.util.List;

public class View extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        TextField numberField = new TextField();
        TextField valueField = new TextField();

        BorderPane borderPane = new BorderPane();
        borderPane.setMinWidth(500);
        borderPane.setMinHeight(500);
        borderPane.setCenter(addHBox(borderPane, "N", numberField,"PI", valueField));

        Scene scene = new Scene(borderPane);
        scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("PI Definition");
        primaryStage.show();
    }
    public static ScatterChart<Number, Number> addChart(List<List<Double>> radius,List<List<Double>> square,
                                                     List<List<Double>> values) {
        NumberAxis x = new NumberAxis();
        NumberAxis y = new NumberAxis();

        ScatterChart<Number, Number> chart = new ScatterChart<>(x, y);
        chart.setLegendVisible(false);
        chart.setVerticalZeroLineVisible(true);
        chart.setTitle("Chart");
        chart.getStyleClass().add("chart");
        chart.getData().add(addSeries(values));
        chart.getData().add(addSeries(radius));
        chart.getData().add(addSeries(square));
        return chart;
    }
    private static XYChart.Series<Number, Number> addSeries(List<List<Double>> values){
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        ObservableList<XYChart.Data<Number, Number>> datas = FXCollections.observableArrayList();
        for(int i = 0; i < values.get(0).size();i ++){
            datas.add(new XYChart.Data<>(values.get(0).get(i), values.get(1).get(i)));
        }
        series.setData(datas);
        return series;
    }

    private HBox addHBox(BorderPane borderPane, String textLabel, TextField numberField, String valueLabel, TextField valueField){
        HBox hBox = new HBox();

        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        Label label = new Label(textLabel);
        //TextField textField = new TextField();

        Button calculateBut = new Button("Define");
        calculateBut.getStyleClass().add("calcButton");
        Label piLabel = new Label(valueLabel);
        valueField.setEditable(false);
        calculateBut.setOnAction(event -> Controller.actionCalculateButton(borderPane, numberField, valueField));
        hBox.getChildren().addAll(label,numberField, calculateBut, piLabel, valueField);
        return hBox;
    }

}
