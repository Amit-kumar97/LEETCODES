class Solution {
    public int trap(int[] h) {
        int n = h.length;
        if(n==0)
            return 0;
        int water = 0;
        
        int left=0;
        int right=n-1;
        int lmax = 0;
        int rmax = 0;
        
        while(left<=right)
        {
            if(rmax<=lmax)
            {
                water += Math.max(0,rmax-h[right]);
                rmax = Math.max(rmax, h[right]);
                right--;
            }
            else
            {
                water += Math.max(0,lmax-h[left]);
                lmax = Math.max(lmax,h[left]);
                left++;
            }
        }
        return water;
    }
}