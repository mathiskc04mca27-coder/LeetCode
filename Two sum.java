import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * Finds indices of two numbers that add up to the target.
     * Time Complexity: O(n) - We traverse the list only once.
     * Space Complexity: O(n) - We store up to n elements in the hash map.
     */
    public int[] twoSum(int[] nums, int target) {
        // Map to store: Key = the number, Value = its index in the array
        Map<Integer, Integer> numToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            
            if (numToIndex.containsKey(complement)) {
                return new int[] { numToIndex.get(complement), i };
            }

            
            numToIndex.put(nums[i], i);
        }

        
        throw new IllegalArgumentException("No two sum solution exists");
    }

    
    public static void main(String[] args) {
        Solution sol = new Solution();

        
        int[] result1 = sol.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println("Example 1: [" + result1[0] + ", " + result1[1] + "]"); // Output: [0, 1]

       
        int[] result2 = sol.twoSum(new int[]{3, 2, 4}, 6);
        System.out.println("Example 2: [" + result2[0] + ", " + result2[1] + "]"); // Output: [1, 2]

        
        int[] result3 = sol.twoSum(new int[]{3, 3}, 6);
        System.out.println("Example 3: [" + result3[0] + ", " + result3[1] + "]"); // Output: [0, 1]
    }
}
