package Dequy;

import java.util.Scanner;

public class menuDeQuy {
    private Scanner scanner;

    public menuDeQuy() {
        scanner = new Scanner(System.in);
    }

    public void menuDQ() {
        boolean exit = false;

        while (!exit) {
            System.out.println("\n===== MENU ĐỆ QUY =====");
            System.out.println("1. Tính giai thừa");
            System.out.println("2. Tính Fibonacci");
            System.out.println("3. Tính tổng các chữ số");
            System.out.println("4. Tính lũy thừa");
            System.out.println("5. Đếm số chữ cái trong chuỗi");
            System.out.println("6. Tìm giá trị lớn nhất trong mảng");
            System.out.println("7. Tìm giá trị nhỏ nhất trong mảng");
            System.out.println("8. Tính tổng của một mảng");
            System.out.println("9. Tính bài toán N-Queens");
            System.out.println("10. Đếm số cách phân chia một số");
            System.out.println("11. Quay lại menu chính");

            System.out.print("Chọn một tùy chọn: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Đọc newline

            switch (choice) {
                case 1:
                    System.out.print("Nhập số n để tính giai thừa: ");
                    int n1 = scanner.nextInt();
                    System.out.println("Giai thừa của " + n1 + " là: " + factorial(n1));
                    break;
                case 2:
                    System.out.print("Nhập số n để tính Fibonacci: ");
                    int n2 = scanner.nextInt();
                    System.out.println("Fibonacci thứ " + n2 + " là: " + fibonacci(n2));
                    break;
                case 3:
                    System.out.print("Nhập số nguyên để tính tổng chữ số: ");
                    int number = scanner.nextInt();
                    System.out.println("Tổng các chữ số của " + number + " là: " + sumOfDigits(number));
                    break;
                case 4:
                    System.out.print("Nhập số x: ");
                    int x = scanner.nextInt();
                    System.out.print("Nhập số mũ n: ");
                    int n = scanner.nextInt();
                    System.out.println(x + "^" + n + " là: " + power(x, n));
                    break;
                case 5:
                    System.out.print("Nhập chuỗi: ");
                    String str = scanner.nextLine();
                    System.out.println("Số ký tự trong chuỗi là: " + countCharacters(str));
                    break;
                case 6:
                    System.out.print("Nhập kích thước mảng: ");
                    int size6 = scanner.nextInt();
                    int[] arr6 = new int[size6];
                    System.out.println("Nhập các phần tử của mảng:");
                    for (int i = 0; i < size6; i++) {
                        arr6[i] = scanner.nextInt();
                    }
                    System.out.println("Giá trị lớn nhất trong mảng là: " + findMax(arr6, size6 - 1));
                    break;
                case 7:
                    System.out.print("Nhập kích thước mảng: ");
                    int size7 = scanner.nextInt();
                    int[] arr7 = new int[size7];
                    System.out.println("Nhập các phần tử của mảng:");
                    for (int i = 0; i < size7; i++) {
                        arr7[i] = scanner.nextInt();
                    }
                    System.out.println("Giá trị nhỏ nhất trong mảng là: " + findMin(arr7, size7 - 1));
                    break;
                case 8:
                    System.out.print("Nhập kích thước mảng: ");
                    int size8 = scanner.nextInt();
                    int[] arr8 = new int[size8];
                    System.out.println("Nhập các phần tử của mảng:");
                    for (int i = 0; i < size8; i++) {
                        arr8[i] = scanner.nextInt();
                    }
                    System.out.println("Tổng của mảng là: " + arraySum(arr8, size8 - 1));
                    break;
                case 9:
                    System.out.print("Nhập kích thước bàn cờ (n) cho bài toán N-Queens: ");
                    int nQueens = scanner.nextInt();
                    System.out.println("Các giải pháp cho bài toán N-Queens với n = " + nQueens + ":");
                    solveNQueens(nQueens);
                    break;
                case 10:
                    System.out.print("Nhập số n để tìm số cách phân chia: ");
                    int nPartitions = scanner.nextInt();
                    System.out.println("Số cách phân chia " + nPartitions + " là: " + countPartitions(nPartitions));
                    break;
                case 11:
                    exit = true; // Quay lại menu chính
                    break;
                default:
                    System.out.println("Tùy chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    // Phương thức tính giai thừa
    private int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }

    // Phương thức tính số Fibonacci
    private int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // Phương thức tính tổng các chữ số
    private int sumOfDigits(int number) {
        if (number == 0) return 0;
        return number % 10 + sumOfDigits(number / 10);
    }

    // Phương thức tính lũy thừa
    private int power(int x, int n) {
        if (n == 0) return 1;
        return x * power(x, n - 1);
    }

    // Phương thức đếm số ký tự trong chuỗi
    private int countCharacters(String str) {
        if (str.isEmpty()) return 0;
        return 1 + countCharacters(str.substring(1));
    }

    // Phương thức tìm giá trị lớn nhất trong mảng
    private int findMax(int[] arr, int index) {
        if (index == 0) return arr[0];
        return Math.max(arr[index], findMax(arr, index - 1));
    }

    // Phương thức tìm giá trị nhỏ nhất trong mảng
    private int findMin(int[] arr, int index) {
        if (index == 0) return arr[0];
        return Math.min(arr[index], findMin(arr, index - 1));
    }

    // Phương thức tính tổng của mảng
    private int arraySum(int[] arr, int index) {
        if (index < 0) return 0;
        return arr[index] + arraySum(arr, index - 1);
    }

    // Phương thức tính tích của dãy số
    private int arrayProduct(int[] arr, int index) {
        if (index < 0) return 1; // Tích của dãy số rỗng là 1
        return arr[index] * arrayProduct(arr, index - 1);
    }

    // Phương thức đếm số cách phân chia một số
    private int countPartitions(int n) {
        if (n <= 1) return 1; // Chỉ có một cách để phân chia 0 hoặc 1
        int count = 0;
        for (int i = 1; i <= n; i++) {
            count += countPartitions(n - i);
        }
        return count;
    }

    // Phương thức giải bài toán N-Queens
    private void solveNQueens(int n) {
        int[] board = new int[n];
        solveNQueensUtil(board, 0, n);
    }

    private void solveNQueensUtil(int[] board, int row, int n) {
        if (row == n) {
            printSolution(board);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col)) {
                board[row] = col; // Đặt quân hậu
                solveNQueensUtil(board, row + 1, n); // Đệ quy cho hàng tiếp theo
            }
        }
    }

    private boolean isSafe(int[] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col || board[i] - i == col - row || board[i] + i == col + row) {
                return false; // Kiểm tra cột và hai đường chéo
            }
        }
        return true;
    }

    private void printSolution(int[] board) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i] == j) {
                    System.out.print("Q "); // In quân hậu
                } else {
                    System.out.print(". "); // In ô trống
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
