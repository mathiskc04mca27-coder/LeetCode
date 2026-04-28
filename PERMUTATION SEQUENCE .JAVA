import java.util.*;

class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n + 1];
        StringBuilder sb = new StringBuilder();

        // 1. Create a list of numbers [1, 2, ..., n] 
        // 2. Precompute factorials for quick lookup
        int sum = 1;
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
            factorial[i] = sum;
            numbers.add(i);
        }

        // Adjust k to be 0-indexed for easier math
        k--;

        for (int i = 1; i <= n; i++) {
            // Find which bucket (index) k falls into
            int index = k / factorial[n - i];
            sb.append(numbers.get(index));
            
            // Remove the used digit so it's not picked again
            numbers.remove(index);
            
            // Update k for the remaining digits
            k %= factorial[n - i];
        }

        return sb.toString();
    }
}
