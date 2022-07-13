package BLL;

import java.util.*;
import DAL.accountDAL;
import base.account;

public class accountBLL {
	accountDAL accDAL = new accountDAL();
	
	public List<account> getAllAccount() {
		return accDAL.findAll();
	}
	
	public String addAccount(account p) {
		if(accDAL.hasAccountCode(p.getId())) {
			return "Mã tài khoản này đã tồn tại. Vui lòng thử lại";
		}
		if(accDAL.insert(p)) {
			return "Thêm tài khoản thành công";
		}
		return "Thêm tài khoản không thành công";
	}
	
	public String deleteAccount(String id) {
		if(accDAL.delete(id)) {
			return "Xóa tài khoản thành công";
		}
		return "Xóa tài khoản không thành công";
	}
	
	public String editAccount(account p) {
		if(accDAL.update(p)) {
			return "Sửa tài khoản thành công";
		}
		return "Sửa tài khoản không thành công";
	}
	
	public int getId(String accountName) {
		return accDAL.code(accountName);
	}
	
	public String getPermission(int code) {
		return accDAL.getPermission(code);
	}
	
	public List<account> searchAccountByName(String accountName) {
		return accDAL.findByFullName(accountName);
	}
	
	public int getCode(String table, String dataToGet, String name, String col) {
		return accDAL.getCode(table, dataToGet, name, col);
	}
	
	public int getAccountCode() {
		return accDAL.getAccountId();
	}
}
