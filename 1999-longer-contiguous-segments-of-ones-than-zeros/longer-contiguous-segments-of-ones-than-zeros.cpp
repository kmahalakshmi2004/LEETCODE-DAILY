class Solution {
public:
    bool checkZeroOnes(string s) {
        int cnt0=0;
        int cnt1=0; 
        int max0=0; 
        int max1=0;
        for(int i=0;i<s.size();i++){
            if(s[i]=='1'){
                cnt1++;
                cnt0=0;
                max1=max(cnt1,max1);
            }
            else{
                cnt0++;
                cnt1=0;
                max0=max(cnt0,max0);
            }
        }
        return max1>max0;
    }
};
