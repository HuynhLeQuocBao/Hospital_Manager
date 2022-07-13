package BLL;

import java.util.*;

import javax.swing.JOptionPane;

import base.bienlai;
import DAL.benhnhanDAL;
import DAL.bienlaiDAL;
import DAL.nhanvienDAL;



public class bienlaiBLL {
	bienlaiDAL blDAL = new bienlaiDAL();
	nhanvienDAL nvDAL = new nhanvienDAL();
	benhnhanDAL bnDAL = new benhnhanDAL();
	
	public List<bienlai> getAllBill() {
		return blDAL.findAll();
	}
	
	public double getPrice(int maBn) {
		return blDAL.getPrice(maBn);
	}
	
	public String addBienlai(bienlai p) {
		if(blDAL.hasBienlai(p)) {
			return "Số biên lai này đã tồn tại. Vui lòng thử lại";
		}
		if(blDAL.insert(p)) {
			return "Thêm biên lai thành công";
		}
		return "Thêm biên lai không thành công";
	}
	
	public String deleteBienlai(int id) {
		if(blDAL.delete(id)) {
			JOptionPane.showMessageDialog(null, id);
			return "Xóa biên lai thành công";
		}
		return "Xóa biên lai không thành công";
	}
	
	public String editBienlai(bienlai p) {
//		if(!blDAL.hasEmployee(p)) {
//			return "Mã nhân viên này không tồn tại. Vui lòng kiểm tra lại";
//		}
		if(blDAL.update(p)) {
			return "Sửa biên lai thành công";
		}
		return "Sửa biên lai không thành công";
	}
	
	
	public List<bienlai> searchBienlaiByCode(int maBenhNhan) {
		return blDAL.findByFullName(maBenhNhan);
	}
	public List<String> getnhanvienList() {
		return nvDAL.getnhanvienList();
	}
	public List<String> getbenhnhanList() {
		return bnDAL.getbenh_nhanList();
	}
	
}
