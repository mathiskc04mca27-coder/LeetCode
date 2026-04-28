class Solution {
    public int buttonWithLongestTime(int[][] events) {
        // Initialize with the first event
        int longestIndex = events[0][0];
        int maxDuration = events[0][1];
        
        for (int i = 1; i < events.length; i++) {
            int currentIndex = events[i][0];
            int duration = events[i][1] - events[i - 1][1];
            
            // Update if we find a longer duration, 
            // or an equal duration with a smaller index
            if (duration > maxDuration) {
                maxDuration = duration;
                longestIndex = currentIndex;
            } else if (duration == maxDuration) {
                if (currentIndex < longestIndex) {
                    longestIndex = currentIndex;
                }
            }
        }
        
        return longestIndex;
    }
}
