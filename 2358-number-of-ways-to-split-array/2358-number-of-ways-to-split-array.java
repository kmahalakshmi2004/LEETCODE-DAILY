class Solution {
    public int waysToSplitArray(int[] nums) {
        long totalsum=0;
        for(int num:nums){
            totalsum+=num;
        }
        long prefixsum=0;
        int count=0;
        for(int i=0;i<nums.length-1;i++){
            prefixsum+=nums[i];
            if(prefixsum>=totalsum-prefixsum){
                count++;
            }
        }
        return count;
    }
}