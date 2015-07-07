package PrimeGenerator;

import java.io.*;

public class Main {
    private static boolean[] primes = new boolean[1000000001];
    public static void main (String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long startTime = System.nanoTime();
        generateCandidates();
        generatePrimes(100000000); 
        System.out.println(System.nanoTime() - startTime);
                int testCases = Integer.parseInt(reader.readLine());

        int beginning, end;
               for (int index = 0; index < testCases; index++) {
                 String[] tempString = reader.readLine().split(" ");

                 beginning = Integer.parseInt(tempString[0]);
                 end = Integer.parseInt(tempString[1]);
        // List primes
        }
    }

    public static void generatePrimes(int maxPrime) {
        for (int testCase = 3; testCase*testCase <= maxPrime; testCase += 2) {
            if (primes[testCase]) {
                hasBeenFound(testCase);
            }
        }
    }


    public static void hasBeenFound(int testCase) {
        for (int index = 1; index*testCase < primes.length; index++ ) {
            primes[index*testCase] = false; 
        } 
    }

    private static void generateCandidates() {
        primes[2] = true;
        for (int index = 3; index < primes.length; index += 2) {
            primes[index] = true;
        }
    }


}

