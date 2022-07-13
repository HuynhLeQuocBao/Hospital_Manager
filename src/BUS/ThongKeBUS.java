/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ThongKeDAO;
import DTO.ThongKeDTO;
import java.util.ArrayList;

/**
 *
 * @author VIVOBOOK
 */
public class ThongKeBUS {
    public static ArrayList<ThongKeDTO> DSTK;

    public ThongKeBUS() {
    }
     public ArrayList<ThongKeDTO> docDSHD(){
        if(DSTK==null){
            ThongKeDAO get=new ThongKeDAO();
            DSTK=get.getList();
        }
        return DSTK;
    }
    
     public ThongKeDTO TiemKiemGia(int Gia){
            for(int i=0;i<DSTK.size();i++){
                if(Gia==DSTK.get(i).Dongia){
                    return DSTK.get(i);
                }
            }
        return null;
    }
     
    public ThongKeDTO TiemKiemTenDV(String Ten){
            for(int i=0;i<DSTK.size();i++){
                if(Ten.equals(DSTK.get(i).TenDV)){
                    return DSTK.get(i);
                }
            }
        return null;
    }
     
    public ThongKeDTO TiemKiemMaDV(String MaDV){
            for(int i=0;i<DSTK.size();i++){
                if(MaDV.equals(DSTK.get(i).MaDV)){
                    return DSTK.get(i);
                }
            }
        return null;
    }
    
     public ThongKeDTO TiemKiemMaBN(String MaBN){
            for(int i=0;i<DSTK.size();i++){
                if(MaBN.equals(DSTK.get(i).MaBN)){
                    return DSTK.get(i);
                }
            }
        return null;
    }
}
