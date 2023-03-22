//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
        int r = grid.length;
        int c = grid[0].length;
        
        if(grid==null || r==0 || c==0)
            return 0;
            
        boolean[][] vis = new boolean[r][c];
        int count = 0;
        
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(!vis[i][j] && grid[i][j]=='1'){
                    dfs(grid, i, j, vis);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid, int r, int c, boolean[][] vis){
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || vis[r][c] || grid[r][c]=='0')
            return;
        vis[r][c] = true;
        dfs(grid, r, c-1, vis);
        dfs(grid, r-1, c, vis);
        dfs(grid, r, c+1, vis);
        dfs(grid, r+1, c, vis);
        
        dfs(grid, r-1, c+1, vis);
        dfs(grid, r-1, c-1, vis);
        dfs(grid, r+1, c-1, vis);
        dfs(grid, r+1, c+1, vis);
    }
}