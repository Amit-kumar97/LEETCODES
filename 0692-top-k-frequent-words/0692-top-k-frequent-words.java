class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        List<String> res = new ArrayList<>();
        TreeMap<String,Integer> tmap = new TreeMap<>();
        
        for(String s : words)
            tmap.put(s,tmap.getOrDefault(s,0) + 1);
        
        TreeMap<Integer,String> treemap = new TreeMap<>(Collections.reverseOrder());
        
        for(Map.Entry m : tmap.entrySet()){
            if(treemap.get(m.getValue())==null)
                treemap.put((Integer)m.getValue(),(String)m.getKey());
            else{
                String val = treemap.get(m.getValue());
                treemap.put((Integer)m.getValue(),val + " " + (String)m.getKey());
            }
        }
        
        for(Map.Entry m : treemap.entrySet()){
            if(k>0){
                String str = (String)m.getValue();
                String[] arr = str.split(" ");
                for(int i = 0; i<arr.length; i++){
                    if(k>0){
                         res.add(arr[i]);
                         k--;
                    }
                }
            }
        }
        return res;
    }
}