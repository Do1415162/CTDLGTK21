package lkdoi;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkList list = new LinkList();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            // Hiển thị menu
            System.out.println("\n--- MENU ---");
            System.out.println("1. Tạo danh sách sinh viên");
            System.out.println("2. Hiển thị danh sách sinh viên");
            System.out.println("3. Chèn thêm sinh viên");
            System.out.println("4. Xếp loại sinh viên");
            System.out.println("5. Tính kết quả sinh viên");
            System.out.println("6. Tìm kiếm sinh viên theo mã");
            System.out.println("7. Xóa sinh viên theo mã");
            System.out.println("8. Tìm sinh viên có điểm cao nhất");
            System.out.println("9. Thống kê sinh viên theo xếp loại (Giỏi, Khá, Trung bình, Yếu)");
            System.out.println("10. Lưu danh sách sinh viên ra file");
            System.out.println("11. Xuất danh sách sinh viên ra file");
            System.out.println("0. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            choice = sc.nextInt();
            sc.nextLine();  
            switch (choice) {
                case 1:
                    
                    System.out.println("Tạo danh sách sinh viên:");
                    list.createList();
                    break;
                case 2:
                    
                    System.out.println("Danh sách sinh viên:");
                    list.xl();  
                    list.kq();  
                    list.printList();
                    break;
                case 3:
                    System.out.println("Chèn thêm sinh viên mới:");
                    System.out.print("Nhập mã sinh viên: ");
                    String maSV = sc.nextLine();
                    System.out.print("Nhập họ tên sinh viên: ");
                    String hoTen = sc.nextLine();
                    System.out.print("Nhập điểm sinh viên: ");
                    double diem = sc.nextDouble();
                    sc.nextLine();  // Đọc newline sau khi nhập

                    list.insert(maSV, hoTen, diem);

                   
                    list.xl();
                    list.kq();

                 
                    System.out.println("Danh sách sinh viên sau khi thêm mới:");
                    list.printList();
                    break;
                case 4:
                   
                    System.out.println("Xếp loại sinh viên:");
                    list.xl();
                    System.out.println("Danh sách sinh viên sau khi xếp loại:");
                    list.printList(); 
                    break;
                case 5:
                   
                    System.out.println("Tính kết quả sinh viên (Đạt/Không đạt):");
                    list.kq();
                    System.out.println("Danh sách sinh viên sau khi tính kết quả:");
                    list.printList(); 
                    break;
                case 6:
                   
                    System.out.print("Nhập mã sinh viên cần tìm: ");
                    maSV = sc.nextLine();
                    DoubleLink found = list.search(maSV);
                    if (found != null) {
                        System.out.println("Sinh viên tìm thấy: ");
                        System.out.println(found.getMaSV() + " - " + found.getHoTen() + " - " + found.getDiem() + " - " + found.getXl() + " - " + found.getKq());
                    } else {
                        System.out.println("Không tìm thấy sinh viên có mã " + maSV);
                    }
                    break;
                case 7:
                  
                    System.out.print("Nhập mã sinh viên cần xóa: ");
                    maSV = sc.nextLine();
                    list.delete(maSV);
                    System.out.println("Sinh viên có mã " + maSV + " đã được xóa.");
                    break;
                case 8:
                  
                    DoubleLink topStudent = list.findMaxScore();
                    if (topStudent != null) {
                        System.out.println("Sinh viên có điểm cao nhất: ");
                        System.out.println(topStudent.getMaSV() + " - " + topStudent.getHoTen() + " - " + topStudent.getDiem());
                    } else {
                        System.out.println("Danh sách trống.");
                    }
                    break;
                case 9:
                    
                    System.out.println("Thống kê sinh viên theo xếp loại:");
                    list.thongKeXepLoai();
                    System.out.println("Danh sách sinh viên sau khi thống kê xếp loại:");
                    list.printList();  
                    break;
                case 10:
                    System.out.print("Nhập tên file lưu (ví dụ: data.txt): ");
                    String fileName = sc.nextLine();
                    String filePath = "D:\\lkdoi\\" + fileName;
                    File directory = new File("D:\\lkdoi");
                    if (!directory.exists()) {
                        directory.mkdir();
                    }
                    try (FileWriter fw = new FileWriter(filePath);
                         BufferedWriter bw = new BufferedWriter(fw)) {
                        list.saveToFile();
                    } catch (IOException e) {
                        System.out.println("Lỗi lưu file: " + e.getMessage());
                    }
                    break;

                case 11:
                    System.out.print("Nhập tên file xuất (ví dụ: data.txt): ");
                    fileName = sc.nextLine();
                    filePath = "D:\\lkdoi\\" + fileName;
                    try (FileWriter fw = new FileWriter(filePath);
                         BufferedWriter bw = new BufferedWriter(fw)) {
                        list.exportToFile();
                    } catch (IOException e) {
                        System.out.println("Lỗi xuất file: " + e.getMessage());
                    }
                    System.out.println("Danh sách sinh viên đã được lưu)" );
                case 0:
                  
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại.");
            }
        } while (choice != 0);  
    }
}
