package com.example.cheohospitalapp_nhom8.model;

public class Benhnhan {
    private int maBN;
    private String tenBN;
    private String email;
    private String matKhau;
    private long ngaySinh;
    private String diaChi;
    private String sdt;
    private String gioiTinh;
    private String cmnd;
    private int baoHiemyte;
    private String anhBN;

    public Benhnhan() {
    }

    public Benhnhan(int maBN, String tenBN, String email, String matKhau, long ngaySinh, String diaChi, String sdt, String gioiTinh, String cmnd, int baoHiemyte, String anhBN) {
        this.maBN = maBN;
        this.tenBN = tenBN;
        this.email = email;
        this.matKhau = matKhau;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.gioiTinh = gioiTinh;
        this.cmnd = cmnd;
        this.baoHiemyte = baoHiemyte;
        this.anhBN = anhBN;
    }

    public int getMaBN() {
        return maBN;
    }

    public void setMaBN(int maBN) {
        this.maBN = maBN;
    }

    public String getTenBN() {
        return tenBN;
    }

    public void setTenBN(String tenBN) {
        this.tenBN = tenBN;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public long getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(long ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public int getBaoHiemyte() {
        return baoHiemyte;
    }

    public void setBaoHiemyte(int baoHiemyte) {
        this.baoHiemyte = baoHiemyte;
    }

    public String getAnhBN() {
        return anhBN;
    }

    public void setAnhBN(String anhBN) {
        this.anhBN = anhBN;
    }
}
