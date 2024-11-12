package Cây;

public class Node {
      private String maSV;
      private String hoTen;
      private double diem;
      private String kq,xl;
      public Node left, right;
      
      public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public double getDiem() {
		return diem;
	}

	public void setDiem(double diem) {
		this.diem = diem;
	}

	public String getKq() {
		return kq;
	}

	public void setKq(String kq) {
		this.kq = kq;
	}

	public String getXl() {
		return xl;
	}

	public void setXl(String xl) {
		this.xl = xl;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public Node(String maSV, String hoTen, double diem ) {
    	  super();
    	  this.maSV = maSV;
    	  this.hoTen = hoTen;
    	  this.diem = diem;
    	  this.left = null;
    	  this.right =null;
    	  
      }
      
}
