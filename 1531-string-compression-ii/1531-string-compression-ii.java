class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        int n = s.length();
        int[][] dp = new int[110][110];
        for(int i=0; i<=n; i++){
            for(int j=0; j<=n; j++)
                dp[i][j] = 9999;
        }
        dp[0][0] = 0;
        for(int i=1; i<=n; i++) {
            for(int j=0; j<=k; j++){
                int cur = 0;
                int del = 0;
                for(int l=i; l>=1; l--) {
                    if(s.charAt(l-1)==s.charAt(i-1))
                        cur++;
                    else
                        del++;
                    if(j-del >= 0)
                        dp[i][j] = Math.min(dp[i][j],dp[l-1][j-del]+1+(cur>=100 ? 3:cur>=10 ? 2:cur >= 10?2: cur >=2? 1:0));
                }
                if(j>0)
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]);
            }
        }
        return dp[n][k];
    }
}