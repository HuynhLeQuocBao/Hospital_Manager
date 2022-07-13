package BLL;

import java.util.*;
import DAL.bacsiDAL;
import base.*;

public class bacsiBLL {
	bacsiDAL bsDAL = new bacsiDAL();
	
	public List<bacsi> getAllbacsi() {
		return bsDAL.findAll();
	}
	
	public String addbacsi(bacsi p) {
		if(bsDAL.hasbac_siCode(p.getMabs())) {
			return "Mã bác sĩ này đã tồn tại. Vui lòng thử lại";
		}
		if(bsDAL.insert(p)) {
			return "Thêm bác sĩ thành công";
		}
		return "Thêm bác sĩ không thành công";
	}
	
	public String deletebacsi(int id) {
		if(bsDAL.delete(id)) {
			return "Xóa bác sĩ thành công";
		}
		return "Xóa bác sĩ không thành công";
	}
	
	public String editbacsi(bacsi p) {
		if(bsDAL.update(p)) {
			return "Sửa bác sĩ thành công";
		}
		return "Sửa bác sĩ không thành công";
	}
	
	
	public List<bacsi> searchbacsiByName(String bacsiName) {
		return bsDAL.findByFullName(bacsiName);
	}
	
	public List<String> getbacsiList() {
		return bsDAL.getbac_siList();
	}

}
