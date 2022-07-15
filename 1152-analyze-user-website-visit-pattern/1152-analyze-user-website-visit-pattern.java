class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        //make a hashmap <string, Map<int, string>> user and websites visited in order
        //make a hashmap of seq of 3 websites visited and the count 
        //above can be done by traversing the list in sliding window technique for each user 
        
        // Maps a username to a list of accesses (timestamp, website)-pairs.
        Map<String, List<Pair<Integer, String>>> users = new HashMap<>();
        
        for (int i = 0; i < username.length; ++i) {
            users.putIfAbsent(username[i], new ArrayList<>());
            users.get(username[i]).add(new Pair<>(timestamp[i], website[i]));
        }
        
        // Sort accesses of each user by timestamp (ascending order).
        for (List<Pair<Integer, String>> accesses : users.values()) {
            accesses.sort((a, b) -> Integer.compare(a.getKey(), b.getKey()));
        } 

        List<String> result = null;
        int resOccurrences = -1;
        String resKey = null;
        // Maps a 3-sequence to the number of users that have it.
        Map<String, Integer> threeSequences = new HashMap<>();

        for (String user : users.keySet()) {
            List<Pair<Integer, String>> accesses = users.get(user);   
            Set<String> seen = new HashSet<>();//reset for every user
            
            for (int i = 0; i < accesses.size(); ++i) {
                for (int j = i + 1; j < accesses.size(); ++j) {
                    for (int k = j + 1; k < accesses.size(); ++k) {
                        String key = accesses.get(i).getValue() + "-" + 
                            accesses.get(j).getValue() + "-" + 
                            accesses.get(k).getValue();
                        /*
                        The score of a pattern is the number of users that 
                        visited all the websites in the pattern in the same order they appeared in the pattern.
                        Once a certain user visited a site we no longer required to count for it
                        */
                        if (seen.contains(key)) continue;

                        threeSequences.put(key, threeSequences.getOrDefault(key, 0) + 1);
                        seen.add(key);//so if current user again visits the same 3 seq then we no need to count

                        if (resOccurrences < threeSequences.get(key) || 
                                (resOccurrences == threeSequences.get(key) && resKey.compareTo(key) > 0)) {
                            
                            result = Arrays.asList(accesses.get(i).getValue(), 
                                                   accesses.get(j).getValue(), 
                                                   accesses.get(k).getValue());
                            
                            resOccurrences = threeSequences.get(key);
                            resKey = key;
                        }
                    }
                }
            }
        }
        return result;
    }
}