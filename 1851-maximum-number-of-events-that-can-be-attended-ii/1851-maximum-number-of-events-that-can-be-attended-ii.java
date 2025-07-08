class Solution 
{
    public int maxValue(int[][] events, int k) 
    {
        // Step 1: Sort events by end day
        Arrays.sort(events, (a, b) -> Integer.compare(a[1], b[1]));
        int n = events.length;

        // Step 2: Initialize DP table
        int[][] dp = new int[n + 1][k + 1];

        // Step 3: Loop through events
        for (int i = 1; i <= n; i++) 
        {
            int start = events[i - 1][0];
            int end = events[i - 1][1];
            int value = events[i - 1][2];

            // Step 4: Find last event that ends before this one starts
            int prev = binarySearch(events, i - 1, start);

            for (int j = 1; j <= k; j++) 
            {
                // Option 1: Skip current event
                // Option 2: Take current event + best value from prev non-overlapping event
                dp[i][j] = Math.max(dp[i - 1][j], dp[prev + 1][j - 1] + value);
            }
        }

        // Step 5: Return max value with k selections
        return dp[n][k];
    }

    // Binary Search: find rightmost event with end < start
    public int binarySearch(int[][] events, int right, int targetStart) 
    {
        int left = 0;
        int res = -1;
        
        while (left <= right) 
        {
            int mid = left + (right - left) / 2;
            if (events[mid][1] < targetStart) 
            {
                res = mid;
                left = mid + 1;
            } 
            else 
            {
                right = mid - 1;
            }
        }

        return res;
    }
}