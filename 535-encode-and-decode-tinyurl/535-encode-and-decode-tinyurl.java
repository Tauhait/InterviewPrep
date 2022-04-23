public class Codec {
    private Map<Integer, String> map = new HashMap<>();
    private final String tinyurl = "http://tinyurl.com/";
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        StringBuilder sb = new StringBuilder();
        Integer hCode = longUrl.hashCode();
        map.put(hCode, longUrl);
        return sb.append(tinyurl).append(hCode).toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String key = shortUrl.replace(tinyurl, "");
        return map.get(Integer.parseInt(key));
    }
}


/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));