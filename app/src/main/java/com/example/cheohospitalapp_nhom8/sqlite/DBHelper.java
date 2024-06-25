package com.example.cheohospitalapp_nhom8.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "HospitalApp_Nhom8_DB";
    public static final int DB_VERSION = 1;
    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String Benhnhan = "CREATE TABLE benhnhan(" +
                "MaBN INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "TenBN TEXT NOT NULL, " +
                "Email TEXT NOT NULL, " +
                "Matkhau TEXT NOT NULL," +
                "Ngaysinh NUMERIC, " +
                "Diachi TEXT," +
                "Sodienthoai TEXT," +
                "Gioitinh TEXT," +
                "CMND TEXT,"+
                "Baohiemyte INTEGER,"+
                "Anhbenhnhan TEXT)";

        String Chuyenkhoa = "CREATE TABLE chuyenkhoa(" +
                "MaCK INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "Ten TEXT NOT NULL)";

        String Bacsi = "CREATE TABLE bacsi(" +
                "MaBS INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "MaCK INTEGER, " +
                "TenBS TEXT NOT NULL, " +
                "Email TEXT NOT NULL, " +
                "Matkhau TEXT NOT NULL," +
                "Ngaysinh NUMERIC, " +
                "Diachi TEXT," +
                "Sodienthoai TEXT," +
                "Gioitinh TEXT," +
                "Kinhnghiem TEXT,"+
                "Gioithieu INTEGER,"+
                "Anhbacsi TEXT,"+
                "FOREIGN KEY(MaCK) REFERENCES chuyenkhoa(MaCK))";

        String Lichtrinh = "CREATE TABLE lichtrinh(" +
                "MaLT INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "MaBS INTEGER,"+
                "Thoigian JSON NOT NULL,"+
                "Chiphi INTEGER NOT NULL,"+
                "FOREIGN KEY(MaBS) REFERENCES bacsi(MaBS))";

        String Lichhen = "CREATE TABLE lichhen(" +
                "MaLH INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "MaBN INTEGER, " +
                "MaLT INTEGER, " +
                "Thoigian TEXT NOT NULL,"+
                "Tinhtrang TEXT NOT NULL,"+
                "Tong INTEGER NOT NULL," +
                "FOREIGN KEY(MaLT) REFERENCES lichtrinh(MaLT),"+
                "FOREIGN KEY(MaBN) REFERENCES benhnhan(MaBN))" ;

        String Thongbao = "CREATE TABLE thongbao(" +
                "MaTB INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "Tieude TEXT NOT NULL,"+
                "Noidung TEXT NOT NULL,"+
                "Loaithongbao TEXT NOT NULL,"+
                "Mucdokhancap TEXT NOT NULL,"+
                "Ngaythem NUMERIC NOT NULL,"+
                "Ngaydang NUMERIC,"+
                "Nguoigui TEXT NOT NULL,"+
                "Nguoinhan TEXT NOT NULL,"+
                "Trangthai TEXT NOT NULL)";

        String Tintuc = "CREATE TABLE tintuc(" +
                "MaTT INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "Tieude TEXT NOT NULL,"+
                "Noidung TEXT NOT NULL,"+
                "Ngaythem NUMERIC,"+
                "Ngaydang NUMERIC,"+
                "Luotdoc INTEGER,"+
                "Hinhanh TEXT,"+
                "Trangthai TEXT NOT NULL)";

        db.execSQL(Benhnhan);
        db.execSQL(Chuyenkhoa);
        db.execSQL(Bacsi);
        db.execSQL(Lichtrinh);
        db.execSQL(Lichhen);
        db.execSQL(Thongbao);
        db.execSQL(Tintuc);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropTablebenhnhan = "DROP TABLE IF EXISTS benhnhan";
        String dropTablechuyenkhoa = "DROP TABLE IF EXISTS chuyenkhoa";
        String dropTablebacsi = "DROP TABLE IF EXISTS bacsi";
        String dropTablelichtrinh = "DROP TABLE IF EXISTS lichtrinh";
        String dropTablelichhen = "DROP TABLE IF EXISTS lichhen";
        String dropTablethongbao = "DROP TABLE IF EXISTS thongbao";
        String dropTabletintuc = "DROP TABLE IF EXISTS tintuc";

        db.execSQL(dropTablebenhnhan);
        db.execSQL(dropTablechuyenkhoa);
        db.execSQL(dropTablebacsi);
        db.execSQL(dropTablelichtrinh);
        db.execSQL(dropTablelichhen);
        db.execSQL(dropTablethongbao);
        db.execSQL(dropTabletintuc);

        onCreate(db);
    }
}
