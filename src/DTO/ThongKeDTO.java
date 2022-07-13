/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author VIVOBOOK
 */
public class ThongKeDTO {
    public String MaDV,MaBN,Ngay,TenDV;
    public int Dongia,Solan;

    public ThongKeDTO() {
    }

    public ThongKeDTO(String MaDV, String MaBN, String Ngay, String TenDV, int Dongia,int Solan) {
        this.MaDV = MaDV;
        this.MaBN = MaBN;
        this.Ngay = Ngay;
        this.TenDV = TenDV;
        this.Dongia = Dongia;
        this.Solan=Solan;
    }

    public String getMaDV() {
        return MaDV;
    }

    public void setMaDV(String MaDV) {
        this.MaDV = MaDV;
    }

    public String getMaBN() {
        return MaBN;
    }

    public void setMaBN(String MaBN) {
        this.MaBN = MaBN;
    }

    public String getNgay() {
        return Ngay;
    }

    public void setNgay(String Ngay) {
        this.Ngay = Ngay;
    }

    public String getTenDV() {
        return TenDV;
    }

    public void setTenDV(String TenDV) {
        this.TenDV = TenDV;
    }

    public int getDongia() {
        return Dongia;
    }

    public void setDongia(int Dongia) {
        this.Dongia = Dongia;
    }

    public int getSolan() {
        return Solan;
    }

    public void setSolan(int Solan) {
        this.Solan = Solan;
    }
    
    
   
    
}
