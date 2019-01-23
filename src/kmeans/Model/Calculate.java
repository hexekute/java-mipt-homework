package kmeans.Model;

import kmeans.View.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Calculate {
    public static void setRandomCenters(Integer N){
        List<List<Double>> coordinates = new ArrayList<>();
        List<Double> xCoord = new ArrayList<>();
        List<Double> yCoord = new ArrayList<>();
        double maxX = View.points.get(0).get(0);
        double maxY = View.points.get(1).get(0);
        double minX = View.points.get(0).get(0);
        double minY = View.points.get(1).get(0);
        for(int i = 1; i < View.points.get(0).size(); i++){
            maxX = Math.max(maxX, View.points.get(0).get(i));
            maxY = Math.max(maxY, View.points.get(1).get(i));
            minX = Math.min(minX, View.points.get(0).get(i));
            minY = Math.min(minY, View.points.get(1).get(i));
        }
        for(int i = 0; i < N; i++){
            xCoord.add(Math.random() * (maxX - minX) + minX);
            yCoord.add(Math.random() * (maxY - minY) + minY);
        }
        coordinates.add(xCoord);
        coordinates.add(yCoord);
        View.dots.add(coordinates);
    }
    public static void setRandomPoints(Integer N){
        List<List<Double>> coordinates = new ArrayList<>();
        List<Double> xCoord = new ArrayList<>();
        List<Double> yCoord = new ArrayList<>();

        for(int i = 0; i < N; i++){
            xCoord.add(Math.random());
            yCoord.add(Math.random());
        }
        coordinates.add(xCoord);
        coordinates.add(yCoord);
        View.points = coordinates;
    }
    public static void kMeans(){

        List<Integer> clasters = defineClasters(View.points, View.dots.get(View.dots.size() - 1));
        List<List<Double>> newDots = new ArrayList<>();

        List<Double> xCoords = new ArrayList<>();
        List<Double> yCoords = new ArrayList<>();
        //System.out.println(clasters);
        for(int i = 0; i < View.dots.get(View.dots.size() - 1).get(0).size(); i++){
            List<Double> dot = massCenter(View.points, clasters, i);
            xCoords.add(dot.get(0));
            yCoords.add(dot.get(1));
        }
        newDots.add(xCoords);
        newDots.add(yCoords);
        View.dots.add(newDots);

    }
    private static List<Integer> defineClasters(List<List<Double>> points, List<List<Double>> dots){
        List<Integer> clasters = new ArrayList<>();
        for(int i = 0; i < points.get(0).size(); i++){
            List<Double> lengthList = new ArrayList<>();
            for(int j = 0; j < dots.get(0).size(); j++){
                lengthList.add(length(points.get(0).get(i), points.get(1).get(i), dots.get(0).get(j), dots.get(1).get(j)));
            }
            //System.out.println(lengthList);
            clasters.add(0);
            Double minLength = lengthList.get(0);
            for(int j = 1; j < dots.get(0).size(); j++){
                if(lengthList.get(j) < minLength){
                    minLength = lengthList.get(j);
                    clasters.set(i, j);
                }
            }
        }
        //System.out.println(clasters);
        return clasters;
    }
    private static List<Double> massCenter(List<List<Double>> points, List<Integer> clasters, Integer claster){
        List<Double> massCenter = new ArrayList<>();
        Integer members = 0;
        Double xCoord = 0.0;
        Double yCoord = 0.0;
        for(int i = 0; i < points.get(0).size(); i++){
            if(Objects.equals(clasters.get(i), claster)){
                members++;
                xCoord += points.get(0).get(i);
                yCoord += points.get(1).get(i);
            }
        }
        if (members != 0){
            xCoord = xCoord / members;
            yCoord = yCoord / members;
        }


        massCenter.add(xCoord);
        massCenter.add(yCoord);

        return massCenter;
    }
    private static double length(double x1, double y1, double x2, double y2){
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }

}
