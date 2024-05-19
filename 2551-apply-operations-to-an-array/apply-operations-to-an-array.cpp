class Solution {
public:
    vector<int> applyOperations(vector<int>& nums) {
        int n=nums.size();
        for(int i=0;i<n-1;i++){
            if(nums[i]==nums[i+1]){
                nums[i]=nums[i]*2;
                nums[i+1]=0;
            }
        }
        int neww=0;
        for(int i=0;i<n;i++){
            if(nums[i]){
                swap(nums[i],nums[neww++]);

            }
        }
        return nums;
    }
};