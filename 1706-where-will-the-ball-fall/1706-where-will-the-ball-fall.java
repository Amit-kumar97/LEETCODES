class Solution {
    public int[] findBall(int[][] grid) {
        int[] exitCol = new int[grid[0].length];
        
        for(int col=0; col<grid[0].length; col++) {
            exitCol[col] = dfs(grid, 0, col);
        }
        
        return exitCol;
    }
    private int dfs(int[][] grid, int R, int C) {
        
        if(R>grid.length || C<0 || C>=grid[0].length) {
            return -1;
        }
        if(R==grid.length) {
            return C;
        }
        if(grid[R][C] == 1) {
            if(C<grid[0].length-1 && grid[R][C]!=grid[R][C+1]) {
                return -1;
            }
        } 
        else {
            if(C>0 && grid[R][C-1]!=grid[R][C]) {
                return -1;
            }
        }
        C += grid[R][C];
        return dfs(grid, R+1, C); 
    }
}
