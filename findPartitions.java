package Dequy;

public class findPartitions {

    public static void findPartitions(int n) {
        int[] result = new int[n];
        findPartitionsUtil(n, 0, result);
    }

    private static void findPartitionsUtil(int n, int index, int[] result) {
        if (n == 0) {
            printPartition(result, index);
            return;
        }
        for (int i = 1; i <= n; i++) {
            result[index] = i;
            findPartitionsUtil(n - i, index + 1, result);
        }
    }

    private static void printPartition(int[] result, int index) {
        for (int i = 0; i < index; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 5; // Bạn có thể thay đổi giá trị này
        System.out.println("Các phân hoạch của " + n + " là:");
        findPartitions(n);
    }
}
