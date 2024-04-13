public class Solution {
    public static int countDivisibleBy5(int n) {
        int count = 0;
        while (n % 5 == 0) {
            count++;
            n /= 5;
        }
        return count;
    }

    public static int trailingZeroes(int n) {
        int countTrailingZeros = 0;
        int quotient = n / 5;
        n = 5*quotient;
        while(n >= 5){
            countTrailingZeros+=countDivisibleBy5(n);
            n= n-5;
        }
        return countTrailingZeros;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(130));
        System.out.println(countDivisibleBy5(130));
    }
}
