package com.example.final_project2.Mahasiswa;

import android.provider.BaseColumns;

public class MahasiswaContract  {
    public MahasiswaContract(){}
    public static final class mahasiswaEntry implements BaseColumns{
        public static final String TABLE_NAME = "mahasiswa";
        public static final String COLUMN_NIM = "nim";
        public static final String COLUMN_NAMA = "nama";
    }
}