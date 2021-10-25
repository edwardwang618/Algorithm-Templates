package math.numbertheory;

public class FastPower {
    public static void main(String[] args) {
        System.out.println(fastPower(7, 10, (int) (1e9 + 7)));
    }
    
    static int fastPower(int x, int n, int p) {
        int res = 1;
        while (n != 0) {
            if ((n & 1) != 0) {
                res = res * x % p;
            }
            
            x = x * x % p;
            n >>= 1;
        }
        
        return res;
    }
}
