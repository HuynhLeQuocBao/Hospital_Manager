/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ThongKeDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author VIVOBOOK
 */
public class ThongKeDAO {
    Connection conn=getconnect();
    public Connection getconnect(){
        Connection con1 = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/pttkhttt","root","");
            System.out.println(con1);
        }catch(Exception e){
            e.getStackTrace();
        }
        return con1;
    }

    public ThongKeDAO() {
    }
    
    public ArrayList<ThongKeDTO> getList(){      
        ArrayList<ThongKeDTO> dv=new ArrayList<>();
        try {
            Statement stament=conn.createStatement();
            ResultSet rs=stament.executeQuery("select * from bang_thong_ke ");     
            while(rs.next()){
                ThongKeDTO d=new ThongKeDTO();
                d.MaBN=rs.getString(1);
                d.MaDV=rs.getString(2);
                d.TenDV=rs.getString(3);
                d.Ngay=rs.getString(4);
                d.Dongia=rs.getInt(5);
                d.Solan=rs.getInt(6);
                dv.add(d);
            }
        } catch (Exception ex) {
            System.out.println("Loi");
            ex.getStackTrace();
//            JOptionPane.showMessageDialog(rootPane,"Khong co xem duoc ");
//            Logger.getLogger(Quanly.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return dv;
    }
}
