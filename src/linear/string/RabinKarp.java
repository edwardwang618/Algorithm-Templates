package linear.string;

import java.util.Map;

public class RabinKarp {
    
    static long P = 131L;
    
    public static void main(String[] args) {
        String s = "aadesce";
        System.out.println(isSubStr(s, "ce"));
        System.out.println(isSubStr(s, "sce"));
        System.out.println(isSubStr(s, "ac"));
    }
 
    public static int isSubStr(String s, String p) {
        // first rule out the impossible case
        if (p.length() > s.length()) {
            return -1;
        }
        
        long hash = 0, pow = 1;
        
        long hashP = 0;
        for (int i = 0; i < p.length(); i++) {
            hashP = hashP * P + p.charAt(i);
            hash = hash * P + s.charAt(i);
            pow *= P;
        }
        
        if (hash == hashP) {
            return 0;
        }
        
        // its rolling hash
        for (int i = p.length(); i < s.length(); i++) {
            hash = hash * P + s.charAt(i);
            hash -= s.charAt(i - p.length()) * pow;
    
            if (hash == hashP) {
                return i - p.length() + 1;
            }
        }
    
        return -1;
    }
}
