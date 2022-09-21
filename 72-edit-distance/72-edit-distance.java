class Solution {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        
        int[][] dp = new int[n1+1][n2+1];
        
        for(int  i=0; i<n1+1; i++)
        {
            for(int j=0; j<n2+1; j++)
            {
                if(i==0 && j==0)
                    dp[i][j] = 0;
                else if(i==0)
                    dp[i][j] = j;
                else if(j==0)
                    dp[i][j] = i;
                else{
                     if(w1[i-1]==w2[j-1])
                         dp[i][j] = dp[i-1][j-1];
                    else
                        dp[i][j] =Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1])+1;
                }
            }
        }
        return dp[n1][n2];
    }
}