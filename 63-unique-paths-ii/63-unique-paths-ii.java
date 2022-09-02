class Solution {
    public int uniquePathsWithObstacles(int[][] ob) {
        
        if(ob[0][0]==1)
            return 0;
        
        int m = ob.length;
        int n = ob[0].length;
        
//         int[][] dp = new int[m][n];
//         dp[0][0] = 1;
//         for(int i=1; i<m; i++)
//         {
//             if (ob[i][0] == 0) 
//             {
//                 dp[i][0] = dp[i-1][0];
//             } 
//             else {
//                 dp[i][0] = 0;
//         }
        
//         for(int i=1; i<n; i++)
//         {
//             if (ob[0][i] == 0) 
//             {
//                 dp[0][i] = dp[0][i-1];
//             } 
//             else {
//                 dp[0][i] = 0;
//         }
            
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                // first row and first column
                if(i==0 || j==0)
                {
                    // its prev cell was ob or if current cell is ob
                    if(ob[i][j] == 1 || (i!=0 && ob[i-1][0] == 0) || (j !=0 && ob[i][j-1]==0))
                        ob[i][j] = 0;
                    else
                        ob[i][j] = 1;
                }
                // all the other cells
                else
                {
                    if(ob[i][j] == 1)
                        ob[i][j] = 0;
                    else
                        ob[i][j] = ob[i-1][j] + ob[i][j-1];
                }     
            }
        }
        return ob[m-1][n-1];

    }
}