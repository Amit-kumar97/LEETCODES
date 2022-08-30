class Solution {
    public int coinChange(int[] c, int a) {
        
        // problem of optimization - it may be maximiz  ed or minimized
        if(a==0)
            return 0;
        
        int max = a+1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);    // ans req. is maximum
        dp[0] = 0;
        
        for(int i=1; i<=a; i++)
        {
            for(int j=0; j<c.length; j++)
            {
                if(c[j]<=i)
                    dp[i] = Math.min(dp[i], dp[i-c[j]]+1);
            }
        }
        
        return dp[a]>a ? -1 : dp[a];
        
    }
}