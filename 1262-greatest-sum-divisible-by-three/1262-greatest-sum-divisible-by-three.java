class Solution {
    public int maxSumDivThree(int[] nums) {
        
        int n=nums.length;
        if(n==0)
            return 0;
        
        int n1=10001, n2=10001, totalSum=0;
        for (int i : nums) {
            totalSum += i;

            if (i%3 == 1) {
                n2 = Math.min(n2, n1+i);
                n1 = Math.min(n1, i);
            }
            if (i%3 == 2) {
                n1 = Math.min(n1, n2+i);
                n2 = Math.min(n2, i);
            }
        }

        if (totalSum%3 == 0)
            return totalSum;
        else if (totalSum%3 == 1)
            return totalSum-n1;
        return totalSum-n2;
    }
}