package org.nacys_projects.number_theory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeGenerator {
    public List<Integer> primesLessThanOrEqualTo(int upperBound) {
        if (upperBound <= 1) return new ArrayList<>();

        boolean[] isPrime = new boolean[upperBound + 1];
        markPrimesAsTrue(isPrime);
        return filterForPrimes(isPrime);
    }

    private void markPrimesAsTrue(boolean[] isPrime) {
        // Sieve of Eratosthenes; mark all true, then mark non-primes as false.
        Arrays.fill(isPrime, true);
        isPrime[1] = isPrime[0] = false;
        int sieveUpperBound = (int)Math.sqrt((double)isPrime.length + 1);
        for (int number = 2; number <= sieveUpperBound; number++) {
            if (isPrime[number]) {
                crossOffMultiplesOf(number, isPrime);
            }
        }
    }

    private List<Integer> filterForPrimes(boolean[] isPrime) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        return primes;
    }

    private void crossOffMultiplesOf(int number, boolean[] arr) {
        for (int i = 2 * number; i < arr.length; i += number) {
            arr[i] = false;
        }
    }
}
