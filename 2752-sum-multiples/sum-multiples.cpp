class Solution {
public:
    int sumOfMultiples(int n) {
        int total_sum=0;
        for(int i=0;i<=n;i++){
            if(i%3==0 || i%5==0 || i%7==0){
                total_sum+=i;
            }
        }
        return total_sum;
    }
};