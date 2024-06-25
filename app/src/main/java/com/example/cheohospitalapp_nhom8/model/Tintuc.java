package com.example.cheohospitalapp_nhom8.model;

public class Tintuc {
    private int maTT;
    private String tieuDe;
    private String noiDung;
    private long ngayThem;
    private long ngayDang;
    private int luotDoc;
    private String hinhAnh;
    private String trangThai;

    public Tintuc() {
    }

    public Tintuc(String tieuDe, String noiDung, long ngayThem, long ngayDang, int luotDoc, String hinhAnh, String trangThai) {
        this.tieuDe = tieuDe;
        this.noiDung = noiDung;
        this.ngayThem = ngayThem;
        this.ngayDang = ngayDang;
        this.luotDoc = luotDoc;
        this.hinhAnh = hinhAnh;
        this.trangThai = trangThai;
    }

    public long getMaTT() {
        return maTT;
    }

    public void setMaTT(int maTT) {
        this.maTT = maTT;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public long getNgayThem() {
        return ngayThem;
    }

    public void setNgayThem(long ngayThem) {
        this.ngayThem = ngayThem;
    }

    public long getNgayDang() {
        return ngayDang;
    }

    public void setNgayDang(long ngayDang) {
        this.ngayDang = ngayDang;
    }

    public int getLuotDoc() {
        return luotDoc;
    }

    public void setLuotDoc(int luotDoc) {
        this.luotDoc = luotDoc;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

}
