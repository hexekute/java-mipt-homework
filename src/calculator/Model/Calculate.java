package calculator.Model;

import java.util.ArrayList;
import java.util.List;

public class Calculate {
    public static double count(String expression){
        List<Double> numbers = new ArrayList<>();
        List<String> operations = new ArrayList<>();

        if(expression.length()==0)
            return 0.0;

        parser(expression, numbers,operations);
        multiplyAndDivision(numbers,operations);
        sumAndSubtraction(numbers,operations);
        return numbers.get(0);
    }
    private static void parser(String parseString, List<Double> numbers, List<String> operations){
        int flag = 0;
        for(int i = 0; i < parseString.length();i++){
            char ch = parseString.charAt(i);
            if(ch=='*' || ch=='+' || ch=='-' || ch=='/'){
                numbers.add(Double.parseDouble(parseString.substring(flag,i)));
                flag = i+1;
                operations.add(String.valueOf(ch));
            }else{
                if(i+1 == parseString.length()){
                    numbers.add(Double.parseDouble(parseString.substring(flag,i+1)));
                    break;
                }
            }
        }
    }
    private static void multiplyAndDivision(List<Double> numbers, List<String> operations){
        for(int i = 0; i<operations.size();) {
            String operation = operations.get(i);
            switch (operation) {
                case "*":
                    numbers.set(i, numbers.get(i) * numbers.get(i + 1));
                    numbers.remove(i + 1);
                    operations.remove(i);
                    break;
                case "/":
                    numbers.set(i, numbers.get(i) / numbers.get(i + 1));
                    numbers.remove(i + 1);
                    operations.remove(i);
                    break;
                default:
                    i++;
                    break;
            }
        }
    }
    private static void sumAndSubtraction(List<Double> numbers, List<String> operations){
        for(int i = 0; i<operations.size();){
            String operation = operations.get(i);
            if (operation.equals("+")) {
                numbers.set(i, numbers.get(i) + numbers.get(i + 1));
                numbers.remove(i + 1);
                operations.remove(i);
            } else if (operation.equals("-")) {
                numbers.set(i, numbers.get(i) - numbers.get(i + 1));
                numbers.remove(i + 1);
                operations.remove(i);
            }
        }
    }
}
