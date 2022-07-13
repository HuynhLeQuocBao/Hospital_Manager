package BLL;

import java.util.*;

import DAL.DALDichvu;
import DAL.bacsiDAL;
import base.*;

public class dichvuBLL {
	DALDichvu bsDAL = new DALDichvu();
	
	public List<dichvu> getAllbacsi() {
		return bsDAL.findAll();
	}
	
	public String addbacsi(dichvu p) {
//		if(bsDAL.hasbac_siCode(p.getMaDV())) {
//			return "Mã bác sĩ này đã tồn tại. Vui lòng thử lại";
//		}
		if(bsDAL.insert(p)) {
			return "Thêm bác sĩ thành công";
		}
		return "Thêm bác sĩ không thành công";
	}
	
	public String deletebacsi(dichvu d) {
		if(bsDAL.delete(d.getMaDV())) {
			return "Xóa bác sĩ thành công";
		}
		return "Xóa bác sĩ không thành công";
	}
	
	public String editbacsi(dichvu p) {
		if(bsDAL.update(p)) {
			return "Sửa dịch vụ thành công";
		}
		return "Sửa dịch vụ không thành công";
	}
	
	
//	public List<bacsi> searchbacsiByName(String bacsiName) {
//		return bsDAL.findByFullName(bacsiName);
//	}
	
	public List<String> getdichvuList() {
		return bsDAL.getdichVuList();
	}

}
