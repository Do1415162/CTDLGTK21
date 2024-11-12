package Dequy;

public class TimMax {
    public static int max(int[] arr, int n) {
        if (n == 1) {
            return arr[0];
        }
        return Math.max(arr[n - 1], max(arr, n - 1));
    }
}
