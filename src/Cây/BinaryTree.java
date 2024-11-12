package Cây;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BinaryTree {

	public Node root;
	
	
	public BinaryTree () {
		root = null;
	} 
	
	public Node insertNode(Node root , String maSV , String ht , double diem) {
		
		if (root == null) {
			root = new Node (maSV , ht , diem);
			return root;
		}
		
		
		
		
		if (root.getMaSV().compareTo(maSV) > 0) 
			root.left = insertNode(root.left, maSV , ht , diem);
		else if (root.getMaSV().compareTo(maSV) < 0 )
			root.right = insertNode(root.right , maSV , ht , diem);
		
		
		return root;
	} 
	
	public void creat()  {
		
		boolean ok;
		
		Scanner scanner = new Scanner(System.in);
		
		while (ok=true) {
			
			String maSV="";
			
			
			System.out.print("nhap ma sinh vien : ");
			maSV = scanner.nextLine();
			
			
			if (maSV.length()==0) {
				
				ok = false ; 
				break; 
			} 
			
			else {
				System.out.print("nhap ho ten :");
				
				String hoten = scanner.nextLine();
				
				System.out.println("nhap diem");
				float diem = scanner.nextFloat();
				scanner.nextLine();
				root=insertNode(root , maSV , hoten , diem);
			
			
			}
		}
	}
	
	public void tgp (Node root) {
		if (root !=null) {
		tgp(root.left);
		
		System.out.println("Ma SV la :" + root.getMaSV()+ "ho ten la :" + root.getHoTen() + "diem la :" + root.getDiem());
		tgp(root.right); 
		
		}
	}
	
	public void duyetIf (Node root) {
		if (root != null) {
			if(root.getDiem()>5) 
				System.out.println("Ma SV la :" + root.getMaSV()+ "ho ten la :" + root.getHoTen() + "diem la :" + root.getDiem());
			
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






	// Phương thức để lưu danh sách sinh viên vào file
    public void saveToFile(String fileName) {
        if (!fileName.endsWith(".txt")) {
            fileName += ".txt"; // Thêm đuôi .txt nếu chưa có
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // Ghi dữ liệu từ cây vào tệp
            saveNode(writer, root);
            System.out.println("Dữ liệu đã được lưu vào file " + fileName);
        } catch (IOException e) {
            System.out.println("Lỗi khi lưu file: " + e.getMessage());
        }
    }

    // Phương thức hỗ trợ để lưu từng nút trong cây
    private void saveNode(BufferedWriter writer, Node node) throws IOException {
        if (node != null) {
            // Ghi thông tin của nút hiện tại vào tệp
            writer.write(node.getMaSV() + "," + node.getHoTen() + "," + node.getDiem());
            writer.newLine(); // Xuống dòng
            // Đệ quy ghi các nút bên trái và bên phải
            saveNode(writer, node.left);
            saveNode(writer, node.right);
        }
    }

    // Các phương thức khác của lớp BinaryTree...





 // Phương thức để tìm sinh viên có điểm cao nhất
    public void findHighestScore() {
        if (root == null) {
            System.out.println("Cây rỗng. Không có sinh viên nào.");
            return;
        }

        Node highestScoreNode = findHighestScoreNode(root);
        System.out.println("Sinh viên có điểm cao nhất: ");
        System.out.println("Mã SV: " + highestScoreNode.getMaSV() + 
                           ", Họ tên: " + highestScoreNode.getHoTen() + 
                           ", Điểm: " + highestScoreNode.getDiem());
    }

    // Phương thức hỗ trợ để tìm sinh viên có điểm cao nhất
    private Node findHighestScoreNode(Node root) {
        Node highest = root;

        if (root.left != null) {
            Node leftHighest = findHighestScoreNode(root.left);
            if (leftHighest.getDiem() > highest.getDiem()) {
                highest = leftHighest;
            }
        }

        if (root.right != null) {
            Node rightHighest = findHighestScoreNode(root.right);
            if (rightHighest.getDiem() > highest.getDiem()) {
                highest = rightHighest;
            }
        }

        return highest;
    }






 // Đổi phương thức xóa thành public
    public Node deleteNode(Node root, String maSV) {
        // Nếu cây rỗng, không tìm thấy sinh viên
        if (root == null) {
            System.out.println("Không tìm thấy sinh viên với mã SV: " + maSV);
            return root;
        }

        // Tìm vị trí sinh viên cần xóa
        if (root.getMaSV().compareTo(maSV) > 0) {
            root.left = deleteNode(root.left, maSV); // Tìm trong cây con bên trái
        } else if (root.getMaSV().compareTo(maSV) < 0) {
            root.right = deleteNode(root.right, maSV); // Tìm trong cây con bên phải
        } else {
            // Nút này là sinh viên cần xóa
            System.out.println("Đã xóa: Mã SV: " + root.getMaSV() + ", Họ tên: " + root.getHoTen() + ", Điểm: " + root.getDiem());

            // Nếu nút chỉ có một con hoặc không có con
            if (root.left == null) {
                return root.right; // Thay thế bằng cây con bên phải
            } else if (root.right == null) {
                return root.left; // Thay thế bằng cây con bên trái
            }

            // Nút có hai con: Tìm giá trị nhỏ nhất trong cây con bên phải
           
         // Nút có hai con: Tìm giá trị nhỏ nhất trong cây con bên phải
            String minValue = findMinValue(root.right); // Sử dụng findMinValue để lấy mã SV nhỏ nhất
            root.setMaSV(minValue); // Thay thế mã SV của nút hiện tại bằng mã SV nhỏ nhất
            // Xóa nút chứa giá trị nhỏ nhất
            root.right = deleteNode(root.right, minValue); 
        }

        return root; // Trả về nút gốc đã được thay thế
    }

private String findMinValue(Node right) {
	// TODO Auto-generated method stub
	return null;
}
}













	
	
	
	
