	package lkdoi;
	

	public class DoubleLink {
		private String maSV;
		private String hoTen;
		private double diem;
		private String kq, xl;
		public DoubleLink next, prev;
		
		public DoubleLink() {
			super();
		}

		public DoubleLink(String maSV, String hoTen, double diem) {
			super();
			this.maSV = maSV;
			this.hoTen = hoTen;
			this.diem = diem;
			this.next = null;
			this.prev = null;
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
		
		public DoubleLink getNext() {
			return next;
		}
		
		public void setNext(DoubleLink next) {
			this.next = next;
		}
		
		public DoubleLink getPrev() {
			return prev;
		}
		
		public void setPrev(DoubleLink prev) {
			this.prev = prev;
		}
		
		
	}