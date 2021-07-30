package linear.string;

public class SubsequenceAutomataDemo {
    public static void main(String[] args) {
        String s = "abcba#";
        int[][] auto = buildAutomata(s);
        System.out.println(isSubsequence("ab", auto));
        System.out.println(isSubsequence("cba", auto));
        System.out.println(isSubsequence("#", auto));
        System.out.println(isSubsequence("", auto));
    }
    
    static boolean isSubsequence(String t, int[][] auto) {
        int idx = 0;
        for (int i = 0; i < t.length(); i++) {
            idx = auto[idx][t.charAt(i)];
            if (idx == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    static int[][] buildAutomata(String s) {
        int[][] auto = new int[s.length() + 1][128];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (char j = 0; j < 128; j++) {
                auto[i][j] = auto[i + 1][j];
            }
            auto[i][s.charAt(i)] = i + 1;
        }
        
        return auto;
    }
}
