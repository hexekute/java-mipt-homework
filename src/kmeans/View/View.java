package kmeans.View;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
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
import kmeans.Control.Controller;

import java.util.ArrayList;
import java.util.List;

public class View extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    public static List<List<List<Double>>> dots = new ArrayList<>();
    public static List<List<Double>> points = new ArrayList<>();
    @Override
    public void start(Stage primaryStage) {
        TextField numberField = new TextField();
        TextField pointsField = new TextField();

        BorderPane borderPane = new BorderPane();
        borderPane.setMinWidth(900);
        borderPane.setMinHeight(600);
        borderPane.setBottom(addChooseBox(borderPane, numberField, pointsField));

        Scene scene = new Scene(borderPane);
        scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("k-means");
        primaryStage.show();
    }
    public static ScatterChart<Number, Number> addChart(List<List<Double>> dots) {
        NumberAxis x = new NumberAxis();
        NumberAxis y = new NumberAxis();
        ScatterChart<Number, Number> chart = new ScatterChart<>(x, y);
        chart.setLegendVisible(false);
        chart.setVerticalZeroLineVisible(true);
        //chart.setTitle("Chart");
        chart.getStyleClass().add("chart");
        chart.getData().add(addSeries(View.points));
        chart.getData().add(addSeries(dots));
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
    public static HBox addChooseBox(BorderPane borderPane, TextField numberField, TextField pointsField){
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(15));
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        Button randomBut = new Button("Random Points");
        randomBut.setOnAction(event -> borderPane.setBottom(addRandBox(borderPane, numberField, pointsField)));
        randomBut.getStyleClass().add("calcButton");
        Button readBut = new Button("File Points");
        readBut.setOnAction(event -> borderPane.setBottom(addReadBox(borderPane, numberField, pointsField)));
        readBut.getStyleClass().add("calcButton");

        hBox.getChildren().addAll(randomBut, readBut);
        return hBox;
    }
    private static HBox addRandBox(BorderPane borderPane, TextField numberField, TextField pointsField){
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(15));
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        Label label = new Label("N");
        Label pointsLabel = new Label("points");
        //TextField textField = new TextField();
        Label stepLabel = new Label("Step");
        Label stepNumber = new Label("0");

        Button backButton = new Button("back");
        backButton.setOnAction(event -> Controller.actionBackButton(borderPane, numberField,pointsField));
        backButton.getStyleClass().add("calcButton");

        Button calculateBut = new Button("Set");
        calculateBut.setOnAction(event -> Controller.actionRandButton(borderPane, numberField,pointsField, stepNumber));
        calculateBut.getStyleClass().add("calcButton");

        Button prevBut = new Button("prev");
        prevBut.setOnAction(event -> Controller.actionPrevButton(borderPane, stepNumber));
        prevBut.getStyleClass().add("calcButton");

        Button nextBut = new Button("next");
        nextBut.setOnAction(event -> Controller.actionNextButton(borderPane, stepNumber));
        nextBut.getStyleClass().add("calcButton");

        Button finalBut = new Button("final");
        finalBut.setOnAction(event -> Controller.actionFinalButton(borderPane, stepNumber));
        finalBut.getStyleClass().add("calcButton");

        hBox.getChildren().addAll(backButton, label,numberField, pointsLabel, pointsField, calculateBut, prevBut, stepLabel, stepNumber, nextBut, finalBut);
        return hBox;
    }
    private static HBox addReadBox(BorderPane borderPane, TextField numberField, TextField pointsField){
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(15));
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        Label label = new Label("N");
        //TextField textField = new TextField();
        Label stepLabel = new Label("Step");
        Label stepNumber = new Label("0");

        Button backButton = new Button("back");
        backButton.setOnAction(event -> Controller.actionBackButton(borderPane, numberField, pointsField));
        backButton.getStyleClass().add("calcButton");

        Button calculateBut = new Button("Set");
        calculateBut.setOnAction(event -> Controller.actionCalculateButton(borderPane, numberField, stepNumber));
        calculateBut.getStyleClass().add("calcButton");

        Button prevBut = new Button("prev");
        prevBut.setOnAction(event -> Controller.actionPrevButton(borderPane, stepNumber));
        prevBut.getStyleClass().add("calcButton");

        Button nextBut = new Button("next");
        nextBut.setOnAction(event -> Controller.actionNextButton(borderPane, stepNumber));
        nextBut.getStyleClass().add("calcButton");

        Button finalBut = new Button("final");
        finalBut.setOnAction(event -> Controller.actionFinalButton(borderPane, stepNumber));
        finalBut.getStyleClass().add("calcButton");

        hBox.getChildren().addAll(backButton, label,numberField, calculateBut, prevBut, stepLabel, stepNumber, nextBut, finalBut);
        return hBox;
    }
}
