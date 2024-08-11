class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int n=colors.length;
        int ans=0;
        for(int i=0;i<colors.length-2;i++){
            if(colors[i]==colors[i+2] &&colors[i]!=colors[i+1]){
                ans++;
            }
        }
        if(colors[0]==colors[n-2] && colors[0]!=colors[n-1]){
            ans++;
        }
        if(colors[0]!=colors[1] && colors[1]==colors[n-1]){
            ans++;
        }
        return ans;
    }
}