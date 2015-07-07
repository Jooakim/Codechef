package PrimeGenerator;

public class test {
    public static void main(String[] args) { 
        int N = 1000000000;
        long startTime = System.nanoTime();
        // initially assume all integers are prime
        boolean[] isPrime = new boolean[N + 1];
        isPrime[2] = true;
        for (int i = 3; i <= N; i += 2) {
            isPrime[i] = true;
        }
        //
        // mark non-primes <= N using Sieve of Eratosthenes
        for (int i = 3; i*i <= N; i += 2) {
            //
            // if i is prime, then mark multiples of i as nonprime
            // suffices to consider mutiples i, i+1, ..., N/i
            if (isPrime[i]) {
                for (int j = i; i*j <= N; j++) {
                    isPrime[i*j] = false;
                }
            }
        }
        System.out.println(System.nanoTime() - startTime);
        //
        // count primes
        int primes = 0;
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) primes++;
        }

        System.out.println("The number of primes <= " + N + " is " + primes);
    }
}
