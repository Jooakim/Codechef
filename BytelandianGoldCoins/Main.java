package BytelandianGoldCoins;

import java.io.*;
import java.util.HashMap;

public class Main {
    static double maxValue;
    static HashMap<Long, Long> preDefValues = new HashMap<Long, Long>();
    public static void main (String[] args) throws IOException {
        String currentLine = null;
        int startValue;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        while ((currentLine = reader.readLine()) != null) { 
            startValue = Integer.parseInt(currentLine);
            maxValue = 0;
            maximize(startValue);
            System.out.println(maximize(startValue));
        }
    }

    private static long maximize(long startValue) {

        if (startValue < 12) {
            return startValue;
        } else if(preDefValues.containsKey(startValue)) {
            return preDefValues.get(startValue);
        } else {
            long maxValue = maximize(startValue/2) + maximize(startValue/3) + maximize(startValue/4);
            preDefValues.put(startValue, maxValue);
            return maxValue;
        }

    }

}
