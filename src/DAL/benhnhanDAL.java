package DAL;

import java.sql.*;
import java.util.*;
import java.util.logging.*;

import javax.swing.JOptionPane;

import base.*;

// chưa tối ưu hóa code ở đây
public class benhnhanDAL {
	
	private Connection connection; 
	public benhnhanDAL() {
		
	}
//	List<benh_nhan> benh_nhanList = new ArrayList<benh_nhan>();
	// lấy tất cả oke 
	public List<benhnhan> findAll() {
		List<benhnhan> benh_nhanList = new ArrayList<benhnhan>();
		
		if(openConnection()) {
			try {
	            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pttkhttt?useSSL=false", "root", "");
	            
	            //query
	            String sql = "select * from benh_nhan";
	            Statement statement = connection.createStatement();
	            
	            ResultSet resultSet = statement.executeQuery(sql);
	           
	            while (resultSet.next()) {                
	            	benhnhan std = new benhnhan(resultSet.getInt("MABN"), 
	                        resultSet.getString("TENBN"), resultSet.getString("NGAYSINH"), 
	                        resultSet.getString("DIACHI"),resultSet.getString("GIOITINH"),resultSet.getInt("SOGIUONG"),resultSet.getInt("SOPHONG"));
	            	benh_nhanList.add(std);
	            }
	        } catch(SQLException e) {
	        	System.out.println(e);
	        }
			finally {
				closeConnection();
			}
		}
		return benh_nhanList;
	}
	
	public boolean insert(benhnhan p) {
		boolean result = false;
		if(openConnection()) {
			try {
	            //query
	            String sql = "insert into benh_nhan(MABN, TENBN, NGAYSINH,DIACHI,GIOITINH,SOGIUONG,SOPHONG) values (?, ?, ?, ?,?,?,?)";
	            PreparedStatement statement = connection.prepareCall(sql);
	            
	            statement.setInt(1, p.getMabn());
	            statement.setString(2, p.getTenbn());
	            statement.setString(3, p.getNgaysinh());
	            statement.setString(4, p.getDiachi());
	            statement.setString(5, p.getGioitinh());
	            statement.setInt(6, p.getSogiuong());
	            statement.setInt(7, p.getSophong());
	            
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
	public boolean update(benhnhan p) {
		boolean result = false;
		if(openConnection()) {
			try {
	            //query
				String sql = "update benh_nhan set TENBN=?, NGAYSINH=?, DIACHI=?, GIOITINH=?, SOGIUONG=?, SOPHONG=? where MABN = ?";
	            PreparedStatement statement = connection.prepareCall(sql);
	            
	            statement.setString(1, p.getTenbn());
	            statement.setString(2, p.getNgaysinh());
	            statement.setString(3, p.getDiachi());
	            statement.setString(4, p.getGioitinh());
	            statement.setInt(5, p.getSogiuong());
	            statement.setInt(6, p.getSophong());
	            statement.setInt(7, p.getMabn());
	            
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
	public boolean delete(int id) {
		boolean result = false;
		if(openConnection()) {
			try {
	            //query
				String sql = "delete from benh_nhan where MABN = ?";
	            PreparedStatement statement = connection.prepareCall(sql);
	            
	            statement.setInt(1, id);
	            
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
	public List<benhnhan> findByFullName(String benh_nhanName) {
		List<benhnhan> benh_nhanList = new ArrayList<benhnhan>();
		
		if(openConnection()) {
			try {
	            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pttkhttt?useSSL=false", "root", "");
	            
	            //query
	            String sql = "select * from benh_nhan where TENBN like ?";
	            PreparedStatement statement = connection.prepareCall(sql);
	            statement.setString(1, "%"+benh_nhanName+"%");
	            
	            ResultSet resultSet = statement.executeQuery();
	            
	            while (resultSet.next()) {    
	            	benhnhan std = new benhnhan(resultSet.getInt("MABN"), 
	                        resultSet.getString("TENBN"), resultSet.getString("NGAYSINH"), 
	                        resultSet.getString("DIACHI"),resultSet.getString("GIOITINH"),resultSet.getInt("SOGIUONG"),resultSet.getInt("SOPHONG"));
	            	benh_nhanList.add(std);
	            }
	        } catch(SQLException e) {
	        	System.out.println(e);
	        }
			finally {
				closeConnection();
			}
		}
		return benh_nhanList;
	}
	public List<String> getbenh_nhanList() {
		List<String> benh_nhanList = new ArrayList<String>();
		
		if(openConnection()) {
			try {
	            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pttkhttt?useSSL=false", "root", "");
	            
	            //query
	            String sql = "select * from benh_nhan";
	            Statement statement = connection.createStatement();
	            
	            ResultSet resultSet = statement.executeQuery(sql);
	           
	            while (resultSet.next()) {                
	            	String std = resultSet.getString("TENBN");
	            	benh_nhanList.add(std);
	            }
	        } catch(SQLException e) {
	        	System.out.println(e);
	        }
			finally {
				closeConnection();
			}
		}
		return benh_nhanList;
	}
	 // check trùng mã sản phẩm
	 public boolean hasbenh_nhanCode(int benh_nhanCode) {
		 boolean result = false;
		 
		 if(openConnection()) {
				try {
		            //query
		            String sql = "select * from benh_nhan where MABN=" + benh_nhanCode;
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
	 public benhnhan getbenhnhan(int id) {
		 benhnhan std = null;
		 if(openConnection()) {
				try {
		            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pttkhttt?useSSL=false", "root", "");
		            
		            //query
		            String sql = "select * from benh_nhan where TENBN = ?" ;
		            PreparedStatement statement = connection.prepareCall(sql);
		            statement.setInt(1, id);
		            
		            ResultSet resultSet = statement.executeQuery();
		            
		            while (resultSet.next()) {    
		            	std = new benhnhan(resultSet.getInt("MABN"), 
		                        resultSet.getString("TENBN"), resultSet.getString("NGAYSINH"), 
		                        resultSet.getString("DIACHI"),resultSet.getString("GIOITINH"),resultSet.getInt("SOGIUONG"),resultSet.getInt("SOPHONG"));
		            }
		        } catch(SQLException e) {
		        	System.out.println(e);
		        }
				finally {
					closeConnection();
				}
			}
		 return std;
	 }
}
