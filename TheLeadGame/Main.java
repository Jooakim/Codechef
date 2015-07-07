package TheLeadGame;

import java.io.*;

public class Main {
    private static int end = 0;
    public static void main (String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            end = Integer.parseInt(reader.readLine());
        } catch (IOException e) {

        }

        int player1Lead = 0;
        int player2Lead = 0;
        int lead = 0;
        String currentPlay = new String();
        int[] scoreSum = new int[2]; 
        String[] playerScore; 

        for (int index = 0; index < end; index++) {
            try {
                currentPlay = reader.readLine(); 
            } catch (IOException e) {
            }
            playerScore = currentPlay.split(" "); 
            scoreSum[0] += Integer.parseInt(playerScore[0]);
            scoreSum[1] += Integer.parseInt(playerScore[1]);
            
            lead = scoreSum[0] - scoreSum[1];

            if (lead < 0  && player2Lead < Math.abs(lead)) {
                player2Lead = Math.abs(lead);
            } else if (player1Lead < Math.abs(lead)) {
                player1Lead = Math.abs(lead);
            }
        }
        if (player1Lead > player2Lead) 
            System.out.println( "1 " + player1Lead);
        else
            System.out.println( "2 " + player2Lead);
    }

}
