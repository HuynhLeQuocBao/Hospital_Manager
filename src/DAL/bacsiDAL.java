package DAL;

import java.sql.*;
import java.util.*;
import java.util.logging.*;

import javax.swing.JOptionPane;

import base.*;

// chưa tối ưu hóa code ở đây
public class bacsiDAL {
	
	private Connection connection; 
	public bacsiDAL() {
		
	}
//	List<bac_si> bac_siList = new ArrayList<bac_si>();
	// lấy tất cả oke 
	public List<bacsi> findAll() {
		List<bacsi> bac_siList = new ArrayList<bacsi>();
		
		if(openConnection()) {
			try {
	            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pttkhttt?useSSL=false", "root", "");
	            
	            //query
	            String sql = "select * from bac_si";
	            Statement statement = connection.createStatement();
	            
	            ResultSet resultSet = statement.executeQuery(sql);
	           
	            while (resultSet.next()) {                
	            	bacsi std = new bacsi(resultSet.getInt("MA_TK"), resultSet.getInt("MABS"), 
	                        resultSet.getString("TENBS"), resultSet.getString("DIENTHOAI"), 
	                        resultSet.getString("DIACHI"),resultSet.getString("GIOITINH"),resultSet.getString("NGAYSINH"));
	            	bac_siList.add(std);
	            }
	        } catch(SQLException e) {
	        	System.out.println(e);
	        }
			finally {
				closeConnection();
			}
		}
		return bac_siList;
	}
	
	public boolean insert(bacsi p) {
		boolean result = false;
		if(openConnection()) {
			try {
	            //query
	            String sql = "insert into bac_si(MA_TK, MABS, TENBS,DIENTHOAI,DIACHI,GIOITINH,NGAYSINH) values (?, ?, ?, ?, ?,?,?)";
	            PreparedStatement statement = connection.prepareCall(sql);
	            
	            statement.setInt(1, p.getMaTK());
	            statement.setInt(2, p.getMabs());
	            statement.setString(3, p.getTenbs());
	            statement.setString(4, p.getDienthoai());
	            statement.setString(5, p.getDiachi());
	            statement.setString(6, p.getGioitinh());
	            statement.setString(7, p.getNgaysinh());
	            
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
	public boolean update(bacsi p) {
		boolean result = false;
		if(openConnection()) {
			try {
	            //query
				String sql = "update bac_si set TENBS=?, DIENTHOAI=?, DIACHI=?, GIOITINH=?, NGAYSINH=?  where MABS = ?";
	            PreparedStatement statement = connection.prepareCall(sql);
	            
	            statement.setString(1, p.getTenbs());
	            statement.setString(2, p.getDienthoai());
	            statement.setString(3, p.getDiachi());
	            statement.setString(4, p.getGioitinh());
	            statement.setString(5, p.getNgaysinh());
	            statement.setInt(6, p.getMabs());
	            
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
				String sql = "delete from bac_si where MABS = ?";
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
	public List<bacsi> findByFullName(String bac_siName) {
		List<bacsi> bac_siList = new ArrayList<bacsi>();
		
		if(openConnection()) {
			try {
	            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pttkhttt?useSSL=false", "root", "");
	            
	            //query
	            String sql = "select * from bac_si where TENBS like ?";
	            PreparedStatement statement = connection.prepareCall(sql);
	            statement.setString(1, "%"+bac_siName+"%");
	            
	            ResultSet resultSet = statement.executeQuery();
	            
	            while (resultSet.next()) {                
	            	bacsi std = new bacsi(resultSet.getInt("MA_TK"), resultSet.getInt("MABS"), 
	                        resultSet.getString("TENBS"), resultSet.getString("DIENTHOAI"), 
	                        resultSet.getString("DIACHI"),resultSet.getString("GIOITINH"),resultSet.getString("NGAYSINH"));
	            	bac_siList.add(std);
	            }
	        } catch(SQLException e) {
	        	System.out.println(e);
	        }
			finally {
				closeConnection();
			}
		}
		return bac_siList;
	}
	public List<String> getbac_siList() {
		List<String> bac_siList = new ArrayList<String>();
		
		if(openConnection()) {
			try {
	            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pttkhttt?useSSL=false", "root", "");
	            
	            //query
	            String sql = "select * from bac_si";
	            Statement statement = connection.createStatement();
	            
	            ResultSet resultSet = statement.executeQuery(sql);
	           
	            while (resultSet.next()) {                
	            	String std = resultSet.getString("TENBS");
	            	bac_siList.add(std);
	            }
	        } catch(SQLException e) {
	        	System.out.println(e);
	        }
			finally {
				closeConnection();
			}
		}
		return bac_siList;
	}
	 // check trùng mã sản phẩm
	 public boolean hasbac_siCode(int bac_siCode) {
		 boolean result = false;
		 
		 if(openConnection()) {
				try {
		            //query
		            String sql = "select * from bac_si where MABS=" + bac_siCode;
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
	 public bacsi getbacsi(int id) {
		 bacsi std = null;
		 if(openConnection()) {
				try {
		            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pttkhttt?useSSL=false", "root", "");
		            
		            //query
		            String sql = "select * from bac_si where TENBS = ?" ;
		            PreparedStatement statement = connection.prepareCall(sql);
		            statement.setInt(1, id);
		            
		            ResultSet resultSet = statement.executeQuery();
		            
		            while (resultSet.next()) {                
		            	std = new bacsi(resultSet.getInt("MA_TK"), resultSet.getInt("MABS"), 
		                        resultSet.getString("TENBS"), resultSet.getString("DIENTHOAI"), 
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
