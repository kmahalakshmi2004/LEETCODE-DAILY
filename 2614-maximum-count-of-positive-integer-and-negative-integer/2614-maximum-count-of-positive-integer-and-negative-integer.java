class Solution {
    public int maximumCount(int[] nums) {
        // Find the position of the first non-negative number
        int firstNonNegative = findFirstNonNegative(nums);
        
        // Find the position of the first positive number
        int firstPositive = findFirstPositive(nums);
        
        // Count of negative numbers
        int negCount = firstNonNegative;
        
        // Count of positive numbers
        int posCount = nums.length - firstPositive;
        
        return Math.max(negCount, posCount);
    }
    
    private int findFirstNonNegative(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        // If all elements are negative
        if (nums[right] < 0) {
            return nums.length;
        }
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] < 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
    
    private int findFirstPositive(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        // If all elements are non-positive
        if (nums[right] <= 0) {
            return nums.length;
        }
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] <= 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
}