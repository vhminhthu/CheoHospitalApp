package com.example.cheohospitalapp_nhom8.sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.cheohospitalapp_nhom8.model.Tintuc;

import java.util.ArrayList;
import java.util.List;

public class TintucDAO {
    private SQLiteDatabase db;

    public TintucDAO(Context context) {
        DBHelper helper = new DBHelper(context);
        db = helper.getWritableDatabase();
    }

    @SuppressLint("Range")
    public List<Tintuc> get(String sql, String ...selectArgs){
        List<Tintuc> list = new ArrayList<>();

        Cursor cursor = db.rawQuery(sql, selectArgs);

        while (cursor.moveToNext()){
            Tintuc tintuc = new Tintuc();

            tintuc.setMaTT(cursor.getInt(cursor.getColumnIndex("MaTT")));
            tintuc.setTieuDe(cursor.getString(cursor.getColumnIndex("Tieude")));
            tintuc.setNoiDung(cursor.getString(cursor.getColumnIndex("Noidung")));
            tintuc.setNgayThem(cursor.getLong(cursor.getColumnIndex("Ngaythem")));
            tintuc.setNgayDang(cursor.getLong(cursor.getColumnIndex("Ngaydang")));
            tintuc.setLuotDoc(cursor.getInt(cursor.getColumnIndex("Luotdoc")));
            tintuc.setHinhAnh(cursor.getString(cursor.getColumnIndex("Hinhanh")));
            tintuc.setTrangThai(cursor.getString(cursor.getColumnIndex("Trangthai")));

            list.add(tintuc);
        }

        return list;
    }

    public List<Tintuc> getAll(){
        String sql = "SELECT * FROM tintuc";
        return get(sql);
    }

    public Tintuc getById(String id){
        String sql = "SELECT * FROM tintuc WHERE MaTT = ?";
        List<Tintuc> list = get(sql, id);
        return list.get(0);
    }
    public long insert(Tintuc tintuc) {
        ContentValues values = new ContentValues();
        values.put("Tieude", tintuc.getTieuDe());
        values.put("Noidung", tintuc.getNoiDung());
        values.put("Ngaythem", tintuc.getNgayThem());
        values.put("Ngaydang", tintuc.getNgayDang());
        values.put("Luotdoc", tintuc.getLuotDoc());
        values.put("Hinhanh", tintuc.getHinhAnh());
        values.put("Trangthai", tintuc.getTrangThai());
        return db.insert("tintuc", null, values);
    }

    public boolean isDataExists() {
        String sql = "SELECT COUNT(*) FROM tintuc";
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor != null && cursor.moveToFirst()) {
            int count = cursor.getInt(0);
            cursor.close();
            return count > 0;
        }
        return false;
    }

    public void addInitialDataIfNotExists() {
        if (!isDataExists()) {
            insert(new Tintuc("Đấu thầu thuốc qua mạng cập nhật tính năng theo quy định mới", "Hệ thống mạng đấu thầu quốc gia được nâng cấp, bổ sung tính năng đáp ứng nhu cầu đấu thầu qua mạng với các gói thầu thuốc theo quy định tại Thông tư số 07 của Bộ Y tế.\n" +
                    "\n" +
                    "Theo Quy định về mẫu tại Phụ lục 01 của Thông tư, hệ thống cập nhật tính năng kế hoạch lựa chọn nhà thầu về việc phân chia gói thầu và nhóm thuốc.\n" +
                    "\n" +
                    "Về quy trình và thủ tục lựa chọn nhà thầu cung cấp thuốc, hệ thống đã phối hợp với Bộ Y Tế và Bộ Kế hoạch Đầu tư (MPI) cập nhật các tính năng Lập hồ sơ mời thầu đối với bên mời thầu, cập nhật tính năng Nộp hồ sơ dự thầu dành cho nhà thầu theo các biểu mẫu mới nhất.", System.currentTimeMillis(), System.currentTimeMillis(), 0, "tintuc1", "Đang đăng"));
            insert(new Tintuc("Bộ Y tế lần đầu cấp phép vaccine sốt xuất huyết", "Cục Quản lý Dược, Bộ Y tế, phê duyệt vaccine ngừa sốt xuất huyết cùng zona thần kinh và phế cầu 23 từ ngày 15/5.\n" +
                    "\n" +
                    "Các vaccine được cấp giấy đăng ký lưu hành gồm Shingrix ngừa zona thần kinh, Qdenga phòng sốt xuất huyết, Pneumovax 23 ngăn phế cầu khuẩn.\n" +
                    "\n" +
                    "Trong đó, vaccine sốt xuất huyết có ý nghĩa quan trọng trong công tác phòng chống dịch. Bệnh chưa có thuốc điều trị đặc hiệu, chủ yếu chữa triệu chứng và theo dõi tránh trở nặng. Virus gây bệnh thường tạo thành các vụ dịch với số lượng bệnh nhân lớn, dẫn đến tăng tỷ lệ trở nặng. Vaccine là biện pháp bền vững, hỗ trợ đắc lực cho lực lượng y tế dự phòng và điều trị.\n" +
                    "\n", System.currentTimeMillis(), System.currentTimeMillis(), 0, "tintuc2", "Đang đăng"));
        }
    }
}
