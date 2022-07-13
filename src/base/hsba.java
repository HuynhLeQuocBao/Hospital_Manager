package base;
import base.bacsi;
public class hsba {
	private int mahs;
	private String ngaybd;
	private String ngaykt;
	private String ketqua;
	private double chiphi;
	private int mabn;
	private int mabs;
	public hsba(int mahs, String ngaybd, String ngaykt, String ketqua, int mabs, int mabn) {
		super();
		this.mahs = mahs;
		this.ngaybd = ngaybd;
		this.ngaykt = ngaykt;
		this.ketqua = ketqua;
		this.mabs = mabs;
		this.mabn = mabn;
	}
	
	public hsba() {
		super();
	}

	public int getMahs() {
		return mahs;
	}
	public void setMahs(int mahs) {
		this.mahs = mahs;
	}
	public String getNgaybd() {
		return ngaybd;
	}
	public void setNgaybd(String ngaybd) {
		this.ngaybd = ngaybd;
	}
	public String getNgaykt() {
		return ngaykt;
	}
	public void setNgaykt(String ngaykt) {
		this.ngaykt = ngaykt;
	}
	public String getKetqua() {
		return ketqua;
	}
	public void setKetqua(String ketqua) {
		this.ketqua = ketqua;
	}
	public double getChiphi() {
		return chiphi;
	}
	public void setChiphi(double chiphi) {
		this.chiphi = chiphi;
	}
	public int getTenbn() {
		return mabn;
	}
	public void setTenbn(int tenbn) {
		this.mabn = tenbn;
	}
	public int getTenbs() {
		return mabs;
	}
	public void setTenbs(int tenbs) {
		this.mabs = tenbs;
	}


	
}
