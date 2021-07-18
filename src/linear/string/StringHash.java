package linear.string;

public class StringHash {
    
    static long P = 131L;
    static long[] pow;
    static final int N = 20;
    
    private static void initPow() {
        pow = new long[N + 1];
        pow[0] = 1;
        for (int i = 0; i < N; i++) {
            pow[i + 1] = pow[i] * P;
        }
    }
    
    public static void main(String[] args) {
        initPow();
        String s = "abcd";
        String t = "bcab";
    
        long[] hashS = hash(s), hashT = hash(t);
        System.out.println(hashSubStr(hashS, 1, 2) == hashSubStr(hashT, 0, 1));
        System.out.println(hashSubStr(hashS, 0, 1) == hashSubStr(hashT, 2, 3));
        System.out.println(hashSubStr(hashS, 1, 3) == hashSubStr(hashT, 1, 3));
    
        System.out.println((int) 'a');
        System.out.println((int) 'A');
        
        
    }
    
    public static long hashSubStr(long[] hashS, int l, int r) {
        return hashS[r + 1] - hashS[l] * pow[r - l + 1];
    }
    
    public static long[] hash(String s) {
        long[] hashS = new long[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            hashS[i + 1] = hashS[i] * P + s.charAt(i);
        }
        
        return hashS;
    }
}
