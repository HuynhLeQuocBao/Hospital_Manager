package DAL;

import java.sql.*;
import java.util.*;
import java.util.logging.*;

import javax.swing.JOptionPane;

import base.*;

// chưa tối ưu hóa code ở đây
public class accountDAL {
	
	private Connection connection; 
	public accountDAL() {
		
	}
//	List<bac_si> bac_siList = new ArrayList<bac_si>();
	// lấy tất cả oke 
	public List<account> findAll() {
		List<account> accountList = new ArrayList<account>();
		
		if(openConnection()) {
			try {
	            //query
	            String sql = "select * from account";
	            Statement statement = connection.createStatement();
	            
	            ResultSet resultSet = statement.executeQuery(sql);
	           
	            while (resultSet.next()) {                
	            	account std = new account(resultSet.getInt("ID"), 
	                        resultSet.getString("ACCOUNT_NAME"), resultSet.getString("PASS"), 
	                        resultSet.getString("PERMISSION"));
	            	accountList.add(std);
	            }
	        } catch(SQLException e) {
	        	System.out.println(e);
	        }
			finally {
				closeConnection();
			}
		}
		return accountList;
	}
	
	public boolean insert(account p) {
		boolean result = false;
		if(openConnection()) {
			try {
	            //query
	            String sql = "insert into account(ID, ACCOUNT_NAME, PASS, PERMISSION) values (?, ?, ?, ?)";
	            PreparedStatement statement = connection.prepareCall(sql);
	            
	            statement.setInt(1, p.getId());
	            statement.setString(2, p.getAccountName());
	            statement.setString(3, p.getPassword());
	            statement.setString(4, p.getPermission());
	            
	            if(statement.executeUpdate()>=1) {
	            	result = true;
	            }
	        } catch (SQLException e) {
	        	System.out.println(e);
	        }
			finally {
				closeConnection();
			}
		}
		return result;
	}
	
	 // sửa oke
	public boolean update(account p) {
		boolean result = false;
		if(openConnection()) {
			try {
	            //query
				String sql = "update account set PASS=?, PERMISSION=? where ACCOUNT_NAME=?";
	            PreparedStatement statement = connection.prepareCall(sql);
	            
	            statement.setString(1, p.getPassword());
	            statement.setString(2, p.getPermission());
	            statement.setString(3, p.getAccountName());
	            
	            if(statement.executeUpdate()>=1) {
	            	result = true;
	            }
	        } catch (SQLException e) {
	        	System.out.println(e);
	        }
			finally {
				closeConnection();
			}
		}
		return result;
	}
	public boolean delete(String id) {
		boolean result = false;
		if(openConnection()) {
			try {
	            //query
				String sql = "delete from account where ACCOUNT_NAME = ?";
	            PreparedStatement statement = connection.prepareCall(sql);
	            
	            statement.setString(1, id);
	            
	            if(statement.executeUpdate()>=1) {
	            	result = true;
	            }
	        } catch (SQLException e) {
	        	System.out.println(e);
	        }
			finally {
				closeConnection();
			}
		}
		return result;
	}
	public List<account> findByFullName(String acccountName) {
		List<account> accountList = new ArrayList<account>();
		
		if(openConnection()) {
			try {
	            //query
	            String sql = "select * from account where ACCOUNT_NAME like ?";
	            PreparedStatement statement = connection.prepareCall(sql);
	            statement.setString(1, "%"+acccountName+"%");
	            
	            ResultSet resultSet = statement.executeQuery();
	            
	            while (resultSet.next()) {                
	            	account std = new account(resultSet.getInt("ID"), 
	                        resultSet.getString("ACCOUNT_NAME"), resultSet.getString("PASS"), 
	                        resultSet.getString("PERMISSION"));
	            	accountList.add(std);
	            }
	        } catch(SQLException e) {
	        	System.out.println(e);
	        }
			finally {
				closeConnection();
			}
		}
		return accountList;
	}
	 // check trùng mã sản phẩm
	 public boolean hasAccountCode(int code) {
		 boolean result = false;
		 
		 if(openConnection()) {
				try {
		            //query
		            String sql = "select * from account where ID=" + code;
		            Statement statement = connection.createStatement();
		            
		            ResultSet resultSet = statement.executeQuery(sql);
		           
		            result = resultSet.next();
		        } catch(SQLException e) {
		        	System.out.println(e);
		        }
				finally {
					closeConnection();
				}
			}
		 
		 return result;
	 }
	 
	 public int code(String accountName) {
		 int code = -1;
		 if(openConnection()) {
				try {
		            //query
		            String sql = "select ID from account where ACCOUNT_NAME = '"+accountName+"' ";
		            Statement statement = connection.createStatement();
		            
		            ResultSet resultSet = statement.executeQuery(sql);
		           
		            while (resultSet.next()) {                
		            	code = resultSet.getInt("ID");
		            }
		        } catch(SQLException e) {
		        	System.out.println(e);
		        }
				finally {
					closeConnection();
				}
			}
		 return code;
	 }
	 
	 public String getPermission(int code) {
		 String permission = "";
		 if(openConnection()) {
				try {
		            //query
		            String sql = "select PERMISSION from account where ID =" + code;
		            Statement statement = connection.createStatement();
		            
		            ResultSet resultSet = statement.executeQuery(sql);
		           
		            while (resultSet.next()) {                
		            	permission = resultSet.getString("PERMISSION");
		            }
		        } catch(SQLException e) {
		        	System.out.println(e);
		        }
				finally {
					closeConnection();
				}
			}
		 return permission;
	 }
	 // hàm kết nối và đóng csdl 
	 public boolean openConnection() {
		 try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pttkhttt?useSSL=false", "root", "");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	 }
	 
	 public void closeConnection() {
		 try {
			 if(connection!=null) {
				 connection.close();
			 } 
		 } catch(SQLException e) {
			 System.out.println(e);
		 }
	 }
	 
	 public int getCode(String table, String dataToGet, String name, String col) {
			int data = -1;
			if(openConnection()) {
				try {
		            //query
		            String sql = "select " + dataToGet + " from " + table + " where " + col + " =  "+name+" " ;
		            Statement statement = connection.createStatement();
		            
		            ResultSet resultSet = statement.executeQuery(sql);
		           
		            while (resultSet.next()) {                
		            	data = resultSet.getInt(dataToGet);
		            }
		        } catch(SQLException e) {
		        	System.out.println(e);
		        }
				finally {
					closeConnection();
				}
			}
			
			return data;
		}
	 
	 public int getAccountId() {
			int accountId = -1;
			
			if(openConnection()) {
				try {
		            //query
		            String sql = "select MAX(ID) from account";
		            PreparedStatement statement = connection.prepareCall(sql);
		            
		            ResultSet resultSet = statement.executeQuery();
		            
		            while (resultSet.next()) {                
		            	accountId = resultSet.getInt("MAX(ID)") + 1; 
		            }
		        } catch(SQLException e) {
		        	System.out.println(e);
		        }
				finally {
					closeConnection();
				}
			}
			return accountId;
		}
	 
}
