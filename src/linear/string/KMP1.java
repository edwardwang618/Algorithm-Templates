package linear.string;

import java.util.Arrays;

public class KMP1 {
    public static void main(String[] args) {
        System.out.println(kmp("ababc", "abc"));
        System.out.println(kmp("ababc", "ab"));
        System.out.println(kmp("ababc", "ac"));
        System.out.println(kmp("abbabc", "ba"));
        System.out.println(kmp("abbabc", ""));
        System.out.println(kmp("", ""));
        
        String p = "aaaaa";
        p = "abcd";
        int[] ne = buildNext(p + '#');
        System.out.println(Arrays.toString(ne));
        System.out.println(p.length() - ne[p.length()]);
    
        System.out.println(minRecLen(p));
        System.out.println(minRecSubString(p));
        
        p = "abcababc";
        System.out.println(minRecLen(p));
        System.out.println(minRecSubString(p));
    
        p = "abcabcabc";
        System.out.println(minRecLen(p));
        System.out.println(minRecSubString(p));
    
        p = "abcabab";
        System.out.println(minRecLen(p));
        System.out.println(minRecSubString(p));
    
        p = "a";
        System.out.println(minRecLen(p));
        System.out.println(minRecSubString(p));
    
        p = "";
        System.out.println(minRecLen(p));
        System.out.println(minRecSubString(p));
    }
    
    public static int kmp(String s, String p) {
        if (p.isEmpty()) {
            return 0;
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
                return i - j;
            }
        }
        
        return -1;
    }
    
    public static int[] buildNext(String p) {
        int[] ne = new int[p.length()];
        for (int i = 0, j = ne[0] = -1; i < p.length() - 1; ) {
            if (j == -1 || p.charAt(i) == p.charAt(j)) {
                ne[++i] = ++j;
            } else {
                j = ne[j];
            }
        }
        
        return ne;
    }
    
    public static int minRecLen(String p) {
        if (p.isEmpty()) {
            return 0;
        }
        
        int len = p.length() - buildNext(p + '#')[p.length()];
        return p.length() % len == 0 ? len : p.length();
    }
    
    public static String minRecSubString(String p) {
        if (p.isEmpty()) {
            return "";
        }
        
        return p.substring(0, minRecLen(p));
    }
}
