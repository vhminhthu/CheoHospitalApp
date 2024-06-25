package com.example.cheohospitalapp_nhom8.sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.cheohospitalapp_nhom8.model.Benhnhan;

import java.util.ArrayList;
import java.util.List;

public class BenhnhanDAO {

    private SQLiteDatabase db;

    public BenhnhanDAO(Context context) {
        DBHelper helper = new DBHelper(context);
        db = helper.getWritableDatabase();
    }
    @SuppressLint("Range")
    public List<Benhnhan> get(String sql , String ...selectArgs){
        List<Benhnhan> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql,selectArgs);

        while ( cursor.moveToNext()) {
            Benhnhan benhnhan = new Benhnhan();

            benhnhan.setMaBN(cursor.getInt(cursor.getColumnIndex( "MaBN")));
            benhnhan.setTenBN(cursor.getString(cursor.getColumnIndex("TenBN")));
            benhnhan.setEmail(cursor.getString(cursor.getColumnIndex("Email")));
            benhnhan.setMatKhau(cursor.getString(cursor.getColumnIndex("Matkhau")));

            benhnhan.setNgaySinh(cursor.getLong(cursor.getColumnIndex("Ngaysinh")));

            benhnhan.setDiaChi(cursor.getString(cursor.getColumnIndex("Diachi")));
            benhnhan.setSdt(cursor.getString(cursor.getColumnIndex("Sodienthoai")));
            benhnhan.setGioiTinh(cursor.getString(cursor.getColumnIndex("Gioitinh")));
            benhnhan.setCmnd(cursor.getString(cursor.getColumnIndex("CMND")));

            benhnhan.setBaoHiemyte(cursor.getInt(cursor.getColumnIndex("Baohiemyte")));

            benhnhan.setAnhBN(cursor.getString(cursor.getColumnIndex("Anhbenhnhan")));
            list.add(benhnhan);
        }
        return list;
    }
    public List<Benhnhan> getAll(){
        String sql ="SELECT * FROM Benhnhan";

        return get(sql);
    }

    public Benhnhan getByMaBN(Integer MaBN){
        String sql = "SELECT * FROM Benhnhan WHERE MaBN = ?";
        List<Benhnhan> list = get(sql, String.valueOf(MaBN));

        return list.get(0);
    }

    public String getTenBNByMaBN(Integer MaBN) {
        Benhnhan benhnhan = getByMaBN(MaBN);
        return benhnhan != null ? benhnhan.getTenBN() : null;
    }

    public String getEmailByMaBN(Integer MaBN) {
        Benhnhan benhnhan = getByMaBN(MaBN);
        return benhnhan != null ? benhnhan.getEmail() : null;
    }


    public long insert (Benhnhan benhnhan){
        ContentValues values = new ContentValues();
        //   values.put("MaBN", benhnhan.getMaBN());
        values.put("TenBN", benhnhan.getTenBN());
        values.put("Matkhau",benhnhan.getMatKhau());
        values.put("Email",benhnhan.getEmail());

        return db.insert("Benhnhan", null , values);
    }



    public long update(Benhnhan benhnhan) {
        ContentValues values = new ContentValues();
        values.put("TenBN", benhnhan.getTenBN());
        values.put("Matkhau", benhnhan.getMatKhau());
        values.put("Email", benhnhan.getEmail());
        values.put("SDT", benhnhan.getSdt()); // Ví dụ: Cập nhật thêm trường Số điện thoại
        values.put("BaoHiem", benhnhan.getBaoHiemyte()); // Ví dụ: Cập nhật thêm trường Bảo hiểm

        String whereClause = "MaBN=?";
        String[] whereArgs = {String.valueOf(benhnhan.getMaBN())};

        return db.update("benhnhan", values, whereClause, whereArgs);
    }

    public long updateEmailvaMatkhau(int maBN, String email, String matKhau) {
        ContentValues values = new ContentValues();
        values.put("Email", email);
        values.put("Matkhau", matKhau);

        String whereClause = "MaBN=?";
        String[] whereArgs = {String.valueOf(maBN)};

        long result = db.update("benhnhan", values, whereClause, whereArgs);
        db.close();
        return result;
    }

    public int delete(String MaBN){
        return db.delete("Benhnhan", "MaBN=?", new String[]{MaBN});
    }




    public Benhnhan getByEmailAndPassword(String email, String matkhau) {
        String sql = "SELECT * FROM Benhnhan WHERE Email = ? AND Matkhau = ?";
        List<Benhnhan> list = get(sql, email, matkhau);

        if (!list.isEmpty()) {
            return list.get(0);
        } else {
            return null;
        }
    }

    public boolean checkEmailExists(String email) {
        String sql = "SELECT * FROM Benhnhan WHERE Email = ?";
        List<Benhnhan> list = get(sql, email);

        return !list.isEmpty();
    }

}
