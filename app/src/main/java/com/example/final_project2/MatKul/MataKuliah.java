package com.example.final_project2.MatKul;

public class MataKuliah {
    private String namaMatkul;
    private String jumlahSks;
    private String namaDosen;

    public MataKuliah(String namaMatkul, String jumlahSks, String namaDosen){
        this.namaMatkul = namaMatkul;
        this.namaDosen=  namaDosen;
        this.jumlahSks = jumlahSks;
    }

    public String getNamaMatkul() {
        return namaMatkul;
    }

    public String getJumlahSks() {
        return jumlahSks;
    }

    public String getNamaDosen() {
        return namaDosen;
    }
}
