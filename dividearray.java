import java.util.*;

class Solution {
    
    static class Line {
        long m, b;
        Line(long m, long b) {
            this.m = m;
            this.b = b;
        }
        long eval(long x) {
            return m * x + b;
        }
    }

    public long minimumCost(int[] nums, int[] cost, int k) {
        int n = nums.length;
        long[] P = new long[n]; 
        long[] C = new long[n]; 

        P[0] = nums[0];
        C[0] = cost[0];
        for (int i = 1; i < n; i++) {
            P[i] = P[i - 1] + nums[i];
            C[i] = C[i - 1] + cost[i];
        }
s
        long[] dp = new long[n];
        
        
        for (int i = 0; i < n; i++) {
            dp[i] = (P[i] + (long) k) * C[i];
        }

        long minTotalCost = dp[n - 1];

        
        for (int j = 2; j <= n; j++) {
            long[] nextDp = new long[n];
            
            Deque<Line> dq = new ArrayDeque<>();

            for (int i = 0; i < n; i++) {
                
                int p = i - 1;
                if (p >= j - 2) {
                    
                    Line newLine = new Line(-C[p], dp[p]);

                    while (dq.size() >= 2) {
                        Line l2 = dq.pollLast();
                        Line l1 = dq.peekLast();
                        
                        if ((double)(l2.b - l1.b) * (l2.m - l3_m(newLine)) >= (double)(newLine.b - l2.b) * (l1.m - l2.m)) {
                            
                        } else {
                            dq.addLast(l2);
                            break;
                        }
                    }
                    dq.addLast(newLine);
                }

                
                if (i >= j - 1 && !dq.isEmpty()) {
                    long x = P[i] + (long) j * k;
                    
                    while (dq.size() >= 2) {
                        Line l1 = dq.pollFirst();
                        Line l2 = dq.peekFirst();
                        if (l1.eval(x) >= l2.eval(x)) {
                            
                        } else {
                            dq.addFirst(l1);
                            break;
                        }
                    }
                    
                    nextDp[i] = x * C[i] + dq.peekFirst().eval(x);
                } else {
                    nextDp[i] = Long.MAX_VALUE / 2;
                }
            }
            
            
            if (nextDp[n - 1] >= Long.MAX_VALUE / 2) break;
            minTotalCost = Math.min(minTotalCost, nextDp[n - 1]);
            dp = nextDp;
        }

        return minTotalCost;
    }

    
    private long l3_m(Line l) { return l.m; }
}
