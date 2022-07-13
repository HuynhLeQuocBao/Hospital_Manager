package BLL;

import java.util.*;
import DAL.*;
import base.*;

public class khamBenhBLL {
	khamBenhDAL khamBenhDAL = new khamBenhDAL();
	
	public List<khambenh> getAllkhamBenh() {
		return khamBenhDAL.findAll();
	}
	
	public String addkhamBenh(khambenh p) {
		if(khamBenhDAL.hasSophieukham(p.getSophieukham())) {
			return "Số phiếu khám này đã tồn tại. Vui lòng thử lại";
		}
		if(khamBenhDAL.insert(p)) {
			return "Thêm phiếu khám bệnh thành công";
		}
		return "Thêm phiếu khám bệnh không thành công";
	}
	
	public String deletekhambenh(int id) {
		if(khamBenhDAL.delete(id)) {
			return "Xóa bác sĩ thành công";
		}
		return "Xóa bác sĩ không thành công";
	}
	
	public String editkhambenh(khambenh p) {
		if(khamBenhDAL.update(p)) {
			return "Sửa thông tin phiếu khám bệnh thành công";
		}
		return "Sửa thông tin phiếu khám bệnh không thành công";
	}
	
	
	public List<khambenh> searchKhambenhs(int maBN) {
		return khamBenhDAL.findBysophieukham(maBN);
	}
	
	public List<String> getkhamBenhList() {
		return khamBenhDAL.getkhamBenhList();
	}
	public List<String> getbenhnhanList() {
		return khamBenhDAL.getbenhnhanList();
	}
	public List<String> getbacsiList() {
		return khamBenhDAL.getbacsiList();
	}
	public List<String> getMabenh() {
		return khamBenhDAL.getMabenh();
	}
	public int getData(String table, String dataToGet, String name, String col) {
		return khamBenhDAL.getData(table, dataToGet, name, col);
	}
	public String getData1(String table, String dataToGet, String name, String col) {
		return khamBenhDAL.getData1(table, dataToGet, name, col);
	}
}
