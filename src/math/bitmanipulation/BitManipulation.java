package math.bitmanipulation;

public class BitManipulation {
    public static void main(String[] args) {
        int x = 0x3f3f3f3f;
        System.out.println(x);
        System.out.println(x * 2);
    
        x = 0b1010;
        System.out.println(x);
        System.out.println(lowbit(x));
        x = -0b1010;
        System.out.println(Integer.toBinaryString(x));
        System.out.println(x);
        System.out.println(lowbit(x));
    }
    
    static int lowbit(int x) {
        return x & -x;
    }
}
