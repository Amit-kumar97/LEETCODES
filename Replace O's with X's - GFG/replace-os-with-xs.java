//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    
    static char[][] fill(int n, int m, char a[][])
    {
        // code here
        int[][] vis = new int[n][m];
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};
        
        // for first row and last row
        for(int i=0; i<m; i++){
            if(a[0][i]=='O' && vis[0][i]==0){
                dfs(0, i, vis, a, delrow, delcol);
            }
            if(a[n-1][i]=='O' && vis[n-1][i]==0){
                dfs(n-1, i, vis, a, delrow, delcol);
            }
        }
        for(int i=0; i<n; i++){
            if(a[i][0]=='O' && vis[i][0]==0){
                dfs(i, 0, vis, a, delrow, delcol);
            }
            if(a[i][m-1]=='O' && vis[i][m-1]==0){
                dfs(i, m-1, vis, a, delrow, delcol);
            }
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(a[i][j]=='O' && vis[i][j]==0){
                    a[i][j] = 'X';
                }
            }
        }
        return a;
    }
    
    static void dfs(int row, int col, int[][] vis, char[][] a, int[] delrow, int[] delcol){
        vis[row][col] = 1;
        int n = a.length;
        int m = a[0].length;
        
        for(int i=0; i<4; i++){
            int nrow = row+delrow[i];
            int ncol = col+delcol[i];
            
            if(nrow>=0 && nrow<n &&ncol>=0 && ncol<m && vis[nrow][ncol]==0 && a[nrow][ncol]=='O'){
                dfs(nrow, ncol, vis, a, delrow, delcol);
            }
        }
    }
    
}