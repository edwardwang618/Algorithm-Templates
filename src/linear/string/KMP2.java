package linear.string;

import java.util.Arrays;

public class KMP2 {
    public static void main(String[] args) {
        System.out.println(kmp("ababc", "abc"));
        System.out.println(kmp("ababc", "ab"));
        System.out.println(kmp("ababc", "ac"));
        System.out.println(kmp("abbabc", "ba"));
        System.out.println(kmp("abbabc", ""));
        System.out.println(kmp("", ""));
    
        String p = "aaaab";
        System.out.println(Arrays.toString(buildNext(p)));
        System.out.println(Arrays.toString(KMP1.buildNext(p)));
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
        ne[0] = -1;
        for (int i = 0, j = -1; i < p.length() - 1; ) {
            if (j == -1 || p.charAt(i) == p.charAt(j)) {
                i++;
                j++;
                ne[i] = p.charAt(i) != p.charAt(j) ? j : ne[j];
            } else {
                j = ne[j];
            }
        }
        
        return ne;
    }
}
