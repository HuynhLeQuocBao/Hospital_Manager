package DAL;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.logging.*;

import javax.swing.JOptionPane;


import DAL.databaseConnect;
import base.benhNhan_DichVu;
import base.dichvu;
import jdk.dynalink.linker.support.SimpleLinkRequest;


// chưa tối ưu hóa code ở đây
public class benhNhan_DichVuDAL {
	
	databaseConnect dc = new databaseConnect();
	
	public benhNhan_DichVuDAL() {
		
	}
//	List<Product> productList = new ArrayList<Product>();
	// lấy tất cả oke 
	public List<benhNhan_DichVu> findAll() {
		List<benhNhan_DichVu> list = new ArrayList<benhNhan_DichVu>();
		
		if(dc.openConnection()) {
			try {
	            //query
	            String sql = "select * from benhnhan_dichvu";
	            Statement statement = dc.connection.createStatement();
	            
	            ResultSet resultSet = statement.executeQuery(sql);
	           
	            while (resultSet.next()) {                
	            	benhNhan_DichVu std = new benhNhan_DichVu(resultSet.getInt("SOPHIEU_SD"), 
	                        resultSet.getInt("MA_BN"), resultSet.getString("NGAY_SD"), 
	                        resultSet.getInt("SOLUONGDV"), resultSet.getInt("MADV"));
	            	list.add(std);
	            }
	        } catch(SQLException e) {
	        	System.out.println(e);
	        }
			finally {
				dc.closeConnection();
			}
		}
		return list;
	}
	
	public boolean insert(benhNhan_DichVu p) {
		boolean result = false;
		if(dc.openConnection()) {
			try {
	            //query
	            String sql = "insert into benhnhan_dichvu(SOPHIEU_SD, MA_BN, NGAY_SD, SOLUONGDV, MADV) values (?, ?, ?, ?, ?)";
	            PreparedStatement statement = dc.connection.prepareCall(sql);
	            
	            statement.setInt(1, p.getSphieuSD());
	            statement.setInt(2, p.getMaBN());
	            statement.setString(3, p.getNgaySD());
	            statement.setInt(4, p.getSoluongDV());
	            statement.setInt(5, p.getMaDV());
	           
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
	public boolean update(benhNhan_DichVu p) {
		boolean result = false;
		if(dc.openConnection()) {
			try {
	            //query
				String sql = "update benhnhan_dichvu set MA_BN=?, NGAY_SD=?, SOLUONGDV=?, MADV=? where SOPHIEU_SD = ?";
	            PreparedStatement statement = dc.connection.prepareCall(sql);
	            
	            statement.setInt(1, p.getMaBN());
	            statement.setString(2, p.getNgaySD());
	            statement.setInt(3, p.getSoluongDV());
	            statement.setInt(4, p.getMaDV());
	            statement.setInt(5, p.getSphieuSD());
	            
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
				String sql = "delete from benhnhan_dichvu where SOPHIEU_SD=?";
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
	
	public List<benhNhan_DichVu> findById(int maBN) {
		List<benhNhan_DichVu> list = new ArrayList<benhNhan_DichVu>();
		
		if(dc.openConnection()) {
			try {
	            //query 
	            String sql = "select * from benhnhan_dichvu where MA_BN like ?";
	            PreparedStatement statement = dc.connection.prepareCall(sql);
	            statement.setInt(1, maBN);
	            
	            ResultSet resultSet = statement.executeQuery();
	            
	            while (resultSet.next()) {                
	            	benhNhan_DichVu std = new benhNhan_DichVu(resultSet.getInt("SOPHIEU_SD"), 
	                        resultSet.getInt("MA_BN"), resultSet.getString("NGAY_SD"), 
	                        resultSet.getInt("SOLUONGDV"), resultSet.getInt("MADV"));
	            	list.add(std);
	            }
	        } catch(SQLException e) {
	        	System.out.println(e);
	        }
			finally {
				dc.closeConnection();
			}
		}
		return list;
	}
	
	public boolean hasBenhNhanDichVu(benhNhan_DichVu p) {
		 boolean result = false;
		 
		 if(dc.openConnection()) {
				try {
		            //query
		            String sql = "select * from benhnhan_dichvu where SOPHIEU_SD=" + p.getSphieuSD();
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
	
	public List<benhNhan_DichVu> baoCao() throws ParseException {
		List<benhNhan_DichVu> list = new ArrayList<benhNhan_DichVu>();
		
		if(dc.openConnection()) {
			try {
	            //query 
	            String sql = "select * from benhnhan_dichvu";
	            PreparedStatement statement = dc.connection.prepareCall(sql);
	            
	            ResultSet resultSet = statement.executeQuery();
	            
	            while (resultSet.next()) {                
	            	benhNhan_DichVu std = new benhNhan_DichVu(resultSet.getInt("SOPHIEU_SD"), 
	                        resultSet.getInt("MA_BN"), resultSet.getString("NGAY_SD"), 
	                        resultSet.getInt("SOLUONGDV"), resultSet.getInt("MADV"));
	            	// ngày hiện tại
	            	Date now = new Date();
	            	String ft = new SimpleDateFormat("MM/yyyy").format(now);
	            	String date = ft.formatted(now);
	            	// ngày của benhNhandichvu
	            	String date1 = std.getNgaySD();
	            	// chuyển String về ngày
	            	Date format = new SimpleDateFormat("dd/MM/yyyy").parse(date1);
	            	String ft1 = new SimpleDateFormat("MM/yyyy").format(format);
	            	String dateSD = ft1.formatted(format);
	            	if(date.equals(dateSD)) {
	            		list.add(std);
	            	}
	            }
	        } catch(SQLException e) {
	        	System.out.println(e);
	        }
			finally {
				dc.closeConnection();
			}
		}
		return list;
	}
}
