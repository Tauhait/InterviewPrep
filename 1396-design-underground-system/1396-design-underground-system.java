class UndergroundSystem {
    private List<Trip> trips;
    private Map<String, List<Integer>> stTimeMap;
    
    public UndergroundSystem() {
        trips = new ArrayList<Trip>();
        stTimeMap = new HashMap();
    }
    
    public void checkIn(int id, String stationName, int t) {
        Trip newTrip = new Trip(id, stationName, t);
        trips.add(newTrip);
    }
    
    public void checkOut(int id, String stationName, int t) {
        Trip search = null;
        for(Trip thisTrip : trips){
            if(thisTrip.getPid() == id && thisTrip.get_ch_out() == -1){
                thisTrip.setOut(stationName, t);
                search = thisTrip;
                break;
            }
        }
        String key = search.get_st_in() + "," + search.get_st_out();
        int travelTime = search.get_ch_out() - search.get_ch_in();
        buildMap(key, travelTime);
    }
    private void buildMap(String key, int tt){
        List<Integer> l = null;
        if(stTimeMap.containsKey(key)){
            l = stTimeMap.get(key);
            l.set(0, l.get(0) + tt);
            l.set(1, l.get(1) + 1);                
        }else {
            l = new ArrayList();                
            l.add(0, tt);
            l.add(1, 1);
        }
        stTimeMap.put(key, l);
    }
    public double getAverageTime(String startStation, String endStation) {
        // System.out.println(">>>");
        // for(String k : stTimeMap.keySet()){
        //     List<Integer> l = stTimeMap.get(k);
        //     System.out.println("<" + k + ">, " + l.get(0) + ", " + l.get(1));
        // }
        String key = startStation + "," + endStation;
        if(stTimeMap.containsKey(key)){
            List<Integer> l = stTimeMap.get(key);
            double avg = l.get(0) / (1.0 * l.get(1)); 
            return avg;
        }
        return 0;        
    }
}
class Trip {
    private int pid;
    private String st_in;
    private String st_out;
    private int ch_in;
    private int ch_out;
    
    public Trip(int pid, String st_in, int ch_in){
        this.pid = pid;
        this.st_in = st_in;
        this.ch_in = ch_in;
        this.st_out = "";
        this.ch_out = -1;
    }
    public void setOut(String st_out, int ch_out){
        this.st_out = st_out;
        this.ch_out = ch_out;
    }
    public int getPid(){
        return pid;
    }
    public String get_st_in(){
        return st_in;
    }
    public String get_st_out(){
        return st_out;
    }
    public int get_ch_in(){
        return ch_in;
    }
    public int get_ch_out(){
        return ch_out;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */