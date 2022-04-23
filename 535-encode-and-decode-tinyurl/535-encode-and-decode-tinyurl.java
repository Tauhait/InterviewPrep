public class Codec {
    private String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private HashMap<String, String> map = new HashMap<>();
    private Random rand = new Random();
    private final String tinyUrl = "http://tinyurl.com/";
    private final int len = alphabet.length();
    private final int MAX_URL_LEN = 6;
    // Encodes a URL to a shortened URL.
    private String getRand() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < MAX_URL_LEN; i++) {
            sb.append(alphabet.charAt(rand.nextInt(len)));
        }
        return sb.toString();
    }
    public String encode(String longUrl) {
        String key = getRand();
        while (map.containsKey(key)) {
            key = getRand();
        }
        map.put(key, longUrl);
        return tinyUrl + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String key = shortUrl.replace(tinyUrl, "");
        return map.get(key);
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