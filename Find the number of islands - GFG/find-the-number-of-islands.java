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
    
    class pair{
        int first;
        int second;
        public pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public int numIslands(char[][] grid) {
        // Code here
        int row = grid.length;
        int col = grid[0].length;
        
        int[][] vis = new int[row][col];
        int count = 0; 
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(vis[i][j]==0 && grid[i][j]=='1'){
                    bfs(i, j, vis, grid);
                    count++;
                }
            }
        }
        return count;
    }
    public void bfs(int r, int c, int[][] vis, char[][] grid){
        vis[r][c]=1;
        Queue<pair> q = new LinkedList<pair>();
        q.add(new pair(r, c));
        
        int n = grid.length;
        int m = grid[0].length;
        
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            
            q.remove();
            
            for(int delrow=-1; delrow<=1; delrow++){
                for(int delcol=-1; delcol<=1; delcol++){
                    int nrow = row+delrow;
                    int ncol = col+delcol;
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]=='1' && vis[nrow][ncol]==0){
                        vis[nrow][ncol]=1;
                        q.add(new pair(nrow, ncol));
                    }
                }
            }
        }
        
    }
}