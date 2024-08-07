class Solution {
public:
    int findNonMinOrMax(vector<int>& nums) {
        int min=nums[0];
        int max=nums[0];
        int n=nums.size();
        //find the min and max value in the array
        for(int i=1;i<n;i++){
            if(nums[i]<min){
                min=nums[i];
            }
            else if(nums[i]>max){
                max=nums[i];
            }
        }
        //finding the non max and min value 
        for(int i=0;i<n;i++){
            if(nums[i]!=min && nums[i]!=max){
                return nums[i];
            }
        }
        return -1;
    }
};