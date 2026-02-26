package com.java8.features.practice;

/**
 * Print prime numbers from 1 to 100
 */
public class PrimeNumbers {

    public static void main(String[] args) {


        for(int i=2;i<=100;i++) {

            if(isPrime(i)) {
                System.out.println(i);
            }
        }

    }

    private static boolean isPrime(int num) {
        /**
         * “Factors come in pairs.
         * If num = a × b, one of them must be ≤ √num,
         * so checking up to √num is sufficient.”
         */
        for(int i=2;i*i<=num;i++) {
            if(num%i == 0) {
                return false;
            }
        }
        return true;
    }
}
