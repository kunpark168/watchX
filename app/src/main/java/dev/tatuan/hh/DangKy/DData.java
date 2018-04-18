package dev.tatuan.hh.DangKy;

/**
 * Created by tatuan on 17/04/2018.
 */

public class DData {
    String matkhau, ten, diachi;

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public DData() {

    }

    public DData(String matkhau, String ten, String diachi) {

        this.matkhau = matkhau;
        this.ten = ten;
        this.diachi = diachi;
    }
}
