package piDefinition.Model;

import java.util.ArrayList;
import java.util.List;

public class Calculate {
    public static List<List<Double>> getRandomPoints(Integer N){
        List<List<Double>> coordinates = new ArrayList<>();
        List<Double> xCoord = new ArrayList<>();
        List<Double> yCoord = new ArrayList<>();

        for(int i = 0; i < N; i++){
            xCoord.add(Math.random());
            yCoord.add(Math.random());
        }
        coordinates.add(xCoord);
        coordinates.add(yCoord);
        return coordinates;
    }
    public static Double countPI(List<List<Double>> coordinates){
        Double numberInPoints = 0.0;
        for(int i = 0; i < coordinates.get(0).size(); i++){
            if(Math.pow(coordinates.get(0).get(i), 2) + Math.pow(coordinates.get(1).get(i), 2) < 1)
                numberInPoints++;
        }
        //System.out.println(numberInPoints);
        return (numberInPoints / coordinates.get(0).size() * 4);
    }
}
