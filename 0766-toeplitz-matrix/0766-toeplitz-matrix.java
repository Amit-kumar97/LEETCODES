class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        if(m==1 && n==1)               // Boundary Case
            return true;
        
        for(int i=0; i<m-1; i++){
            for(int j=0; j<n-1; j++)
            {
                if(matrix[i][j] != matrix[i+1][j+1])
                    return false;
            }
        }
        return true;
    }
}