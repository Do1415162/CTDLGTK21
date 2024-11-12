package Cây;

import java.util.Scanner;

public class Main {

    public Node root;

    public Main () {
        root = null;
    }

    public Node insertNode(Node root, String maSV, String ht, double diem) {
        if (root == null) {
            root = new Node(maSV, ht, diem);
            return root;
        }

        if (root.getMaSV().compareTo(maSV) > 0)
            root.left = insertNode(root.left, maSV, ht, diem);
        else if (root.getMaSV().compareTo(maSV) < 0)
            root.right = insertNode(root.right, maSV, ht, diem);

        return root;
    }

    public void create() {
        boolean ok = true;
        Scanner scanner = new Scanner(System.in);

        while (ok) {
            String maSV = "";
            System.out.print("Nhập mã sinh viên: ");
            maSV = scanner.nextLine();

            if (maSV.length() == 0) {
                ok = false;
                break;
            } else {
                System.out.print("Nhập họ tên: ");
                String hoten = scanner.nextLine();

                System.out.print("Nhập điểm: ");
                double diem = scanner.nextDouble();
                scanner.nextLine(); // Consume newline

                root = insertNode(root, maSV, hoten, diem);
            }
        }
    }

    public void tgp(Node root) {
        if (root != null) {
            tgp(root.left);
            System.out.println("Mã SV: " + root.getMaSV() + ", Họ tên: " + root.getHoTen() + ", Điểm: " + root.getDiem());
            tgp(root.right);
        }
    }

    public void duyetIf(Node root) {
        if (root != null) {
            if (root.getDiem() > 5)
                System.out.println("Mã SV: " + root.getMaSV() + ", Họ tên: " + root.getHoTen() + ", Điểm: " + root.getDiem());

            duyetIf(root.left);
            duyetIf(root.right);
        }
    }

    public void printIf() {
        duyetIf(root);
    }

    public void search(Node root, String maSV) {
        Node p = root;
        while (p != null) {
            if (p.getMaSV().compareTo(maSV) > 0)
                p = p.left;
            else if (p.getMaSV().compareTo(maSV) < 0)
                p = p.right;
            else {
                System.out.println("Có xuất hiện: Mã SV: " + p.getMaSV() + ", Họ tên: " + p.getHoTen() + ", Điểm: " + p.getDiem());
                return;
            }
        }
        System.out.println("Không xuất hiện");
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- MENU  CÂY ---");
            System.out.println("1. Nhập sinh viên");
            System.out.println("2. In danh sách sinh viên");
            System.out.println("3. In sinh viên có điểm > 5");
            System.out.println("4. Tìm kiếm sinh viên theo mã SV");
            System.out.println("5. Tìm sinh viên có điểm cao nhất");
            System.out.println("6. Xóa sinh viên theo mã SV");
            System.out.println("7. Lưu dữ liệu ra file");
            System.out.println("8. Thoát");

            System.out.print("Chọn một tùy chọn: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    tree.creat();
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
                    running = false; // Sửa biến để thoát vòng lặp
                    break;
                default:
                    System.out.println("Tùy chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
        scanner.close();
        System.out.println("Chương trình đã kết thúc."); // Thông báo kết thúc chương trình
    }
}














