package my;

import java.util.ArrayList;
import java.util.List;

// This class provides functionality to find and display prime numbers up to a given limit.
public class Primes {
    public static void main(String[] args) {
        int N = 50; // Example value for N, the upper limit for finding prime numbers.
        List<Integer> primes = findPrimesUpTo(N); // Call the method to find all primes up to N.
        System.out.println("Prime numbers up to " + N + ": " + primes); // Print the list of primes.
    }

    // Method to find all prime numbers up to a given number N.
    public static List<Integer> findPrimesUpTo(int N) {
        List<Integer> primes = new ArrayList<>(); // Initialize a list to store prime numbers.
        for (int i = 2; i <= N; i++) { // Loop through all numbers from 2 to N.
            if (isPrime(i)) { // Check if the current number is prime.
                primes.add(i); // If prime, add it to the list.
            }
        }
        return primes; // Return the list of prime numbers.
    }

    // Helper method to check if a given number is prime.
    private static boolean isPrime(int num) {
        if (num < 2) { // Numbers less than 2 are not prime.
            return false;
        }
        // Check divisors from 2 up to the square root of the number.
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) { // If divisible by any number, it's not prime.
                return false;
            }
        }
        return true; // If no divisors are found, the number is prime.
    }
}