package base;
import java.io.*;

public class account{
	private int id;
	private String accountName;
	private String password;
	private String permission;
	//private String customerCode;
		// TODO Auto-generated constructor stub

	// contrustor 
	// nhập
	
	public account() {
		accountName = null;
		password = null;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	//set cứng 
	public account(int id, String accountName, String password, String permission) {
		setId(id);
		setAccountName(accountName);
		setPassword(password);
		setPermission(permission);
	}
	
	public void xuat(){
	    System.out.format("|%8s         |", accountName);
	    System.out.format("%14s         |", password );
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
