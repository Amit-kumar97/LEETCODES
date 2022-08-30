class Solution {
    public int change(int a, int[] c) {
        
        // todays problem is to find the maximum
        // the number  == all the possible 
        // minimum and maximum = optimization
        // optimization = dp
        
        int[] dp = new int[a+1];
        dp[0] = 1;
        
        for(int coin:c)
        {
            for(int j=coin; j < a+1; j++)
            {
                dp[j] += dp[j-coin]; 
            }
        }
        
        return dp[a];
    }
}