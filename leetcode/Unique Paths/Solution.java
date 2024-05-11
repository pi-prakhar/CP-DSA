class Solution {
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return solve(m, n, dp);
    }
    
    private static int solve(int m, int n, int[][] dp) {
        if (dp[m - 1][n - 1] != 0) return dp[m - 1][n - 1];
        if (m == 1 || n == 1) return 1;
        dp[m - 1][n - 1] = solve(m - 1, n, dp) + solve(m, n - 1, dp);
        return dp[m - 1][n - 1];
    }
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 2));
    }
}