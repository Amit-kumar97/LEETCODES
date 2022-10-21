class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // Boundary cases
        if(nums==null||k==0)
            return false;

        // map for storing key:integer and values:index
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
            int integer = nums[i];
            // nums[i]==nums[j] && abs(i-j)<=k
            if(map.containsKey(integer) && i-map.get(integer)<=k) 
                return true;
            map.put(integer, i);
        }
        return false;
    }
}