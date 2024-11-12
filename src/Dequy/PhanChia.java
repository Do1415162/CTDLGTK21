package Dequy;

public class PhanChia {
    public static int phanChia(int n, int m) {
        if (n == 0) {
            return 1;
        }
        if (n < 0 || m <= 0) {
            return 0;
        }
        return phanChia(n, m - 1) + phanChia(n - m, m);
    }
}
