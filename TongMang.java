package Dequy;

public class TongMang {
    public static int tong(int[] arr, int n) {
        if (n <= 0) {
            return 0;
        }
        return arr[n - 1] + tong(arr, n - 1);
    }
}
