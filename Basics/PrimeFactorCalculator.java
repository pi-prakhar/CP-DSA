package Basics;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorCalculator {
        public static List<Long> primeFactors(long n) {
        List<Long> factors = new ArrayList<>();
        while (n % 2 == 0) {
            factors.add(2L);
            n /= 2;
        }
        for (long i = 3; i * i <= n; i += 2) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 2) {
            factors.add(n);
        }
        return factors;
    }

    public static void main(String[] args) {
        long number = 1234567890;
        List<Long> primeFactorsList = primeFactors(number);
        System.out.println("Prime factors of " + number + " are: " + primeFactorsList);
    }
}
