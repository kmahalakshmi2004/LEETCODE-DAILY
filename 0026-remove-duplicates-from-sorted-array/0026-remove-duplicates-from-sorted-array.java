class Solution {
    public int removeDuplicates(int[] nums) {

        if (nums.length == 0) return 0;
        int uniqueIndex = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[uniqueIndex] != nums[i]) {
                nums[++uniqueIndex] = nums[i];
            }
        }

        return uniqueIndex + 1;
        
    }
}