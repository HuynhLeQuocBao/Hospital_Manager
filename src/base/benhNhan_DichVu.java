package base;

public class benhNhan_DichVu {
	private int sphieuSD;
	private int maBN;
	private String ngaySD;
	private int soluongDV;
	private int maDV;
	
	public benhNhan_DichVu(int sphieuSD, int maBN, String ngaySD, int soluongDV, int maDV) {
		this.sphieuSD = sphieuSD;
		this.maBN = maBN;
		this.ngaySD = ngaySD;
		this.soluongDV = soluongDV;
		this.maDV = maDV;
	}
	
	public benhNhan_DichVu(String ngaySD) {
		this.ngaySD = ngaySD;
	}
	
	public int getSphieuSD() {
		return sphieuSD;
	}
	public void setSphieuSD(int sphieuSD) {
		this.sphieuSD = sphieuSD;
	}
	public int getMaBN() {
		return maBN;
	}
	public void setMaBN(int maBN) {
		this.maBN = maBN;
	}
	public String getNgaySD() {
		return ngaySD;
	}
	public void setNgaySD(String ngaySD) {
		this.ngaySD = ngaySD;
	}
	public int getSoluongDV() {
		return soluongDV;
	}
	public void setSoluongDV(int soluongDV) {
		this.soluongDV = soluongDV;
	}
	public int getMaDV() {
		return maDV;
	}
	public void setMaDV(int maDV) {
		this.maDV = maDV;
	}
}
