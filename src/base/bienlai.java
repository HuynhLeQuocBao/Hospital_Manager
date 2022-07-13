package base;

public class bienlai {
	private int soBienLai;
	private String ngayThanhToan;
	private double tongTien;
	private int tienCP;
	private int maNV;
	private String maCP;
	private int maBN;
	
	public bienlai() {
		
	}
	public bienlai(int soBienLai, String ngayThanhToan, double tongTien, int tienCP, int maNV, String maCP, int maBN) {
		this.soBienLai = soBienLai;
		this.ngayThanhToan = ngayThanhToan;
		this.tongTien = tongTien;
		this.tienCP = tienCP;
		this.maNV = maNV;
		this.maCP = maCP;
		this.maBN = maBN;
	}
	
	public bienlai(int soBienLai, String ngayThanhToan, double tongTien, int maNV, int maBN) {
		this.soBienLai = soBienLai;
		this.ngayThanhToan = ngayThanhToan;
		this.tongTien = tongTien;

		this.maNV = maNV;

		this.maBN = maBN;
	}
	
	
	public int getSoBienLai() {
		return soBienLai;
	}
	public void setSoBienLai(int soBienLai) {
		this.soBienLai = soBienLai;
	}
	public String getNgayThanhToan() {
		return ngayThanhToan;
	}
	public void setNgayThanhToan(String ngayThanhToan) {
		this.ngayThanhToan = ngayThanhToan;
	}
	public double getTongTien() {
		return tongTien;
	}
	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
	public int getTienCP() {
		return tienCP;
	}
	public void setTienCP(int tienCP) {
		this.tienCP = tienCP;
	}
	public int getMaNV() {
		return maNV;
	}
	public void setMaNV(int maNV) {
		this.maNV = maNV;
	}
	
	public int getMaBN() {
		return maBN;
	}
	public void setMaBN(int maBN) {
		this.maBN = maBN;
	}
	public String getMaCP() {
		return maCP;
	}
	public void setMaCP(String maCP) {
		this.maCP = maCP;
	}
	
}
