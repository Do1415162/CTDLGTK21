package dslkdonDao;

import java.util.Scanner;

public class MainDao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkList list = new LinkList();
        int choice;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Đọc danh sách sinh viên từ file");
            System.out.println("2. Ghi danh sách sinh viên vào file");
            System.out.println("3. Hiển thị danh sách sinh viên");
            System.out.println("4. Hiển thị sinh viên có điểm >= 5");
            System.out.println("5. Xếp loại sinh viên");
            System.out.println("6. Hiển thị sinh viên có điểm cao nhất");
            System.out.println("7. Xóa sinh viên theo mã");
            System.out.println("8. Sắp xếp sinh viên theo họ tên");
            System.out.println("9. Thống kê sinh viên theo xếp loại");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    list.docfile();
                    System.out.println("Đã đọc danh sách sinh viên từ file.");
                    break;
                case 2:
                    list.ghifile();
                    System.out.println("Đã ghi danh sách sinh viên vào file.");
                    break;
                case 3:
                    list.printList();
                    break;
                case 4:
                    list.hienThiSinhVienDiemTBHon5();
                    break;
                case 5:
                    list.xepLoaiSinhVien();
                    break;
                case 6:
                    list.hienThiSinhVienDiemCaoNhat();
                    break;
                case 7:
                    System.out.print("Nhập mã sinh viên cần xóa: ");
                    String maSV = scanner.nextLine();
                    list.xoaSinhVien(maSV);
                    break;
                case 8:
                    list.sapXepSinhVienTheoHoTen();
                    break;
                case 9:
                    list.thongKeSinhVien();
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
