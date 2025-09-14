class Solution {
    public int checkRecord(int n) {
        long mod = 1000000007;
        long[][][] dp = new long[n + 1][2][3];
        dp[0][0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int a = 0; a <= 1; a++) {
                for (int l = 0; l <= 2; l++) {
                    long val = dp[i - 1][a][l];
                    if (val == 0) continue;
                    dp[i][a][0] = (dp[i][a][0] + val) % mod;
                    if (a < 1) dp[i][a + 1][0] = (dp[i][a + 1][0] + val) % mod;
                    if (l < 2) dp[i][a][l + 1] = (dp[i][a][l + 1] + val) % mod;
                }
            }
        }
        long res = 0;
        for (int a = 0; a <= 1; a++)
            for (int l = 0; l <= 2; l++)
                res = (res + dp[n][a][l]) % mod;
        return (int) res;
    }
}
