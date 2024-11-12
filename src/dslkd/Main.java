package dslkd;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkList list = new LinkList();
        boolean exit = false;

        while (!exit) {
            System.out.println("\n===== MENU Liên kết đơn  =====");
            System.out.println("1. Nhập danh sách sinh viên");
            System.out.println("2. In danh sách sinh viên");
            System.out.println("3. In sinh viên có điểm > 5");
            System.out.println("4. Tìm kiếm sinh viên theo mã SV");
            System.out.println("5. Xóa sinh viên theo mã SV");
            System.out.println("6. Chèn  SV mới");
            System.out.println("7. Duyệt danh sách ");
            System.out.println("8. Sắp xếp danh sách ");
            System.out.println("9. Lưu  danh sách vào file .txt");
            System.out.println("10. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = getValidChoice(scanner, 1, 10); // Cập nhật cho phép chọn từ 1 đến 10

            switch (choice) {
                case 1:
                    // Nhập danh sách sinh viên
                    list.creatList();
                    break;
                case 2:
                    // In danh sách sinh viên
                    System.out.println("--- Danh sách sinh viên ---");
                    list.printList();
                    break;
                case 3:
                    // In sinh viên có điểm > 5
                    System.out.println("--- Sinh viên có điểm > 5 ---");
                    list.printStudentsWithScoreAbove(5);
                    break;
                case 4:
                    // Tìm kiếm sinh viên theo mã SV
                    System.out.print("Nhập mã sinh viên để tìm: ");
                    String maSV = scanner.nextLine();
                    Link student = list.search(maSV);
                    if (student != null) {
                        System.out.println("Thông tin sinh viên: " + student.getMaSV() + " " + student.getHoTen() + "; " + student.getDiem());
                    } else {
                        System.out.println("Không tìm thấy sinh viên với mã " + maSV);
                    }
                    break;
                case 5:
                    // Xóa sinh viên theo mã SV
                    System.out.print("Nhập mã sinh viên để xóa: ");
                    String deleteId = scanner.nextLine();
                    list.delete(deleteId);
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



                case 7 :
                    list.traverse(); // Phương thức duyệt danh sách
                    break;
                case 8 :
                	list.sortList(); // Phương thức sắp xếp danh sách
                    System.out.println("--- Danh sách sinh viên sau khi sắp xếp ---");
                    list.printList(); // In danh sách đã được sắp xếp
                    break; 
                case 9 :
                    System.out.print("Nhập tên file để lưu: ");
                    String fileNameToSave = scanner.nextLine().trim();
                    list.saveToFile(fileNameToSave); // Lưu danh sách vào file
                    break;
                case 10:
                    // Thoát chương trình
                    exit = true;
                    System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
                    break;
                default:
                    System.out.println("Tùy chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
        scanner.close();
    }

    private static int getValidChoice(Scanner scanner, int min, int max) {
        int choice = -1;
        while (choice < min || choice > max) {
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Đọc newline
                if (choice < min || choice > max) {
                    System.out.println("Tùy chọn không hợp lệ. Vui lòng chọn lại từ " + min + " đến " + max + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("Vui lòng nhập một số nguyên hợp lệ.");
                scanner.nextLine(); // Xóa input không hợp lệ
            }
        }
        return choice;
    }
}
