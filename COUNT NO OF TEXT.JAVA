class Solution {
    private static final int MOD = 1_000_000_007;

    public int countTexts(String pressedKeys) {
        int n = pressedKeys.length();
        long[] dp3 = new long[n + 1]; // For keys with 3 letters
        long[] dp4 = new long[n + 1]; // For keys with 4 letters

        
        dp3[0] = 1;
        dp4[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 3 && i - j >= 0; j++) {
                dp3[i] = (dp3[i] + dp3[i - j]) % MOD;
            }
            for (int j = 1; j <= 4 && i - j >= 0; j++) {
                dp4[i] = (dp4[i] + dp4[i - j]) % MOD;
            }
        }

        long totalWays = 1;
        int i = 0;
        while (i < n) {
            char currentKey = pressedKeys.charAt(i);
            int count = 0;
           
            while (i < n && pressedKeys.charAt(i) == currentKey) {
                count++;
                i++;
            }
            

            if (currentKey == '7' || currentKey == '9') {
                totalWays = (totalWays * dp4[count]) % MOD;
            } else {
                totalWays = (totalWays * dp3[count]) % MOD;
            }
        }

        return (int) totalWays;
    }
}
