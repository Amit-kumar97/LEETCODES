class Solution {
    public int trap(int[] h) {
        int n = h.length;
        if(n==0)
            return 0;
        int water = 0;
        
        int[] left = new int[n];
        left[0] = h[0];
        int[] right = new int[n];
        right[n-1] = h[n-1];
        
        for(int i=1; i<n; i++)
        {
            left[i] = Math.max(h[i], left[i-1]);
        }
        for(int i=n-2; i>=0; i--)
        {
            right[i] = Math.max(h[i], right[i+1]);
        }
        for(int i=0; i<n; i++)
        {
            int waterStored = Math.min(left[i], right[i])-h[i];
            water += waterStored;
        }
        return water;
    }
}