class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        
        // dp[i][j] represents if s1(0 to i) and s2(0 to j) can form s3(0 to i+j)
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        
        // Initialize first row
        for (int j = 1; j <= s2.length(); j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }
        
        // Initialize first column
        for (int i = 1; i <= s1.length(); i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        
        // Populate the DP matrix
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                boolean matchS1 = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                boolean matchS2 = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                dp[i][j] = matchS1 || matchS2;
            }
        }
        
        return dp[s1.length()][s2.length()];
    }
}
