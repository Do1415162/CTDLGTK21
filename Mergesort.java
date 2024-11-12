package Sapxep;

public class Mergesort {
    void merge(int arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        // Tạo mảng tạm thời
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Sao chép dữ liệu vào các mảng tạm
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Gộp hai mảng tạm lại thành mảng chính
        int i = 0, j = 0;
        int k = l;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Sao chép các phần tử còn lại của mảng L nếu có
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Sao chép các phần tử còn lại của mảng R nếu có
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public  void sort(int arr[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            // Sắp xếp hai nửa
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Gộp lại sau khi đã sắp xếp
            merge(arr, l, m, r);
        }
    }

    public static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = {25, 30, 45, 6, 11, 90, 15};

        System.out.println("Mảng ban đầu: ");
        printArray(arr);

        Mergesort ob = new Mergesort();
        ob.sort(arr, 0, arr.length - 1);

        System.out.println("Mảng sau khi sắp xếp: ");
        printArray(arr);
    }
}
