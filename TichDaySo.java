package Dequy;

public class TichDaySo {
    public static int product(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * product(n - 1);
    }
}
