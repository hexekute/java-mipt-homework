package kmeans.Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    public static List<List<Double>> readFile(){
        List<List<Double>> coordinates = new ArrayList<>();
        List<Double> xCoord = new ArrayList<>();
        List<Double> yCoord = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("log.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] stringSplit = line.split(" ");
                xCoord.add(Double.parseDouble(stringSplit[0]));
                yCoord.add(Double.parseDouble(stringSplit[1]));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        coordinates.add(xCoord);
        coordinates.add(yCoord);

        //System.out.println(coordinates.get(0));
        //System.out.println(coordinates.get(1));

        return coordinates;
    }
}
