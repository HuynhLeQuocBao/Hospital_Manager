package base;
import Dungchung.*;
public class benhnhan extends person {

	private int mabn;
	private String tenbn;
	private String ngaysinh;
	private String diachi;
	private String gioitinh;
	private int sogiuong;
	private int sophong;
	
	
	
	public int getMabn() {
		return mabn;
	}



	public void setMabn(int mabn) {
		this.mabn = mabn;
	}



	public String getTenbn() {
		return tenbn;
	}



	public void setTenbn(String tenbn) {
		this.tenbn = tenbn;
	}



	public String getNgaysinh() {
		return ngaysinh;
	}



	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}



	public String getDiachi() {
		return diachi;
	}



	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}



	public String getGioitinh() {
		return gioitinh;
	}



	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}



	public int getSogiuong() {
		return sogiuong;
	}



	public void setSogiuong(int sogiuong) {
		this.sogiuong = sogiuong;
	}



	public int getSophong() {
		return sophong;
	}



	public void setSophong(int sophong) {
		this.sophong = sophong;
	}

	

	public benhnhan(int mabn, String tenbn, String ngaysinh, String diachi, String gioitinh, int sogiuong,
			int sophong) {
		super();
		this.mabn = mabn;
		this.tenbn = tenbn;
		this.ngaysinh = ngaysinh;
		this.diachi = diachi;
		this.gioitinh = gioitinh;
		this.sogiuong = sogiuong;
		this.sophong = sophong;
	}

	public benhnhan() {
		super();

	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}

}
