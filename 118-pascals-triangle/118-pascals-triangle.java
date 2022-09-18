class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> list = new ArrayList();
        if(numRows<1)
            return list;
        
        List<Integer> first = new ArrayList();
        first.add(1);
        list.add(first);
        
        for (int i = 2; i <= numRows; i++) {
            
            ArrayList<Integer> curr = new ArrayList<Integer>();
            curr.add(1);
            
            for (int j = 0; j < first.size() - 1; j++) {
                curr.add(first.get(j) + first.get(j + 1));
            }
            curr.add(1);
            
            list.add(curr);
            first = curr;
        }
        return list;
    }
}