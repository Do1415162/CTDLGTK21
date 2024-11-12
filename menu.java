package menuchinh;

import Cây.BinaryTree; 
import Dequy.menuDeQuy; 
import Dequy.findPartitions; 
import Dequy.solveNQueens; 
import dslkd.Link;
import dslkd.LinkList; 
import Sapxep.BubbleSort; 
import Sapxep.InsertionSort;
import Sapxep.Mergesort;
import Sapxep.Quicksort;

import java.util.Scanner;

public class menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        LinkList list = new LinkList();
        boolean exit = false;

        while (!exit) {
        	System.out.println("\n====================================|");
        	System.out.println("|       MENU CHÍNH                    |");         
        	System.out.println("|=====================================|");
        	System.out.println("| 1. Quản lý danh sách sinh viên (Cây)|");
        	System.out.println("| 2. Đệ quy                           |");
        	System.out.println("| 3. Quản lý danh sách liên kết đơn   |");
        	System.out.println("| 4. Sắp xếp                          |");
        	System.out.println("| 5. Thoát                            |");
        	System.out.println("|=====================================|");
        	System.out.print("Chọn chức năng: ");
        	int choice = scanner.nextInt();
        	scanner.nextLine();  

            switch (choice) {
                case 1:
                    manageStudents(scanner, tree);
                    break;

                case 2:
                    recursionMenu(scanner);
                    break;

                case 3:
                    manageLinkedList(scanner, list);
                    break;

                case 4:
                    sortingMenu(scanner); 
                    break;

                case 5:
                    exit = true; 
                    System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
                    break;

                default:
                    System.out.println("Tùy chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }

        scanner.close();
    }

    // Hàm để quản lý danh sách liên kết đơn
    private static void manageLinkedList(Scanner scanner, LinkList list) {
        boolean runningList = true;
        while (runningList) {
        	System.out.println("\n======================================|");
        	System.out.println("|         MENU LIÊN KẾT ĐƠN             |");
        	System.out.println("|=======================================|");
        	System.out.println("| 1. Nhập danh sách sinh viên           |");
        	System.out.println("| 2. In danh sách sinh viên             |");
        	System.out.println("| 3. In sinh viên có điểm > 5           |");
        	System.out.println("| 4. Tìm kiếm sinh viên theo mã SV      |");
        	System.out.println("| 5. Xóa sinh viên theo mã SV           |");
        	System.out.println("| 6. Chèn SV mới                        |");
        	System.out.println("| 7. Duyệt danh sách                    |");
        	System.out.println("| 8. Sắp xếp danh sách                  |");
        	System.out.println("| 9. Lưu danh sách vào file .txt        |");
        	System.out.println("| 10. Thoát                             |");
        	System.out.println("|=======================================|");
        	System.out.print("Chọn một tùy chọn: ");
        	int listChoice = scanner.nextInt();
        	scanner.nextLine(); // Đọc newline

            switch (listChoice) {
                case 1:
                    list.creatList(); // Gọi phương thức nhập sinh viên
                    break;
                case 2:
                    System.out.println("--- Danh sách sinh viên ---");
                    list.printList(); // Gọi phương thức in danh sách sinh viên
                    break;
                    
                case 3:
                    // In sinh viên có điểm > 5
                    System.out.println("--- Sinh viên có điểm > 5 ---");
                    list.printStudentsWithScoreAbove(5);
                    break;
                case 4:
                    System.out.print("Nhập mã sinh viên để tìm: ");
                    String maSVFind = scanner.nextLine();
                    Link foundStudent = list.search(maSVFind);
                    if (foundStudent != null) {
                        System.out.println("Tìm thấy: " + foundStudent.getMaSV() + " " + foundStudent.getHoTen());
                    } else {
                        System.out.println("Không tìm thấy sinh viên với mã SV: " + maSVFind);
                    }
                    break;
                case 5 :
                    System.out.print("Nhập mã sinh viên để xóa: ");
                    String maSVDelete = scanner.nextLine();
                    list.delete(maSVDelete); // Gọi phương thức xóa sinh viên
                    break;
                    
                    
                case 6:
                    // Prompt user for position to insert
                    System.out.print("Nhập vị trí để chèn (có thể là vị trí bất kỳ): ");

                    // Ensure valid integer input for position
                    int positionToInsert;
                    while (true) {
                        while (!scanner.hasNextInt()) {
                            System.out.println("Vui lòng nhập một số nguyên cho vị trí.");
                            scanner.next(); // Clear the invalid input
                        }
                        positionToInsert = scanner.nextInt(); // Get the position from user
                        scanner.nextLine(); // Clear the buffer
                        break; // Exit the loop after valid input
                    }

                    // Prompt user for student details
                    System.out.print("Nhập mã sinh viên mới: ");
                    String maSVInsert = scanner.nextLine();

                    System.out.print("Nhập họ tên sinh viên mới: ");
                    String hoTenInsert = scanner.nextLine();

                    double diemInsert = 0;
                    boolean validInput = false;

                    // Ensure valid input for score
                    while (!validInput) {
                        try {
                            System.out.print("Nhập điểm sinh viên mới: ");
                            diemInsert = scanner.nextDouble();
                            validInput = true; // If no exception, set true
                        } catch (Exception e) {
                            System.out.println("Nhập không hợp lệ. Vui lòng nhập lại điểm.");
                            scanner.next(); // Clear invalid input
                        }
                    }

                    // Adjust the position if it's negative or exceeds the list size
                    int currentSize = list.getSize();
                    if (positionToInsert < 0) {
                        positionToInsert = 0; // Insert at the beginning
                    } else if (positionToInsert > currentSize) {
                        positionToInsert = currentSize; // Append at the end
                    }

                    // Insert the student at the specified position
                    list.insertAtPosition(maSVInsert, hoTenInsert, diemInsert, positionToInsert);
                    
                    // Inform the user where the student has been inserted
                    if (positionToInsert == 0) {
                        System.out.println("Đã chèn sinh viên mới vào vị trí đầu tiên (0).");
                    } else if (positionToInsert == currentSize) {
                        System.out.println("Đã chèn sinh viên mới vào vị trí cuối cùng (" + currentSize + ").");
                    } else {
                        System.out.println("Đã chèn sinh viên mới vào vị trí: " + positionToInsert);
                    }
                    break;



                case 7:
                    list.traverse(); // Phương thức duyệt danh sách
                    break;
                case 8 :
                	list.sortList(); // Phương thức sắp xếp danh sách
                    System.out.println("--- Danh sách sinh viên sau khi sắp xếp ---");
                    list.printList(); // In danh sách đã được sắp xếp
                    break; 
                    
                case 9:
                    System.out.print("Nhập tên file để lưu: ");
                    String fileNameToSave = scanner.nextLine().trim();
                    list.saveToFile(fileNameToSave); // Lưu danh sách vào file
                    break;
                case 10:
                    runningList = false; // Quay lại menu chính
                    break;
                default:
                    System.out.println("Tùy chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

 // Hàm để xử lý menu sắp xếp
    private static void sortingMenu(Scanner scanner) {
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
        	System.out.println("\n==============================|");
        	System.out.println("|        MENU SẮP XẾP           |");
        	System.out.println("|===============================|");
        	System.out.println("| 1. Sắp xếp bằng Bubble Sort   |");
        	System.out.println("| 2. Sắp xếp bằng Insertion Sort|");
        	System.out.println("| 3. Sắp xếp bằng Merge Sort    |");
        	System.out.println("| 4. Sắp xếp bằng Quick Sort    |");
        	System.out.println("| 5. Quay lại menu chính        |");
        	System.out.println("|===============================|");
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
    }


    // Các phương thức đệ quy và quản lý sinh viên không thay đổi ở đây

 // Hàm để quản lý danh sách sinh viên (Cây)
    private static void manageStudents(Scanner scanner, BinaryTree tree) {
        boolean runningTree = true;
        while (runningTree) {
        	System.out.println("\n===================================|");
        	System.out.println("|             MENU CÂY               |");
        	System.out.println("|====================================|");
        	System.out.println("| 1. Nhập sinh viên                  |");
        	System.out.println("| 2. In danh sách sinh viên          |");
        	System.out.println("| 3. In sinh viên có điểm > 5        |");
        	System.out.println("| 4. Tìm kiếm sinh viên theo mã SV   |");
        	System.out.println("| 5. Tìm sinh viên có điểm cao nhất  |");
        	System.out.println("| 6. Xóa sinh viên theo mã SV        |");
        	System.out.println("| 7. Lưu dữ liệu ra file             |");
        	System.out.println("| 8. Thoát                           |");
        	System.out.println("|====================================|");
        	System.out.print("Chọn một tùy chọn: ");
        	int choice = scanner.nextInt();
        	scanner.nextLine(); // Đọc newline


            switch (choice) {
                case 1:
                    tree.creat(); // Đảm bảo gọi phương thức đúng
                    break;
                case 2:
                    System.out.println("--- Danh sách sinh viên ---");
                    tree.tgp(tree.root);
                    break;
                case 3:
                    System.out.println("--- Sinh viên có điểm > 5 ---");
                    tree.printIf();
                    break;
                case 4:
                    System.out.print("Nhập mã sinh viên để tìm: ");
                    String maSV = scanner.nextLine();
                    tree.search(tree.root, maSV);
                    break;
                case 5:
                    System.out.println("--- Tìm sinh viên có điểm cao nhất ---");
                    tree.findHighestScore();
                    break;
                case 6:
                    System.out.print("Nhập mã sinh viên để xóa: ");
                    String maSVToDelete = scanner.nextLine();
                    tree.root = tree.deleteNode(tree.root, maSVToDelete);
                    break;
                case 7:
                    System.out.print("Nhập tên file để lưu: ");
                    String outputFile = scanner.nextLine();
                    tree.saveToFile(outputFile);
                    break;
                case 8:
                    System.out.println("Bạn đã chọn thoát chương trình.");
                    runningTree = false; // Sửa biến để thoát vòng lặp
                    break;
                default:
                    System.out.println("Tùy chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
        System.out.println("Chương trình đã kết thúc."); // Thông báo kết thúc chương trình
    }




    // Hàm để xử lý menu đệ quy
    private static void recursionMenu(Scanner scanner) {
        boolean runningRecursion = true;
        while (runningRecursion) {
        	System.out.println("\n=========================================|");
        	System.out.println("|             MENU ĐỆ QUY                  |");
        	System.out.println("|==========================================|");
        	System.out.println("| 1. Tính giai thừa                        |");
        	System.out.println("| 2. Tính Fibonacci                        |");
        	System.out.println("| 3. Tính tổng các chữ số                  |");
        	System.out.println("| 4. Tính lũy thừa                         |");
        	System.out.println("| 5. Đếm số chữ cái trong chuỗi            |");
        	System.out.println("| 6. Tìm giá trị lớn nhất trong mảng       |");
        	System.out.println("| 7. Tìm giá trị nhỏ nhất trong mảng       |");
        	System.out.println("| 8. Tính tổng của một mảng                |");
        	System.out.println("| 9. Tính tích của dãy số                  |");
        	System.out.println("| 10. Giải bài toán N-Queens               |");
        	System.out.println("| 11. Quay lại menu chính                  |");
        	System.out.println("|==========================================|");
        	System.out.print("Chọn một tùy chọn: ");
        	int recursionChoice = scanner.nextInt();
        	scanner.nextLine(); // Đọc newline


            switch (recursionChoice) {
                case 1:
                    System.out.print("Nhập số để tính giai thừa: ");
                    int factorialInput = scanner.nextInt();
                    System.out.println("Giai thừa của " + factorialInput + " là " + factorial(factorialInput));
                    break;
                case 2:
                    System.out.print("Nhập số để tính Fibonacci: ");
                    int fibonacciInput = scanner.nextInt();
                    System.out.println("Fibonacci của " + fibonacciInput + " là " + fibonacci(fibonacciInput));
                    break;
                case 3:
                    System.out.print("Nhập số để tính tổng các chữ số: ");
                    int sumInput = scanner.nextInt();
                    System.out.println("Tổng các chữ số của " + sumInput + " là " + sumOfDigits(sumInput));
                    break;
                case 4:
                    System.out.print("Nhập số cơ sở: ");
                    int base = scanner.nextInt();
                    System.out.print("Nhập số mũ: ");
                    int exponent = scanner.nextInt();
                    System.out.println(base + " lũy thừa " + exponent + " là " + power(base, exponent));
                    break;
                case 5:
                    System.out.print("Nhập chuỗi để đếm ký tự: ");
                    String str = scanner.nextLine();
                    System.out.println("Số ký tự trong chuỗi là " + countCharacters(str));
                    break;
                case 6:
                    System.out.print("Nhập số lượng phần tử trong mảng: ");
                    int arrSizeMax = scanner.nextInt();
                    int[] arrMax = new int[arrSizeMax];
                    System.out.println("Nhập các phần tử của mảng:");
                    for (int i = 0; i < arrSizeMax; i++) {
                        arrMax[i] = scanner.nextInt();
                    }
                    System.out.println("Giá trị lớn nhất trong mảng là " + findMax(arrMax, arrSizeMax - 1));
                    break;
                case 7:
                    System.out.print("Nhập số lượng phần tử trong mảng: ");
                    int arrSizeMin = scanner.nextInt();
                    int[] arrMin = new int[arrSizeMin];
                    System.out.println("Nhập các phần tử của mảng:");
                    for (int i = 0; i < arrSizeMin; i++) {
                        arrMin[i] = scanner.nextInt();
                    }
                    System.out.println("Giá trị nhỏ nhất trong mảng là " + findMin(arrMin, arrSizeMin - 1));
                    break;
                case 8:
                    System.out.print("Nhập số lượng phần tử trong mảng: ");
                    int arrSizeSum = scanner.nextInt();
                    int[] arrSum = new int[arrSizeSum];
                    System.out.println("Nhập các phần tử của mảng:");
                    for (int i = 0; i < arrSizeSum; i++) {
                        arrSum[i] = scanner.nextInt();
                    }
                    System.out.println("Tổng của mảng là " + arraySum(arrSum, arrSizeSum - 1));
                    break;
                case 9:
                    System.out.print("Nhập số lượng phần tử trong mảng: ");
                    int arrSizeProd = scanner.nextInt();
                    int[] arrProd = new int[arrSizeProd];
                    System.out.println("Nhập các phần tử của mảng:");
                    for (int i = 0; i < arrSizeProd; i++) {
                        arrProd[i] = scanner.nextInt();
                    }
                    System.out.println("Tích của mảng là " + arrayProduct(arrProd, arrSizeProd - 1));
                    break;
               
                case 10:
                    System.out.print("Nhập kích thước N cho bài toán N-Queens: ");
                    int nQueens = scanner.nextInt();
                    solveNQueens.solveNQueens(nQueens); // Giả sử đã định nghĩa phương thức giải bài toán N-Queens
                    break;
                case 11:
                    runningRecursion = false; // Quay lại menu chính
                    break;
                default:
                    System.out.println("Tùy chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    // Phương thức tính giai thừa
    private static int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }

    // Phương thức tính Fibonacci
    private static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // Phương thức tính tổng các chữ số
    private static int sumOfDigits(int number) {
        if (number == 0) return 0;
        return number % 10 + sumOfDigits(number / 10);
    }

    // Phương thức tính lũy thừa
    private static double power(int x, int n) {
        if (n == 0) return 1;
        return x * power(x, n - 1);
    }

    // Phương thức đếm số ký tự trong chuỗi
    private static int countCharacters(String str) {
        if (str.isEmpty()) return 0;
        return 1 + countCharacters(str.substring(1));
    }

    // Phương thức tìm giá trị lớn nhất trong mảng
    private static int findMax(int[] arr, int n) {
        if (n == 0) return arr[0];
        return Math.max(arr[n], findMax(arr, n - 1));
    }

    // Phương thức tìm giá trị nhỏ nhất trong mảng
    private static int findMin(int[] arr, int n) {
        if (n == 0) return arr[0];
        return Math.min(arr[n], findMin(arr, n - 1));
    }

    // Phương thức tính tổng của một mảng
    private static int arraySum(int[] arr, int n) {
        if (n < 0) return 0;
        return arr[n] + arraySum(arr, n - 1);
    }

    // Phương thức tính tích của dãy số
    private static int arrayProduct(int[] arr, int n) {
        if (n < 0) return 1;
        return arr[n] * arrayProduct(arr, n - 1);
    }

    // Phương thức đếm số cách phân chia một số
    private static int countPartitions(int n) {
        // Thực hiện tính toán phân chia số
        return 0; // Trả về 0 tạm thời
    }

    // Các phương thức sắp xếp (Bubble, Insertion, Merge, Quick) chưa được định nghĩa
}




