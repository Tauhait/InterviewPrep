class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> duplicates = new HashMap<>();
        
        for(String path : paths){
            StringBuilder value = new StringBuilder();
            StringBuilder key   = new StringBuilder();
            boolean isKey = false;
            for(char c : path.toCharArray()){
                if(c == '(' || c == ')'){
                    isKey = !isKey;
                    if(c == ')'){
                        duplicates.putIfAbsent(key.toString(), new ArrayList<String>());
                        List<String> v = duplicates.get(key.toString());
                        v.add(value.toString());
                        duplicates.put(key.toString(), v);
                        int lastSlash = value.lastIndexOf("/");
                        value = new StringBuilder(value.substring(0, lastSlash));
                        key   = new StringBuilder();
                    }
                }else if(!isKey){
                    if(c != ' ') value.append(c);
                    else value.append('/');
                }else {
                    key.append(c);
                }
            }
        }
        for(Map.Entry<String,List<String>> entry : duplicates.entrySet()){
            List<String> v = entry.getValue();
            if(v.size() > 1){
                ans.add(v);
            }
        }
        return ans;
    }
}