//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int shortestPath(int[][] grid, int[] source, int[] destination) {

        // Your code here
        int n = grid.length;
        int m = grid[0].length;
        ArrayList<int[]> list = new ArrayList<>();
        
        int step = 0;
        boolean[][] visited = new boolean[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j]==0) {
                    visited[i][j] = true;
                }
            }
        }
        
        list.add(source);
        while(list.size()>0){
            int size = list.size();
            for(int i=0; i<size; i++){
                int[] curr = list.get(0);
                int curr_row = curr[0];
                int curr_col = curr[1];
                list.remove(0);
                if(curr_row==destination[0] && curr_col==destination[1]) {
                    return step;
                }
                if(curr_row-1>=0 && !visited[curr_row-1][curr_col]) {
                    list.add(new int[] {curr_row-1,curr_col});
                    visited[curr_row-1][curr_col] = true;
                }
                if(curr_row+1<n && !visited[curr_row+1][curr_col]) {
                    list.add(new int[] {curr_row+1,curr_col});
                    visited[curr_row+1][curr_col] = true;
                }
                if(curr_col-1>=0 && !visited[curr_row][curr_col-1]) {
                    list.add(new int[] {curr_row,curr_col-1});
                    visited[curr_row][curr_col-1] = true;
                }
                if(curr_col+1<m && !visited[curr_row][curr_col+1]) {
                    list.add(new int[] {curr_row,curr_col+1});
                    visited[curr_row][curr_col+1] = true;
                }
            }
            step++;
        }
        return -1;
        
    }
}
