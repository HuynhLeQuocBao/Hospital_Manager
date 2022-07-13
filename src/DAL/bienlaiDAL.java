package DAL;

import java.sql.*;
import java.util.*;
import java.util.logging.*;

import javax.swing.JOptionPane;

import DAL.databaseConnect;
import base.benhNhan_DichVu;
import base.bienlai;
import base.dichvu;


// chưa tối ưu hóa code ở đây
public class bienlaiDAL {
	
	databaseConnect dc = new databaseConnect();
	
	public bienlaiDAL() {
		
	}
//	List<Product> productList = new ArrayList<Product>();
	// lấy tất cả oke 
	public List<bienlai> findAll() {
		List<bienlai> bienlaiList = new ArrayList<bienlai>();
		
		if(dc.openConnection()) {
			try {
	            //query
	            String sql = "select * from bien_lai";
	            Statement statement = dc.connection.createStatement();
	            
	            ResultSet resultSet = statement.executeQuery(sql);
	           
	            while (resultSet.next()) {                
	            	bienlai std = new bienlai(resultSet.getInt("SO_BL"), 
	                        resultSet.getString("NGAY_THANH_TOAN"), resultSet.getInt("TONG_TIEN"), 
	                         resultSet.getInt("MA_NV"), 
	                         resultSet.getInt("MA_BN"));
	            	bienlaiList.add(std);
	            }
	        } catch(SQLException e) {
	        	System.out.println(e);
	        }
			finally {
				dc.closeConnection();
			}
		}
		return bienlaiList;
	}
	
	public boolean insert(bienlai p) {
		boolean result = false;
		if(dc.openConnection()) {
			try {
	            //query
	            String sql = "insert into bien_lai(SO_BL, NGAY_THANH_TOAN, TONG_TIEN, MA_NV, MA_BN) values (?, ?, ?, ?, ?)";
	            PreparedStatement statement = dc.connection.prepareCall(sql);
	            
	            statement.setInt(1, p.getSoBienLai());
	            statement.setString(2, p.getNgayThanhToan());
	            statement.setDouble(3, p.getTongTien());
	            statement.setInt(4, p.getMaNV());
	            statement.setInt(5, p.getMaBN());
	            
	            if(statement.executeUpdate()>=1) {
	            	result = true;
	            }
	        } catch (SQLException e) {
	        	System.out.println(e);
	        }
			finally {
				dc.closeConnection();
			}
		}
		return result;
	}
	
	 // sửa oke
	public boolean update(bienlai p) {
		boolean result = false;
		if(dc.openConnection()) {
			try {
	            //query
				String sql = "update bien_lai set NGAY_THANH_TOAN=?, TONG_TIEN=?, MA_NV=?, MA_BN=? where SO_BL = ?";
	            PreparedStatement statement = dc.connection.prepareCall(sql);
	            
	            statement.setString(1, p.getNgayThanhToan());
	            statement.setDouble(2, p.getTongTien());
	            statement.setInt(3, p.getMaNV());
	            statement.setInt(4, p.getMaBN());
	            statement.setInt(5, p.getSoBienLai());
	            
	            if(statement.executeUpdate()>=1) {
	            	result = true;
	            }
	        } catch (SQLException e) {
	        	System.out.println(e);
	        }
			finally {
				dc.closeConnection();
			}
		}
		return result;
	}
	public boolean delete(int id) {
		boolean result = false;
		if(dc.openConnection()) {
			try {
	            //query
				String sql = "delete from bien_lai where SO_BL=?";
	            PreparedStatement statement = dc.connection.prepareCall(sql);
	            
	            statement.setInt(1, id);
	            
	            if(statement.executeUpdate()>=1) {
	            	result = true;
	            }
	        } catch (SQLException e) {
	        	System.out.println(e);
	        }
			finally {
				dc.closeConnection();
			}
		}
		return result;
	}
	
	public List<bienlai> findByFullName(int productName) {
		List<bienlai> bienlaiList = new ArrayList<bienlai>();
		
		if(dc.openConnection()) {
			try {
	            //query
	            String sql = "select * from bien_lai where MA_BN = ?";
	            PreparedStatement statement = dc.connection.prepareCall(sql);
	            statement.setInt(1, productName);
	            
	            ResultSet resultSet = statement.executeQuery();
	            
	            while (resultSet.next()) {                
	            	bienlai std = new bienlai(resultSet.getInt("SO_BL"), 
	                        resultSet.getString("NGAY_THANH_TOAN"), resultSet.getInt("TONG_TIEN"), 
	                         resultSet.getInt("MA_NV"), 
	                         resultSet.getInt("MA_BN"));
	            	bienlaiList.add(std);
	            }
	        } catch(SQLException e) {
	        	System.out.println(e);
	        }
			finally {
				dc.closeConnection();
			}
		}
		return bienlaiList;
	}
	
//	public List<String> getALLEmployee() {
//		List<String> employeeList = new ArrayList<String>();
//		
//		if(dc.openConnection()) {
//			try {
//	            
//	            //query
//	            String sql = "select * from employee";
//	            Statement statement = dc.connection.createStatement();
//	            
//	            ResultSet resultSet = statement.executeQuery(sql);
//	           
//	            while (resultSet.next()) {                
//	            	String std = resultSet.getString("EMPLOYEE_CODE");
//	            	employeeList.add(std);
//	            }
//	        } catch(SQLException e) {
//	        	System.out.println(e);
//	        }
//			finally {
//				dc.closeConnection();
//			}
//		}
//		return employeeList;
//	}
//	
//	public List<String> getALLDoctor() {
//		List<String> employeeList = new ArrayList<String>();
//		
//		if(dc.openConnection()) {
//			try {
//	            
//	            //query
//	            String sql = "select * from doctor";
//	            Statement statement = dc.connection.createStatement();
//	            
//	            ResultSet resultSet = statement.executeQuery(sql);
//	           
//	            while (resultSet.next()) {                
//	            	String std = resultSet.getString("DOCTOR_NAME");
//	            	employeeList.add(std);
//	            }
//	        } catch(SQLException e) {
//	        	System.out.println(e);
//	        }
//			finally {
//				dc.closeConnection();
//			}
//		}
//		return employeeList;
//	}
	public boolean hasBienlai(bienlai p) {
		 boolean result = false;
		 
		 if(dc.openConnection()) {
				try {
		            //query
		            String sql = "select * from bien_lai where SO_BL=" + p.getSoBienLai();
		            Statement statement = dc.connection.createStatement();
		            
		            ResultSet resultSet = statement.executeQuery(sql);
		           
		            result = resultSet.next();
		        } catch(SQLException e) {
		        	System.out.println(e);
		        }
				finally {
					dc.closeConnection();
				}
			}
		 
		 return result;
	 }
	
	public double getPrice(int maBn) {
		double price=0, total=0;
		int amount = 0;
		if(dc.openConnection()) {
			try {
	            //lấy giá của dịch vụ 
	            String sql = "select GIA from dich_vu, benhnhan_dichvu where dich_vu.MADV = benhnhan_dichvu.MADV and benhnhan_dichvu.MA_BN = " + maBn;
	            Statement statement = dc.connection.createStatement();
	            
	            ResultSet resultSet = statement.executeQuery(sql);
	           
	            while(resultSet.next()) {
	            	price = resultSet.getDouble("GIA"); // cái này đang nhận giá trị cuối của bảng bệnh nhân dịch vụ
	            	amount = getAmount(maBn); 
	            	total = total + price * amount;
	            }
	        } catch(SQLException e) {
	        	System.out.println(e);
	        }
			finally {
				dc.closeConnection();
			}
		}
		return total;
	}
	
	public int getAmount(int maBn) {
		int amount = 0;
		if(dc.openConnection()) {
			try {
		        // lấy số lượng của dịch vụ mà bệnh nhân sử dụng
			    String sql1 = "select SOLUONGDV from benhnhan_dichvu where benhnhan_dichvu.MA_BN = " + maBn; 
            	Statement statement1 = dc.connection.createStatement();
            	ResultSet resultSet1 = statement1.executeQuery(sql1);
            	while(resultSet1.next()) {
            		amount = resultSet1.getInt("SOLUONGDV");
            		return amount;
				}
	        } catch(SQLException e) {
	        	System.out.println(e);
	        }
			finally {
				dc.closeConnection();
			}
		}
		return amount;
	}
}
