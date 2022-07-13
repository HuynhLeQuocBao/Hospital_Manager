package BLL;

import java.text.ParseException;
import java.util.*;

import javax.swing.JOptionPane;

import base.benhNhan_DichVu;
import base.bienlai;
import DAL.benhNhan_DichVuDAL;
import DAL.bienlaiDAL;

public class benhNhan_DichVuBLL {
	benhNhan_DichVuDAL blDAL = new benhNhan_DichVuDAL();
	
	public List<benhNhan_DichVu> getAllBill() {
		return blDAL.findAll();
	}
	
	public String addPhieu(benhNhan_DichVu p) {
		if(blDAL.hasBenhNhanDichVu(p)) {
			return "Số của phiếu này đã bị trùng. Vui lòng thử lại";
		}
		if(blDAL.insert(p)) {
			return "Thêm phiếu thành công";
		}
		return "Thêm phiếu không thành công";
	}
	
	public String deletePhieu(int id) {
		if(blDAL.delete(id)) {
			JOptionPane.showMessageDialog(null, id);
			return "Xóa phiếu thành công";
		}
		return "Xóa phiếu không thành công";
	}
	
	public String editPhieu(benhNhan_DichVu p) {
//		if(!blDAL.hasEmployee(p)) {
//			return "Mã nhân viên này không tồn tại. Vui lòng kiểm tra lại";
//		}
		if(blDAL.update(p)) {
			return "Sửa phiếu thành công";
		}
		return "Sửa phiếu không thành công";
	}
	
	
	public List<benhNhan_DichVu> searchBienLaiByCode(int maBenhNhan) {
		return blDAL.findById(maBenhNhan);
	}
	
	public List<benhNhan_DichVu> baoCao() throws ParseException {
		return blDAL.baoCao();
	}
}
