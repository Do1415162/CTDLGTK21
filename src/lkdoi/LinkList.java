package lkdoi;
import java.util.Scanner;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;







public class LinkList {
    public DoubleLink first, last;
	private DoubleLink head;

    public LinkList() {
        first = null; 
        last = null;
    }

    // Insert a new node into the linked list
    public void insert(String maSV, String hoTen, double diem) {
        DoubleLink nut = new DoubleLink(maSV, hoTen, diem);
        if (first == null && last == null) {
            first = nut; 
            last = nut;
        } else {
            last.next = nut;
            nut.prev = last;
            last = nut;
        }
    }

    // Create the linked list by user input
    public void createList() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Nhập mã Sinh Viên: ");
            String maSV = sc.nextLine();
            
            if (maSV.length() == 0) {
                System.out.println("Rỗng");
                break;
            } else {
                System.out.print("Nhập họ tên: ");
                String hoTen = sc.nextLine();
                System.out.print("Nhập điểm: ");
                double diem = sc.nextDouble();
                sc.nextLine();  

                insert(maSV, hoTen, diem);  
            }
        }
    }

   
    public void printList() {
        DoubleLink p = first;
        while (p != null) {
            System.out.println(p.getMaSV() + " - " + p.getHoTen() + " - " + p.getDiem() + " - " + p.getXl() + " - " + p.getKq());
            p = p.next;
        }
    }

  
    public void printList2() {
        DoubleLink p = last;
        while (p != null) {
            System.out.println(p.getMaSV() + " - " + p.getHoTen() + " - " + p.getDiem() + " - " + p.getXl() + " - " + p.getKq());
            p = p.prev;
        }
    }

    public DoubleLink  search(String maSV)
    {DoubleLink p=first;
    while ((p!=null)&&(p.getMaSV().equals(maSV)!=true ))
    {
    	p=p.next;
    }
    return(p);
    
    }
    

  public void delete(String maSV)
  {
	  DoubleLink p= search(maSV);
	  if(p!=null)
	  {
		  if ((first==last)&& (last==p)) {first=null; last=null;}
		  if(p==first) {first=first.next;}
		  else if (p==last) { last=last.prev; last.next=null;}
		  else {
			  DoubleLink u, q=p.next; u=p.prev;
			
			  u.next=q;q.prev=u;
			  
		  }
	  
		  
	  }
  }

  public void xl() {
	    DoubleLink p = first;
	    while (p != null) {
	        double diem = p.getDiem();
	        String xl;
	        if (diem >= 9.0) {
	            xl = "Xuất sắc";
	        } else if (diem >= 8.0) {
	            xl = "Giỏi";
	        } else if (diem >= 6.5) {
	            xl = "Khá";
	        } else if (diem >= 5.0) {
	            xl = "Trung bình";
	        } else {
	            xl = "Yếu";
	        }
	        p.setXl(xl); 
	        p = p.next;
	    }
	}

	public void kq() {
	    DoubleLink p = first;
	    while (p != null) {
	        double diem = p.getDiem();
	        String kq = (diem >= 5.0) ? "Đạt" : "Không đạt";
	        p.setKq(kq); 
	        p = p.next;
	    }
	}


  public void thongKeXepLoai() {
	    int gioi = 0, kha = 0, trungBinh = 0, yeu = 0;
	    DoubleLink p = first;

	    while (p != null) {
	        double diem = p.getDiem();
	        if (diem >= 9.0) {
	            gioi++;
	        } else if (diem >= 8.0) {
	            kha++;
	        } else if (diem >= 6.5) {
	            trungBinh++;
	        } else {
	            yeu++;
	        }
	        p = p.next;
	    }

	    System.out.println("Thống kê sinh viên theo xếp loại:");
	    System.out.println("Giỏi: " + gioi);
	    System.out.println("Khá: " + kha);
	    System.out.println("Trung bình: " + trungBinh);
	    System.out.println("Yếu: " + yeu);
	}
  public DoubleLink findMaxScore() {
	    if (first == null) {
	        return null; 
	    }

	    DoubleLink maxNode = first; 
	    DoubleLink current = first.next;

	    while (current != null) {
	        if (current.getDiem() > maxNode.getDiem()) {
	            maxNode = current; 
	        }
	        current = current.next; 
	    }

	    return maxNode;
	}

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  public void saveToFile() {
	    String filePath = "D:\\lkdoi\\lkdoi.txt";
	    File file = new File(filePath);
	    if (!file.getParentFile().exists()) {
	        file.getParentFile().mkdirs();
	    }
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
	        DoubleLink p = first;
	        writer.write(String.format("%-10s %-20s %-6s %-10s %-6s\n", "MaSV", "Ho Ten", "Diem", "Xep Loai", "Ket Qua"));
	        writer.write("-------------------------------------------------------------\n");
	        while (p != null) {
	            writer.write(String.format("%-10s %-20s %-6.2f %-10s %-6s\n", p.getMaSV(), p.getHoTen(), p.getDiem(), p.getXl(), p.getKq()));
	            p = p.next;
	        }
	        System.out.println("Danh sách sinh viên đã được lưu vào file thành công.");
	    } catch (IOException e) {
	        System.out.println("Lỗi khi lưu file: " + e.getMessage());
	    }
	}

	public void exportToFile() {
	    String filePath = "D:\\lkdoi.txt";
	    File file = new File(filePath);
	    if (!file.getParentFile().exists()) {
	        file.getParentFile().mkdirs();
	    }
	    try {
	        FileWriter writer = new FileWriter(filePath);
	        for (DoubleLink node = this.head; node != null; node = node.next) {
	            writer.write(node.getMaSV() + "," + node.getHoTen() + "," + node.getDiem() + "," + node.getXl() + "," + node.getKq() + "\n");
	        }
	        writer.close();
	        System.out.println("Danh sách sinh viên đã được xuất ra file " + filePath);
	    } catch (IOException e) {
	        System.out.println("Lỗi khi xuất file: " + e.getMessage());
	    }
	}
}