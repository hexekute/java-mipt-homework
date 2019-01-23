package calculator.View;

import calculator.Control.Controller;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class View extends Application {
    private TextField answerField = new TextField();
    private TextField stringField = new TextField();
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(addTopPane());

        borderPane.setCenter(addBtnPane());

        Scene scene = new Scene(borderPane);
        scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Calculator");
        primaryStage.show();
    }
    private GridPane addBtnPane(){
        GridPane btnPane = new GridPane();
        btnPane.add(addDeleteButton("C"),0,0);
        btnPane.add(addDeleteButton("AC"),1,0);
        btnPane.add(addDeleteButton("<-"),2,0);
        for(int i = 1; i<=3;i++){
            for(int j = 1; j<=3;j++){
                btnPane.add(addNumButton(i+(j-1)*3),i-1, j);
            }
        }
        btnPane.add(addOperationButton("/"),4,0);
        btnPane.add(addOperationButton("*"),4,1);
        btnPane.add(addOperationButton("+"),4,2);
        btnPane.add(addOperationButton("-"),4,3);
        btnPane.add(addNumButton(0),1,4);
        btnPane.add(addCommaButton(),2,4);
        btnPane.setAlignment(Pos.CENTER);
        btnPane.getStyleClass().add("btnPane");
        return btnPane;
    }


    private BorderPane addTopPane(){
        BorderPane topPane = new BorderPane();
        topPane.setBottom(answerField);
        topPane.setCenter(stringField);
        answerField.setEditable(false);
        stringField.setEditable(false);
        answerField.getStyleClass().add("ansField");
        stringField.getStyleClass().add("stringField");

        topPane.getStyleClass().add("topPane");
        return topPane;
    }
    private BorderPane addNumButton(Integer numb){
        Button button = new Button(numb.toString());
        button.setOnAction(event -> Controller.actionNumButton(stringField, answerField, numb));
        BorderPane pane = new BorderPane();
        pane.getStyleClass().add("paneButton");
        button.getStyleClass().add("numButton");
        pane.setCenter(button);
        return pane;
    }
    private BorderPane addOperationButton(String operation){
        Button button = new Button(operation);
        button.setOnAction(event -> Controller.actionOperateButton(stringField, operation));
        BorderPane pane = new BorderPane();
        pane.setCenter(button);
        pane.getStyleClass().add("paneButton");
        return pane;
    }
    private BorderPane addDeleteButton(String operation){

        Button button = new Button(operation);
        button.setOnAction(event -> Controller.actionDeleteButton(stringField,answerField, operation));
        BorderPane pane = new BorderPane();
        pane.setCenter(button);
        pane.getStyleClass().add("paneButton");
        return pane;
    }
    private BorderPane addCommaButton(){
        Button button = new Button(".");
        button.setOnAction(event -> Controller.actionCommaButton(stringField));
        BorderPane pane = new BorderPane();
        pane.setCenter(button);
        pane.getStyleClass().add("paneButton");
        return pane;
    }

}
