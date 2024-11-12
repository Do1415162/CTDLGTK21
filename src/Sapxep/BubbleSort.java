package Sapxep;

public class BubbleSort {

    public static void sort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Hoán đổi arr[j] và arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Hàm để in mảng
    public static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Hàm main để kiểm tra thuật toán
    public static void main(String args[]) {
        int arr[] = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Mảng ban đầu:");
        printArray(arr);

        BubbleSort ob = new BubbleSort();
        ob.sort(arr);

        System.out.println("Mảng sau khi sắp xếp:");
        printArray(arr);
    }
}
