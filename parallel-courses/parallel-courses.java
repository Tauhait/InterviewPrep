class Solution {
    public int minimumSemesters(int n, int[][] relations) {           
        if(relations == null || relations.length == 0){
            return 1;
        }
        Map<Integer, Integer> inDegCountMap = new HashMap();
        Map<Integer, List<Integer>> prereqMap = new HashMap();
        for(int course = 1; course <= n; course++){
            inDegCountMap.put(course, 0);
            prereqMap.put(course, new LinkedList<Integer>());
        }
        for(int[] rel : relations){
            int prereq = rel[0];
            int course = rel[1];
            inDegCountMap.put(course, inDegCountMap.get(course) + 1);
            prereqMap.get(prereq).add(course);
        }
        Queue<Integer> courseQueue = new LinkedList<Integer>();
        
        for(Integer course : inDegCountMap.keySet()){
            if(inDegCountMap.get(course) == 0){
                courseQueue.add(course);
            }
        }
        int semesters = 0;
        int coursesDone = 0;
        while(!courseQueue.isEmpty()){
            int noCoursesThisSem = courseQueue.size();
            while(noCoursesThisSem-- > 0){
                int takeCourse = courseQueue.poll();
                coursesDone++;
                List<Integer> prereqList = prereqMap.get(takeCourse);
                for(Integer prereq : prereqList){
                    inDegCountMap.put(prereq, inDegCountMap.get(prereq) - 1);
                    if(inDegCountMap.get(prereq) == 0){
                        courseQueue.add(prereq);
                    }
                }
            }
            semesters++;
        }
        if(coursesDone != n){
            return -1;
        }
        return semesters;
    }
}