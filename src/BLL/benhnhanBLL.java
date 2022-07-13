package BLL;

import java.util.*;
import DAL.benhnhanDAL;
import base.*;

public class benhnhanBLL {
	benhnhanDAL bnDAL = new benhnhanDAL();
	
	public List<benhnhan> getAllbenhnhan() {
		return bnDAL.findAll();
	}
	
	public String addbenhnhan(benhnhan p) {
		if(bnDAL.hasbenh_nhanCode(p.getMabn())) {
			return "Mã bệnh nhân này đã tồn tại. Vui lòng thử lại";
		}
		if(bnDAL.insert(p)) {
			return "Thêm bệnh nhân thành công";
		}
		return "Thêm bệnh nhân không thành công";
	}
	
	public String deletebenhnhan(int id) {
		if(bnDAL.delete(id)) {
			return "Xóa bệnh nhân thành công";
		}
		return "Xóa bệnh nhân không thành công";
	}
	
	public String editbenhnhan(benhnhan p) {
		if(bnDAL.update(p)) {
			return "Sửa bệnh nhân thành công";
		}
		return "Sửa bệnh nhân không thành công";
	}
	
	
	public List<benhnhan> searchbenhnhanByName(String benhnhanName) {
		return bnDAL.findByFullName(benhnhanName);
	}
	
	public List<String> getBenhnhanList() {
		return bnDAL.getbenh_nhanList();
	}

}
