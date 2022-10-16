class Solution {
    public int minDifficulty(int[] jobDiff, int d) {
        int n = jobDiff.length;
        if(d>n)
            return -1;
        
        int minDiff = 0;
        if(d==n) {
            for(int i=0; i<d; i++){
                minDiff += jobDiff[i];
            }
            return minDiff;
        }

        int[][] minDifficulty = new int[d][n];
        for (int i=1; i<d; i++) {
            Arrays.fill(minDifficulty[i], Integer.MAX_VALUE);
        }
        int maxDifficulty = 0;
        for (int i=0; i<=n-d; i++) {
            maxDifficulty = Math.max(maxDifficulty, jobDiff[i]);
            minDifficulty[0][i] = maxDifficulty;
        }
        for (int i=1; i<d; i++) {
            for (int j=i; j<=n-d+i; j++) {
                int currentDayDifficulty = jobDiff[j];
                int result = Integer.MAX_VALUE;
                for (int k = j-1; k>=i-1; k--) {
                    result = Math.min(result, minDifficulty[i-1][k] + currentDayDifficulty);
                    currentDayDifficulty = Math.max(currentDayDifficulty, jobDiff[k]);
                }
                minDifficulty[i][j] = result;
            }   
        }
        return minDifficulty[d-1][n-1];
    }
}