package Dequy;

public class TimMin {
    public static int min(int[] arr, int n) {
        if (n == 1) {
            return arr[0];
        }
        return Math.min(arr[n - 1], min(arr, n - 1));
    }
}
