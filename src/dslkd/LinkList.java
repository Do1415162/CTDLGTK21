package dslkd;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;














public class LinkList {
    private Link first;
    private int deletedPosition = -1; // To track the position of the deleted student

    public LinkList() {
        first = null;
    }

    public void insert(String maSV, String hoTen, double diem) {
        Link nut = new Link(maSV, hoTen, diem);
        nut.nextLink = first;
        first = nut;
    }

    public void creatList() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Nhập mã sinh viên: ");
            String maSV = scanner.nextLine();
            if (maSV.isEmpty()) break; // Nếu không nhập mã, dừng lại
            System.out.print("Nhập họ tên: ");
            String hoTen = scanner.nextLine();
            double diem = 0;
            boolean validInput = false;

            while (!validInput) {
                try {
                    System.out.print("Nhập điểm: ");
                    diem = scanner.nextDouble();
                    validInput = true; // Nếu không có ngoại lệ, gán true
                } catch (Exception e) {
                    System.out.println("Nhập không hợp lệ. Vui lòng nhập lại điểm.");
                    scanner.next(); // Xóa bỏ input không hợp lệ
                }
            }
            insert(maSV, hoTen, diem);
            scanner.nextLine(); // Đọc newline sau khi nhập số
        }
    }

    public void printList() {
        Link p = first;
        while (p != null) {
            System.out.println(p.getMaSV() + " " + p.getHoTen() + "; " + p.getDiem() + "; " + p.getKq() + "; " + p.getXl());
            p = p.nextLink;
        }
    }

    public void printStudentsWithScoreAbove(double scoreThreshold) {
        Link p = first;
        boolean found = false; // Biến để kiểm tra có sinh viên nào thỏa mãn không
        while (p != null) {
            if (p.getDiem() > scoreThreshold) {
                System.out.println(p.getMaSV() + " " + p.getHoTen() + "; " + p.getDiem() + "; " + p.getKq());
                found = true; // Có sinh viên thỏa mãn
            }
            p = p.nextLink;
        }
        if (!found) {
            System.out.println("Không có sinh viên nào có điểm lớn hơn " + scoreThreshold);
        }
    }

    public Link search(String maSV) {
        Link p = first;
        while ((p != null) && (!p.getMaSV().equals(maSV))) {
            p = p.nextLink;
        }
        return p; // Trả về null nếu không tìm thấy
    }

    public void delete(String maSVToDelete) {
        Link current = first, previous = null;
        while (current != null && !current.getMaSV().equals(maSVToDelete)) {
            previous = current;
            current = current.nextLink;
        }
        if (current != null) { // Nếu tìm thấy
            if (previous == null) { // Nếu là phần tử đầu tiên
                first = current.nextLink;
            } else {
                previous.nextLink = current.nextLink;
            }
            System.out.println("Đã xóa sinh viên với mã " + maSVToDelete);
            // Set deletedPosition to the position of the deleted student
            setDeletedPosition(current);
        } else {
            System.out.println("Không tìm thấy sinh viên với mã " + maSVToDelete);
        }
    }

    private void setDeletedPosition(Link deletedLink) {
        Link current = first;
        int position = 0;
        while (current != null) {
            // If we find the deleted link, we store its position
            if (current == deletedLink) {
                deletedPosition = position;
                return;
            }
            current = current.nextLink;
            position++;
        }
        deletedPosition = -1; // Reset if not found
    }

    public int getDeletedPosition() {
        return deletedPosition; // Getter for the deleted position
    }

    public void insertAtPosition(String maSV, String hoTen, double diem, int position) {
        Link newStudent = new Link(maSV, hoTen, diem);
        
        // If there's a deleted position, use that
        if (deletedPosition != -1) {
            position = deletedPosition; // Use deleted position for insertion
            deletedPosition = -1; // Reset it after use
        }

        if (position == 0) { // Chèn ở đầu danh sách
            newStudent.nextLink = first;
            first = newStudent;
        } else {
            Link current = first;
            int currentPosition = 0;
            while (current != null && currentPosition < position - 1) {
                current = current.nextLink;
                currentPosition++;
            }
            if (current != null) { // Nếu vị trí hợp lệ
                newStudent.nextLink = current.nextLink;
                current.nextLink = newStudent;
            } else {
                System.out.println("Vị trí không hợp lệ.");
            }
        }
    }

    // Phương thức duyệt danh sách
    public void traverse() {
        Link current = first;
        System.out.println("--- Duyệt Danh Sách ---");
        while (current != null) {
            System.out.println("Mã SV: " + current.getMaSV() + ", Họ Tên: " + current.getHoTen() + ", Điểm: " + current.getDiem());
            current = current.nextLink;
        }
    }

    // Phương thức sắp xếp danh sách theo mã sinh viên (Bubble Sort)
    public void sortList() {
        if (first == null || first.nextLink == null) {
            return; // Danh sách trống hoặc có một phần tử
        }
        boolean swapped;
        do {
            swapped = false;
            Link current = first;
            while (current.nextLink != null) {
                if (current.getMaSV().compareTo(current.nextLink.getMaSV()) > 0) {
                    // Hoán đổi dữ liệu
                    String tempMaSV = current.getMaSV();
                    String tempHoTen = current.getHoTen();
                    double tempDiem = current.getDiem();
                    current.setMaSV(current.nextLink.getMaSV());
                    current.setHoTen(current.nextLink.getHoTen());
                    current.setDiem(current.nextLink.getDiem());
                    current.nextLink.setMaSV(tempMaSV);
                    current.nextLink.setHoTen(tempHoTen);
                    current.nextLink.setDiem(tempDiem);
                    swapped = true;
                }
                current = current.nextLink;
            }
        } while (swapped);
    }

public int getSize() {
    int size = 0;
    Link current = first; // Start from the first link
    while (current != null) { // Traverse until the end of the list
        size++; // Increment size for each link
        current = current.nextLink; // Move to the next link
    }
    return size; // Return the total size
}



public void setDeletedPosition(int position) {
    this.deletedPosition = position; // Setter for deleted position
}







//Lưu danh sách sinh viên vào file .txt với đầy đủ thông tin
public void saveToFile(String fileName) {
 if (!fileName.endsWith(".txt")) {
     fileName += ".txt"; // Thêm đuôi .txt nếu chưa có
 }

 try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
     Link current = first;
     while (current != null) {
         writer.write(current.getMaSV() + "," + current.getHoTen() + "," + current.getDiem() + "," 
                 + current.getKq() + "," + current.getXl());
         writer.newLine();
         current = current.nextLink;
     }
     System.out.println("Dữ liệu đã được lưu vào file " + fileName);
 } catch (IOException e) {
     System.out.println("Lỗi khi lưu file: " + e.getMessage());
 }
}








}






























