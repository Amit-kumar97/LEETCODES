class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        int n1 = text1.length();
        int n2 = text2.length();
    
        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();
        
        int[][] dp = new int[n1+1][n2+1];
        
        for(int  i=1; i<n1+1; i++)
        {
            for(int j=1; j<n2+1; j++)
            {
                if(s1[i-1]==s2[j-1])
                    dp[i][j] = dp[i-1][j-1]+1;
                else
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        return dp[n1][n2];
    }
}