package DAL;

import java.sql.*;
import java.util.*;
import java.util.logging.*;

import javax.swing.JOptionPane;

import base.khambenh;

// chưa tối ưu hóa code ở đây
public class khamBenhDAL {
	
	private Connection connection; 
	public khamBenhDAL() {
		
	}
//	List<bac_si> bac_siList = new ArrayList<bac_si>();
	// lấy tất cả oke 
	public List<khambenh> findAll() {
		List<khambenh> khamBenhList = new ArrayList<khambenh>();
		
		if(openConnection()) {
			try {
	            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pttkhttt?useSSL=false", "root", "");
	            
	            //query
	            String sql = "select * from kham_benh";
	            Statement statement = connection.createStatement();
	            
	            ResultSet resultSet = statement.executeQuery(sql);
	           
	            while (resultSet.next()) {                
	            	khambenh std = new khambenh(resultSet.getInt("SOPHIEUKHAM"), 
	                        resultSet.getString("NGAYKHAM"), resultSet.getString("TRIEUTRUNG"), 
	                        resultSet.getInt("MABS"),resultSet.getInt("MABN"),resultSet.getInt("MABENH"), resultSet.getInt("SPKHAM"));
	            	khamBenhList.add(std);
	            }
	        } catch(SQLException e) {
	        	System.out.println(e);
	        }
			finally {
				closeConnection();
			}
		}
		return khamBenhList;
	}
	
	public boolean insert(khambenh p) {
		boolean result = false;
		if(openConnection()) {
			try {
	            //query
	            String sql = "insert into kham_benh(SOPHIEUKHAM, NGAYKHAM,TRIEUTRUNG,MABS,MABN,MABENH,SPKHAM) values (?, ?, ?, ?,?,?,?)";
	            PreparedStatement statement = connection.prepareCall(sql);
	            statement.setInt(1, p.getSophieukham());
	            statement.setString(2, p.getNgaykham());
	            statement.setString(3, p.getTrieutrung());
	            statement.setInt(4, p.getMabs());
	            statement.setInt(5, p.getMabn());
	            statement.setInt(6, p.getMabenh());
	            statement.setInt(7, p.getSophongkham());
	            
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
	public boolean update(khambenh p) {
		boolean result = false;
		if(openConnection()) {
			try {
	            //query
				String sql = "update kham_benh set NGAYKHAM=?, TRIEUTRUNG=?, MABS=?, MABN=?, MABENH=?, SPKHAM=?  where SOPHIEUKHAM = ?";
	            PreparedStatement statement = connection.prepareCall(sql);
	            
	            statement.setString(1, p.getNgaykham());
	            statement.setString(2, p.getTrieutrung());
	            statement.setInt(3, p.getMabs());
	            statement.setInt(4, p.getMabn());
	            statement.setInt(5, p.getMabenh());
	            statement.setInt(6, p.getSophongkham());
	            statement.setInt(7, p.getSophieukham());
	            
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
				String sql = "delete from kham_benh where SOPHIEUKHAM = ?";
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
	public List<khambenh> findBysophieukham(int maBN) {
		List<khambenh> khamBenhList = new ArrayList<khambenh>();
		
		if(openConnection()) {
			try {
	            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pttkhttt?useSSL=false", "root", "");
	            
	            //query
	            String sql = "select * from kham_benh where MABN = ?";
	            PreparedStatement statement = connection.prepareCall(sql);
	            statement.setInt(1, maBN);
	            
	            ResultSet resultSet = statement.executeQuery();
	            
	            while (resultSet.next()) {    
	            	khambenh std = new khambenh(resultSet.getInt("SOPHIEUKHAM"), 
	                        resultSet.getString("NGAYKHAM"), resultSet.getString("TRIEUTRUNG"), 
	                        resultSet.getInt("MABS"),resultSet.getInt("MABN"),resultSet.getInt("MABENH"), resultSet.getInt("SPKHAM"));
	            	khamBenhList.add(std);
	            }
	        } catch(SQLException e) {
	        	System.out.println(e);
	        }
			finally {
				closeConnection();
			}
		}
		return khamBenhList;
	}
	public List<String> getkhamBenhList() {
		List<String> khamBenhList = new ArrayList<String>();
		
		if(openConnection()) {
			try {
	            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pttkhttt?useSSL=false", "root", "");
	            
	            //query
	            String sql = "select * from kham_benh";
	            Statement statement = connection.createStatement();
	            
	            ResultSet resultSet = statement.executeQuery(sql);
	           
	            while (resultSet.next()) {                
	            	String std = resultSet.getString("SOPHIEUKHAM");
	            	khamBenhList.add(std);
	            }
	        } catch(SQLException e) {
	        	System.out.println(e);
	        }
			finally {
				closeConnection();
			}
		}
		return khamBenhList;
	}
	 // check trùng mã sản phẩm
	 public boolean hasSophieukham(int sophieukham) {
		 boolean result = false;
		 
		 if(openConnection()) {
				try {
		            //query
		            String sql = "select * from kham_benh where SOPHIEUKHAM=" + sophieukham;
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
	 public khambenh getkhambenh(int id) {
		 khambenh std = null;
		 if(openConnection()) {
				try {
		            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pttkhttt?useSSL=false", "root", "");
		            
		            //query
		            String sql = "select * from kham_benh where SOPHIEUKHAM = ?" ;
		            PreparedStatement statement = connection.prepareCall(sql);
		            statement.setInt(1, id);
		            
		            ResultSet resultSet = statement.executeQuery();
		            
		            while (resultSet.next()) {    
		            	std = new khambenh(resultSet.getInt("SOPHIEUKHAM"), 
		                        resultSet.getString("NGAYKHAM"), resultSet.getString("TRIEUTRUNG"), 
		                        resultSet.getInt("MABS"),resultSet.getInt("MABN"),resultSet.getInt("MABENH"), resultSet.getInt("SPKHAM"));
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
	 public List<String> getbenhnhanList() {
			List<String> benhnhanList = new ArrayList<String>();
			
			if(openConnection()) {
				try {
		            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pttkhttt?useSSL=false", "root", "");
		            
		            //query
		            String sql = "select * from benh_nhan";
		            Statement statement = connection.createStatement();
		            
		            ResultSet resultSet = statement.executeQuery(sql);
		           
		            while (resultSet.next()) {                
		            	String std = resultSet.getString("TENBN");
		            	benhnhanList.add(std);
		            }
		        } catch(SQLException e) {
		        	System.out.println(e);
		        }
				finally {
					closeConnection();
				}
			}
			return benhnhanList;
		}
		public List<String> getbacsiList() {
			List<String> bacsiList = new ArrayList<String>();
			
			if(openConnection()) {
				try {
		            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pttkhttt?useSSL=false", "root", "");
		            
		            //query
		            String sql = "select * from bac_si";
		            Statement statement = connection.createStatement();
		            
		            ResultSet resultSet = statement.executeQuery(sql);
		           
		            while (resultSet.next()) {                
		            	String std = resultSet.getString("TENBS");
		            	bacsiList.add(std);
		            }
		        } catch(SQLException e) {
		        	System.out.println(e);
		        }
				finally {
					closeConnection();
				}
			}
			return bacsiList;
		}
		public List<String> getMabenh() {
			List<String> mabenhList = new ArrayList<String>();
			
			if(openConnection()) {
				try {
		            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pttkhttt?useSSL=false", "root", "");
		            
		            //query
		            String sql = "select * from benh";
		            Statement statement = connection.createStatement();
		            
		            ResultSet resultSet = statement.executeQuery(sql);
		           
		            while (resultSet.next()) {                
		            	String std = resultSet.getString("TEN_BENH");
		            	mabenhList.add(std);
		            }
		        } catch(SQLException e) {
		        	System.out.println(e);
		        }
				finally {
					closeConnection();
				}
			}
			return mabenhList;
		}
		public int getData(String table, String dataToGet, String name, String col) {
			int data = 0;
			if(openConnection()) {
				try {
		            //query
		            String sql = "select " + dataToGet + " from " + table + " where " + col + " = '"+name+"' ";
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
		public String getData1(String table, String dataToGet, String name, String col) {
			String data = "";
			if(openConnection()) {
				try {
		            //query
		            String sql = "select " + dataToGet + " from " + table + " where " + col + " =  "+name+" " ;
		            Statement statement = connection.createStatement();
		            
		            ResultSet resultSet = statement.executeQuery(sql);
		           
		            while (resultSet.next()) {                
		            	data = resultSet.getString(dataToGet);
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
}
