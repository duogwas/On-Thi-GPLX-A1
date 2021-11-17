package fithou.duogwas.onthigplxa1.Class;//
// Created by duogwas on 17/11/2021.
//

public class BienBao {
    public String Hinh;
    public String TenBien;
    public String MoTa;

    public String getHinh() {
        return Hinh;
    }

    public void setHinh(String hinh) {
        Hinh = hinh;
    }

    public String getTenBien() {
        return TenBien;
    }

    public void setTenBien(String tenBien) {
        TenBien = tenBien;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String moTa) {
        MoTa = moTa;
    }

    public BienBao(String hinh, String tenBien, String moTa) {
        Hinh = hinh;
        TenBien = tenBien;
        MoTa = moTa;
    }
}
