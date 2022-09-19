class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        
        Map<String, List<String>> map = new HashMap();
        for(String path:paths)
        {
            String[] token = path.split(" ");
            String dir = token[0];
            for(int i=1; i<token.length; i++)
            {
                int index = token[i].indexOf('(');
                String fileName = token[i].substring(0, index);
                String content = token[i].substring(index+1,token[i].length()-1);
                List<String> filenames = map.getOrDefault(content, new ArrayList<>());
                filenames.add(dir+"/"+fileName);
                map.put(content, filenames);
            }
        }
        List<List<String>> list = new ArrayList();
        for(List<String> val : map.values())
        {
            if(val.size()>1)
                list.add(val);
        }
        return list;
    }
}