package com.example.roomkullanimi;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "kisiler")
public class Kisiler {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "kisi_id")
    @NonNull
    private int kisi_id;
    @ColumnInfo(name = "kisi_ad")
    @NonNull
    private String kisi_ad;
    @ColumnInfo(name = "kisi_yas")
    @NonNull
    private int kisi_yas;

    public Kisiler() {
    }

    public Kisiler(int kisi_id, @NonNull String kisi_ad, int kisi_yas) {
        this.kisi_id = kisi_id;
        this.kisi_ad = kisi_ad;
        this.kisi_yas = kisi_yas;
    }

    public int getKisi_id() {
        return kisi_id;
    }

    public void setKisi_id(int kisi_id) {
        this.kisi_id = kisi_id;
    }

    @NonNull
    public String getKisi_ad() {
        return kisi_ad;
    }

    public void setKisi_ad(@NonNull String kisi_ad) {
        this.kisi_ad = kisi_ad;
    }

    public int getKisi_yas() {
        return kisi_yas;
    }

    public void setKisi_yas(int kisi_yas) {
        this.kisi_yas = kisi_yas;
    }
}
