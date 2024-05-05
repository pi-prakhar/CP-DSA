package Basics;

import java.util.HashMap;
import java.util.Map;

public class FibonacciMemoization {
    private static Map<Integer, Integer> memo = new HashMap<>();

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        // Check if the result is already memoized
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        // Calculate Fibonacci number recursively and store the result in the memoization map
        int fib = fibonacci(n - 1) + fibonacci(n - 2);
        memo.put(n, fib);
        return fib;
    }

    public static void main(String[] args) {
        int n = 10;
        int fib = fibonacci(n);
        System.out.println("Fibonacci number at position " + n + " is: " + fib);
    }
}
