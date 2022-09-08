class Solution {
    public int maxProfit(int[] prices) {
    
        int n = prices.length;
        if(n==0)
            return 0;
        
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for(int i=0; i<n; i++)
        {
            if(prices[i] < min)
                min = prices[i];
            
            maxProfit = Math.max(prices[i]-min, maxProfit);
        }
        return maxProfit;
    }
}