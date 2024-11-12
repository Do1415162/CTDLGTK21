package Sapxep;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;

        // Nhập số lượng phần tử trong mảng và kiểm tra tính hợp lệ
        do {
            System.out.print("Nhập số lượng phần tử trong mảng (số nguyên dương): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Vui lòng nhập một số nguyên dương.");
                System.out.print("Nhập số lượng phần tử trong mảng: ");
                scanner.next(); // Bỏ qua dữ liệu không hợp lệ
            }
            n = scanner.nextInt();
            if (n <= 0) {
                System.out.println("Số lượng phần tử phải là số nguyên dương. Vui lòng nhập lại.");
            }
        } while (n <= 0); // Lặp lại cho đến khi người dùng nhập một số dương

        int[] arr = new int[n]; // Khởi tạo mảng với kích thước n

        // Nhập các phần tử của mảng
        System.out.println("Nhập các phần tử của mảng (số nguyên dương):");
        for (int i = 0; i < n; i++) {
            System.out.print("Phần tử [" + i + "]: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Vui lòng nhập một số nguyên dương.");
                System.out.print("Phần tử [" + i + "]: ");
                scanner.next(); // Bỏ qua dữ liệu không hợp lệ
            }
            arr[i] = scanner.nextInt();
            while (arr[i] <= 0) {
                System.out.println("Vui lòng nhập số nguyên dương.");
                System.out.print("Phần tử [" + i + "]: ");
                arr[i] = scanner.nextInt();
            }
        }

        boolean runningSort = true;
        while (runningSort) {
            System.out.println("\n--- MENU SẮP XẾP ---");
            System.out.println("1. Sắp xếp bằng Bubble Sort");
            System.out.println("2. Sắp xếp bằng Insertion Sort");
            System.out.println("3. Sắp xếp bằng Merge Sort");
            System.out.println("4. Sắp xếp bằng Quick Sort");
            System.out.println("5. Quay lại menu chính");

            System.out.print("Chọn một tùy chọn: ");
            int sortChoice = scanner.nextInt();
            scanner.nextLine(); // Đọc newline

            switch (sortChoice) {
                case 1:
                    BubbleSort bubbleSort = new BubbleSort();
                    bubbleSort.sort(arr);
                    System.out.println("Mảng sau khi sắp xếp bằng Bubble Sort:");
                    BubbleSort.printArray(arr);
                    break;

                case 2:
                    InsertionSort insertionSort = new InsertionSort();
                    insertionSort.sort(arr);
                    System.out.println("Mảng sau khi sắp xếp bằng Insertion Sort:");
                    InsertionSort.printArray(arr);
                    break;

                case 3:
                    Mergesort mergeSort = new Mergesort();
                    mergeSort.sort(arr, 0, arr.length - 1);
                    System.out.println("Mảng sau khi sắp xếp bằng Merge Sort:");
                    Mergesort.printArray(arr);
                    break;

                case 4:
                    Quicksort quickSort = new Quicksort();
                    quickSort.sort(arr, 0, arr.length - 1);
                    System.out.println("Mảng sau khi sắp xếp bằng Quick Sort:");
                    Quicksort.printArray(arr);
                    break;

                case 5:
                    runningSort = false; // Quay lại menu chính
                    break;

                default:
                    System.out.println("Tùy chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }

        scanner.close(); // Đóng scanner
    }
}
