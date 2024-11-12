package dslkdonDao;

import java.util.Scanner;

public class LinkList {
    public Link first;
    LinkDao obj = new LinkDao();

    // LinkList constructor
    public LinkList() {
        first = null;
    }

    public void insert(String maSV, String hoten, double diem) {
       Link nut = new Link(maSV, hoten, diem);
       
        nut.nextLink = first;
        first = nut;
    }

    // Cập nhật phương thức ghifile để thêm thông tin điểm trung bình và xếp loại
    public void ghifile() {
        // Điền dữ liệu sinh viên
        insert("001", "Anh A", 9);
        insert("002", "Anh B", 4);
        insert("003", "Anh C", 6.5);
        insert("004", "Anh D", 8);
        insert("005", "Anh T", 7);
        
        // Ghi dữ liệu ra file, bao gồm điểm trung bình và xếp loại
        obj.ghiFile(first);  // Thực hiện ghi file tại đây, không in ra thông báo
    }

    public void docfile() {
        first = obj.docFile("d:\\thi2.bin");
    }

    public void printList() {
        Link p = first;
        while (p != null) {
            System.out.println(p.getMaSV() + "  " + p.getHoten() + "   " + p.getDiem());
            p = p.nextLink;
        }
        System.out.println("");
    }

    // 1. Hiển thị sinh viên có điểm trung bình >= 5
    public void hienThiSinhVienDiemTBHon5() {
        Link p = first;
        System.out.println("Sinh viên có điểm trung bình >= 5:");
        while (p != null) {
            if (p.getDiem() >= 5) {
                System.out.println(p.getMaSV() + "  " + p.getHoten() + "   " + p.getDiem());
            }
            p = p.nextLink;
        }
    }

    // 2. Điền dữ liệu kết quả và xếp loại
    public void xepLoaiSinhVien() {
        Link p = first;
        System.out.println("Xếp loại sinh viên:");
        while (p != null) {
            String xepLoai;
            if (p.getDiem() < 5) {
                xepLoai = "Kém";
            } else if (p.getDiem() < 7) {
                xepLoai = "Trung Bình";
            } else if (p.getDiem() < 8.5) {
                xepLoai = "Khá";
            } else {
                xepLoai = "Giỏi";
            }
            System.out.println(p.getMaSV() + "  " + p.getHoten() + "   " + p.getDiem() + "  Xếp loại: " + xepLoai);
            p = p.nextLink;
        }
    }

    // 3. Hiển thị những sinh viên có điểm trung bình lớn nhất
    public void hienThiSinhVienDiemCaoNhat() {
        if (first == null) return;
        Link p = first;
        double maxDiem = p.getDiem();

        // Tìm điểm cao nhất
        while (p != null) {
            if (p.getDiem() > maxDiem) {
                maxDiem = p.getDiem();
            }
            p = p.nextLink;
        }

        // Hiển thị sinh viên có điểm cao nhất
        p = first;
        System.out.println("Sinh viên có điểm trung bình cao nhất:");
        while (p != null) {
            if (p.getDiem() == maxDiem) {
                System.out.println(p.getMaSV() + "  " + p.getHoten() + "   " + p.getDiem());
            }
            p = p.nextLink;
        }
    }

    // 4. Xóa sinh viên có maSV bất kỳ
    public void xoaSinhVien(String maSV) {
        Link p = first;
        Link previous = null;

        while (p != null) {
            if (p.getMaSV().equals(maSV)) {
                if (previous == null) {
                    first = p.nextLink; // Xóa đầu danh sách
                } else {
                    previous.nextLink = p.nextLink; // Xóa giữa danh sách
                }
                System.out.println("Đã xóa sinh viên: " + maSV);
                return;
            }
            previous = p;
            p = p.nextLink;
        }
        System.out.println("Không tìm thấy sinh viên với mã số: " + maSV);
    }

    // 5. Sắp xếp họ tên sinh viên theo mức tăng dần
    public void sapXepSinhVienTheoHoTen() {
        if (first == null) return;
        Link current = first, index = null;
        String tempHoten;
        double tempDiem;
        String tempMaSV;

        // Sử dụng thuật toán sắp xếp nổi bọt
        while (current != null) {
            index = current.nextLink;
            while (index != null) {
                if (current.getHoten().compareTo(index.getHoten()) > 0) {
                    // Hoán đổi thông tin sinh viên
                    tempHoten = current.getHoten();
                    tempDiem = current.getDiem();
                    tempMaSV = current.getMaSV();

                    current.hoten = index.getHoten();
                    current.diem = index.getDiem();
                    current.maSV = index.getMaSV();

                    index.hoten = tempHoten;
                    index.diem = tempDiem;
                    index.maSV = tempMaSV;
                }
                index = index.nextLink;
            }
            current = current.nextLink;
        }
        System.out.println("Danh sách sinh viên sau khi sắp xếp theo họ tên:");
        printList();
    }

    // 6. Thống kê học sinh Kém, Trung Bình, Khá, Giỏi
    public void thongKeSinhVien() {
        int kem = 0, trungBinh = 0, kha = 0, gioi = 0;
        Link p = first;
        while (p != null) {
            if (p.getDiem() < 5) {
                kem++;
            } else if (p.getDiem() < 7) {
                trungBinh++;
            } else if (p.getDiem() < 8.5) {
                kha++;
            } else {
                gioi++;
            }
            p = p.nextLink;
        }
        System.out.println("Thống kê sinh viên:");
        System.out.println("Kém: " + kem);
        System.out.println("Trung Bình: " + trungBinh);
        System.out.println("Khá: " + kha);
        System.out.println("Giỏi: " + gioi);
    }
}
