package dslkd;

public class Link {
	
	private String maSV;
	private String hoTen;
	private double diem;
	private String kq, xl;
	public Link nextLink;
	
	public Link() {
		
	}
	
	public Link(String maSV, String hoTen, double diem) {
		this.maSV = maSV;
		this.hoTen = hoTen;
		this.diem = diem;
		this.kq ="";
        this.xl = "";
		this.nextLink = null;
	}

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

	
	
	
	
}
