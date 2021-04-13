package linear.string;

import java.util.ArrayList;
import java.util.List;

public class KMPFindAll {
    public static void main(String[] args) {
        System.out.println(kmp("ababc", "abc"));
        System.out.println(kmp("ababc", "ab"));
        System.out.println(kmp("ababc", "ac"));
        System.out.println(kmp("abbabc", "ba"));
        System.out.println(kmp("abbabc", ""));
        System.out.println(kmp("", ""));
    }
    
    public static List<Integer> kmp(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (p.isEmpty()) {
            return res;
        }
        
        int[] ne = buildNext(p);
        for (int i = 0, j = 0; i < s.length(); ) {
            if (j == -1 || s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else {
                j = ne[j];
            }
            
            if (j == p.length()) {
                res.add(i - j);
                i--;
                j = ne[j - 1];
            }
        }
        
        return res;
    }
    
    public static int[] buildNext(String p) {
        int[] ne = new int[p.length()];
        ne[0] = -1;
        for (int i = 0, j = -1; i < p.length() - 1; ) {
            if (j == -1 || p.charAt(i) == p.charAt(j)) {
                ne[++i] = ++j;
            } else {
                j = ne[j];
            }
        }
        
        return ne;
    }
}
