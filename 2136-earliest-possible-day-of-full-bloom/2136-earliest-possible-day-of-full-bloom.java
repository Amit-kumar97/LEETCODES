class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        
        // sort by growtime
        int n  = plantTime.length;
        int arr[] = new int [100001];
        
        for(int i=0; i<n; i++){
            arr[growTime[i]] += plantTime[i];
        }
        
        int curr =0, ans = 0;
        for(int i=arr.length-1; i>=1; i--){ 
            if (arr[i]==0) 
                continue;
            curr += arr[i];
            ans = Math.max(ans, curr+i);
        } 
        return ans;
    }
}