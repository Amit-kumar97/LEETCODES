class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        if(m==1 && n==1)
            return true;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++)
            {
                int key = i-j;
                if(map.containsKey(key)){
                    if(map.get(key)!=matrix[i][j])
                        
                        return false;
                }
                else
                    map.put(i-j,matrix[i][j]);
            }
        }
        return true;
    }
}