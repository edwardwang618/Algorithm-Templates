package linear.string;

public class SubsequenceAutomataDemo {
    public static void main(String[] args) {
        String s = "abcba#";
        int[][] dfa = buildDfa(s);
        System.out.println(isSubsequence("ab", dfa));
        System.out.println(isSubsequence("cba", dfa));
        System.out.println(isSubsequence("#", dfa));
        System.out.println(isSubsequence("", dfa));
    }
    
    static boolean isSubsequence(String t, int[][] auto) {
        for (int i = 0, pos = 0; i < t.length(); i++) {
            pos = auto[pos][t.charAt(i)];
            if (pos == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    static int[][] buildDfa(String s) {
        int[][] dfa = new int[s.length() + 1][128];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (char j = 0; j < 128; j++) {
                dfa[i][j] = dfa[i + 1][j];
            }
            dfa[i][s.charAt(i)] = i + 1;
        }
        
        return dfa;
    }
}
