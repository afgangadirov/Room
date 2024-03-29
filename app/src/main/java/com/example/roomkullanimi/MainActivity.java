package com.example.roomkullanimi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private Veritabani vt;
    private KisilerDao kdao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vt = Veritabani.veritabaniErisim(this);
        kdao = vt.getKisilerDao();

        kisileriYukle();
    }


    public void kisileriYukle(){
        kdao.tumKisiler().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Kisiler>>() {
                    @Override
                    public void onSubscribe(Disposable d) {}
                    @Override
                    public void onSuccess(List<Kisiler> kisilers) {
                        for(Kisiler k:kisilers){
                            Log.e("Kişi id",String.valueOf(k.getKisi_id()));
                            Log.e("Kişi ad",k.getKisi_ad());
                            Log.e("Kişi yaş",String.valueOf(k.getKisi_yas()));
                        }
                    }
                    @Override
                    public void onError(Throwable e) {}
                });
    }



}