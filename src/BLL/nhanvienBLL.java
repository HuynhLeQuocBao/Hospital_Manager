package BLL;

import java.util.*;
import DAL.nhanvienDAL;
import base.*;

public class nhanvienBLL {
	nhanvienDAL nvDAL = new nhanvienDAL();
	
	public List<nhanvien> getAllnhanvien() {
		return nvDAL.findAll();
	}
	
	public String addnhanvien(nhanvien p) {
		if(nvDAL.hasnhanvienCode(p.getManv())) {
			return "Mã nhân viên này đã tồn tại. Vui lòng thử lại";
		}
		if(nvDAL.insert(p)) {
			return "Thêm nhân viên thành công";
		}
		return "Thêm nhân viên không thành công";
	}
	
	public String deletenhanvien(int id) {
		if(nvDAL.delete(id)) {
			return "Xóa nhân viên thành công";
		}
		return "Xóa nhân viên không thành công";
	}
	
	public String editnhanvien(nhanvien p) {
		if(nvDAL.update(p)) {
			return "Sửa nhân viên thành công";
		}
		return "Sửa nhân viên không thành công";
	}
	
	
	public List<nhanvien> searchnhanvienByName(String nhanvienName) {
		return nvDAL.findByFullName(nhanvienName);
	}
	
	public List<String> getnhanvienList() {
		return nvDAL.getnhanvienList();
	}

}
