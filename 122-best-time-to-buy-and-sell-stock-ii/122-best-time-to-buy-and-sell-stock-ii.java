class Solution {
    public int maxProfit(int[] p) {
        
        int n = p.length;
        if(n==0)
            return 0;
        
        int profit = 0;
        
        for(int i=1; i<n; i++)
        {
            if(p[i]>p[i-1])
                profit += p[i]-p[i-1];
        }
        return profit;
    }
}