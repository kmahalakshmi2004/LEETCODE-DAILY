class Solution {
public:
    int minPairSum(vector<int>& nums) {
        int left=0;
        int right=nums.size()-1;
        int sum=0;
        std::sort(nums.begin(),nums.end());
        while(left<right){
            sum=std::max(sum,nums[left]+nums[right]);
            left++;
            right--;
        }
        return sum;
    }
};