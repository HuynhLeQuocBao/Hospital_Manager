package DAL;

import java.sql.*;
import java.util.*;
import java.util.logging.*;

import javax.swing.JOptionPane;

import base.*;

// chưa tối ưu hóa code ở đây
public class nhanvienDAL {
	
	private Connection connection; 
	public nhanvienDAL() {
		
	}
//	List<nhanvien> nhanvienList = new ArrayList<nhanvien>();
	// lấy tất cả oke 
	public List<nhanvien> findAll() {
		List<nhanvien> nhanvienList = new ArrayList<nhanvien>();
		
		if(openConnection()) {
			try {
	            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pttkhttt?useSSL=false", "root", "");
	            
	            //query
	            String sql = "select * from nhan_vien";
	            Statement statement = connection.createStatement();
	            
	            ResultSet resultSet = statement.executeQuery(sql);
	           
	            while (resultSet.next()) {                
	            	nhanvien std = new nhanvien(resultSet.getInt("MA_TK"), resultSet.getInt("MANV"), 
	                        resultSet.getString("TENNV"), 
	                        resultSet.getString("DIACHI"),resultSet.getString("GIOITINH"),resultSet.getString("NGAYSINH"));
	            	nhanvienList.add(std);
	            }
	        } catch(SQLException e) {
	        	System.out.println(e);
	        }
			finally {
				closeConnection();
			}
		}
		return nhanvienList;
	}
	
	public boolean insert(nhanvien p) {
		boolean result = false;
		if(openConnection()) {
			try {
	            //query
	            String sql = "insert into nhan_vien(MA_TK, MANV, TENNV,DIACHI,GIOITINH,NGAYSINH) values (?, ?, ?, ?,?,?)";
	            PreparedStatement statement = connection.prepareCall(sql);
	            
	            statement.setInt(1, p.getMaTK());
	            statement.setInt(2, p.getManv());
	            statement.setString(3, p.getTennv());
	            statement.setString(4, p.getDiachi());
	            statement.setString(5, p.getGioitinh());
	            statement.setString(6, p.getNgaysinh());
	            
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
	public boolean update(nhanvien p) {
		boolean result = false;
		if(openConnection()) {
			try {
	            //query
				String sql = "update nhan_vien set TENNV=?, DIACHI=?, GIOITINH=?, NGAYSINH=?  where MANV = ?";
	            PreparedStatement statement = connection.prepareCall(sql);
	            
	            statement.setString(1, p.getTennv());
	            statement.setString(2, p.getDiachi());
	            statement.setString(3, p.getGioitinh());
	            statement.setString(4, p.getNgaysinh());
	            statement.setInt(5, p.getManv());
	            
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
				String sql = "delete from nhan_vien where MANV = ?";
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
	public List<nhanvien> findByFullName(String nhanvienName) {
		List<nhanvien> nhanvienList = new ArrayList<nhanvien>();
		
		if(openConnection()) {
			try {
	            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pttkhttt?useSSL=false", "root", "");
	            
	            //query
	            String sql = "select * from nhan_vien where TENNV like ?";
	            PreparedStatement statement = connection.prepareCall(sql);
	            statement.setString(1, "%"+nhanvienName+"%");
	            
	            ResultSet resultSet = statement.executeQuery();
	            
	            while (resultSet.next()) {    
	            	nhanvien std = new nhanvien(resultSet.getInt("MA_TK"), resultSet.getInt("MANV"), 
	                        resultSet.getString("TENNV"), 
	                        resultSet.getString("DIACHI"),resultSet.getString("GIOITINH"),resultSet.getString("NGAYSINH"));
	            	nhanvienList.add(std);
	            }
	        } catch(SQLException e) {
	        	System.out.println(e);
	        }
			finally {
				closeConnection();
			}
		}
		return nhanvienList;
	}
	public List<String> getnhanvienList() {
		List<String> nhanvienList = new ArrayList<String>();
		
		if(openConnection()) {
			try {
	            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pttkhttt?useSSL=false", "root", "");
	            
	            //query
	            String sql = "select * from nhan_vien";
	            Statement statement = connection.createStatement();
	            
	            ResultSet resultSet = statement.executeQuery(sql);
	           
	            while (resultSet.next()) {                
	            	String std = resultSet.getString("TENNV");
	            	nhanvienList.add(std);
	            }
	        } catch(SQLException e) {
	        	System.out.println(e);
	        }
			finally {
				closeConnection();
			}
		}
		return nhanvienList;
	}
	 // check trùng mã sản phẩm
	 public boolean hasnhanvienCode(int nhanvienCode) {
		 boolean result = false;
		 
		 if(openConnection()) {
				try {
		            //query
		            String sql = "select * from nhan_vien where MANV=" + nhanvienCode;
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
	 public nhanvien getnhanvien(int id) {
		 nhanvien std = null;
		 if(openConnection()) {
				try {
		            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pttkhttt?useSSL=false", "root", "");
		            
		            //query
		            String sql = "select * from nhan_vien where TENNV = ?" ;
		            PreparedStatement statement = connection.prepareCall(sql);
		            statement.setInt(1, id);
		            
		            ResultSet resultSet = statement.executeQuery();
		            
		            while (resultSet.next()) {    
		            	std = new nhanvien(resultSet.getInt("MA_TK"), resultSet.getInt("MANV"), 
		                        resultSet.getString("TENNV"), 
		                        resultSet.getString("DIACHI"),resultSet.getString("GIOITINH"),resultSet.getString("NGAYSINH"));
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
