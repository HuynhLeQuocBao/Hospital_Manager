/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

/**
 *
 * @author DucThanh
 */
public class dichvu {
    String tenDV;
    double donGia;
    int maDV;

    public dichvu(int maDV, String tenDV, double donGia) {
        this.maDV = maDV;
        this.tenDV = tenDV;
        this.donGia = donGia;
    }

    public dichvu() {
        this.maDV = -1;
        this.tenDV = null;
        this.donGia = 0;
    }
    
    public int getMaDV() {
        return maDV;
    }

    public void setMaDV(int maDV) {
        this.maDV = maDV;
    }

    public String getTenDV() {
        return tenDV;
    }

    public void setTenDV(String tenDV) {
        this.tenDV = tenDV;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    @Override
    public String toString() {
        return "dichvu{" + "maDV=" + maDV + ", tenDV=" + tenDV + ", donGia=" + donGia + '}';
    }
    
}
