package math.numbertheory;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        System.out.println(gcd(12, 15));
        System.out.println(gcd(24, 18));
    }
    
    static int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }
}
