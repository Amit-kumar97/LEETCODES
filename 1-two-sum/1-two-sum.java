class Solution {
    
    public int[] twoSum(int[] nums, int target) {
        int[] ar = new int[2];
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
           
            if (!map.containsKey(target-nums[i])) {
                map.put(nums[i], i);
            }
            else {
                ar[1] = i;
                ar[0] = map.get(target-nums[i]);
                return ar;
            }
        }
        return ar;
    }
}
