package calculator.Control;

import calculator.Model.Calculate;
import javafx.scene.control.TextField;

public class Controller {

    public static void actionNumButton(TextField stringField,TextField answerField, Integer numb) {
        stringField.setText(stringField.getText() + numb.toString());
        answerField.setText(String.format("%.20g", Calculate.count(stringField.getText())));

    }
    public static void actionDeleteButton(TextField stringField, TextField answerField, String operation) {
        switch (operation) {
            case "C":
                for(int i = stringField.getText().length()-1; i>=0;i--){
                    char ch = stringField.getText().charAt(i);
                    if(ch == '*' || ch == '/' || ch =='+' || ch == '-'){
                        stringField.setText(stringField.getText().substring(0, i));
                        answerField.setText(String.valueOf(Calculate.count(stringField.getText())));
                        return;
                    }
                }
                stringField.clear();
                answerField.setText(String.valueOf(Calculate.count(stringField.getText())));
                break;
            case "AC":
                stringField.clear();
                answerField.setText(String.valueOf(Calculate.count(stringField.getText())));
                break;
            default:
                if(stringField.getText().length()!=0){
                    stringField.setText(stringField.getText().substring(0, stringField.getText().length()-1));
                    if(stringField.getText().length()!=0){
                        char ch =stringField.getText().charAt(stringField.getText().length()-1);
                        if(ch == '+' || ch == '-' || ch =='*' || ch == '/')
                            answerField.setText(String.valueOf(Calculate.count(stringField.getText().substring(0, stringField.getText().length()-2))));
                        else
                            answerField.setText(String.valueOf(Calculate.count(stringField.getText().substring(0, stringField.getText().length()-1))));
                    }else{
                        answerField.setText("0.0");
                    }

                }
        }
    }
    public static void actionCommaButton(TextField stringField) {
        for(int i = stringField.getText().length()-1; i>=0;i--){
            char ch = stringField.getText().charAt(i);
            if(ch=='.')
                break;
            if(ch == '*' || ch == '/' || ch =='+' || ch == '-'){
                stringField.setText(stringField.getText() + '.');
                break;
            }
            if(i == 0){
                stringField.setText(stringField.getText() + '.');
            }
        }
    }
    public static void actionOperateButton(TextField stringField, String operation) {
        if(stringField.getText().length() != 0){
            char lastch = stringField.getText().charAt(stringField.getText().length()-1);
            if(lastch!='-' && lastch != '+' && lastch!='*' && lastch != '/')
                stringField.setText(stringField.getText() + operation);
        }

    }
}
