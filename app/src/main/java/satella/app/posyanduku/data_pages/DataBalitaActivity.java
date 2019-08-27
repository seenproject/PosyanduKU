package satella.app.posyanduku.data_pages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import satella.app.posyanduku.R;
import satella.app.posyanduku.data_pages.daftar_keluarga.DaftarKeluargaActivity;
import satella.app.posyanduku.data_pages.data_anak.InsertDataActivity;
import satella.app.posyanduku.data_pages.data_orang_tua.DataOrangTuaActivity;

public class DataBalitaActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imgDataAnak, imgList, imgTips, imgParent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_balita);

        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle("Data Balita");
        }

        imgDataAnak = findViewById(R.id.btn_anak);
        imgList = findViewById(R.id.btn_list);
        imgTips = findViewById(R.id.btn_tips);
        imgParent = findViewById(R.id.btn_parent);

        imgDataAnak.setOnClickListener(this);
        imgList.setOnClickListener(this);
        imgTips.setOnClickListener(this);
        imgParent.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if (v == imgDataAnak){
            Intent intent = new Intent(DataBalitaActivity.this, InsertDataActivity.class);
            startActivity(intent);
        }
        else if (v == imgList){
            Intent intent = new Intent(DataBalitaActivity.this, DaftarKeluargaActivity.class);
            startActivity(intent);
        }
        else if (v == imgParent){
            Intent intent = new Intent(DataBalitaActivity.this, DataOrangTuaActivity.class);
            startActivity(intent);
        }
    }
}
