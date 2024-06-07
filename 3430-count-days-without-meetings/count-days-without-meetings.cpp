class Solution {
public:
    int countDays(int days, vector<vector<int>>& meetings) {
       int ans=0;
       int prev=0;

       sort(meetings.begin(),meetings.end());
       for(const auto&meeting:meetings) {
        int x=meeting[0];
        int y=meeting[1];
        int mini=min(x,days);
        ans += max(0, mini - prev - 1);
        prev = max(prev, y);
       }
       return ans + max(0, days - prev);
    }
};