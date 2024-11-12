package dslkdonDao;
import java.io.Serializable;


public class Link implements Serializable {
	public String maSV;
	
	public String hoten;
	public double diem;
	public String kq, xl;
	public Link nextLink;
	
	public String getMaSV() {
		return maSV;
	}
	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
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
	public Link(String maSV, String hoten, double diem) {
		super();
		this.maSV=maSV;
		this.hoten = hoten;
		this.diem = diem;
		this.nextLink=null;
	}
	public Link() {
		super();
	}
		
	 
}
