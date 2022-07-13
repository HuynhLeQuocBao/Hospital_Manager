package base;
import Dungchung.*;
public class bacsi extends benhnhan {

	private int maTK;
	private int mabs;
	private String tenbs;
	private String dienthoai;
	private String diachi;
	private String gioitinh;
	private String ngaysinh;
	
	
	
	public int getMabs() {
		return mabs;
	}



	public void setMabs(int mabs) {
		this.mabs = mabs;
	}



	public String getTenbs() {
		return tenbs;
	}



	public void setTenbs(String tenbs) {
		this.tenbs = tenbs;
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


	public String getDienthoai() {
		return dienthoai;
	}



	public void setDienthoai(String dienthoai) {
		this.dienthoai = dienthoai;
	}



	public bacsi(int maTK, int mabs, String tenbs, String dienthoai, String diachi, String gioitinh, String ngaysinh) {
		super();
		this.maTK = maTK;
		this.mabs = mabs;
		this.tenbs = tenbs;
		this.dienthoai = dienthoai;
		this.diachi = diachi;
		this.gioitinh = gioitinh;
		this.ngaysinh = ngaysinh;
	}



	public int getMaTK() {
		return maTK;
	}



	public void setMaTK(int maTK) {
		this.maTK = maTK;
	}



	public bacsi() {
		super();

	}


}
