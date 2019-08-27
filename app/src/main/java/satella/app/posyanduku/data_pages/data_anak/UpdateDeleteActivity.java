package satella.app.posyanduku.data_pages.data_anak;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

import satella.app.posyanduku.R;
import satella.app.posyanduku.firebase_helper.DatabaseHelperAnak;
import satella.app.posyanduku.models.Anak;

public class UpdateDeleteActivity extends AppCompatActivity {

    private EditText etKK, etNmLengkap, etNmPanggil, etTinggi;
    private EditText etTmpLahir, etTglLahir,etBerat;
    private Spinner spJenis,spStatus;
    private Button btnUpdate, btnDelete;
    private String key, kk, nmLngkap, nmPanggil, status, tinggi;
    private String tmpLahir, tglLahir, berat, jenisKL;

    private DatabaseReference database;
    private FirebaseDatabase db;
    Anak anak;
    long maxId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete);

        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle("Kelola data");
        }

        etKK = findViewById(R.id.edt_NoKK);
        etNmLengkap = findViewById(R.id.edt_nm_lngkap);
        etNmPanggil = findViewById(R.id.edt_nm_pangilan);
        spStatus = findViewById(R.id.spinner_status);
        etTinggi = findViewById(R.id.edt_tinggi);
        etTmpLahir = findViewById(R.id.edt_tmp_lahir);
        etTglLahir = findViewById(R.id.edt_tgl_lahir);
        etBerat = findViewById(R.id.edt_berat);
        spJenis = findViewById(R.id.spiner_klamin);
        btnUpdate = findViewById(R.id.btn_update_anak);
        btnDelete = findViewById(R.id.btn_delete);

        db = FirebaseDatabase.getInstance();
        database = db.getReference().child("anak");
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    maxId = (dataSnapshot.getChildrenCount());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        initView();

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Anak anak = new Anak();
                anak.setNoKK(etKK.getText().toString().trim());
                anak.setNamaLengkap(etNmLengkap.getText().toString().trim());
                anak.setNamaPanggilan(etNmPanggil.getText().toString().trim());
                anak.setBeratBlahir(etBerat.getText().toString().trim());
                anak.setTglLahir(etTglLahir.getText().toString().trim());
                anak.setTempatLahir(etTmpLahir.getText().toString().trim());
                anak.setTinggiBlahir(etTinggi.getText().toString().trim());
                anak.setStatusLahir(spStatus.getSelectedItem().toString().trim());
                anak.setJenisKlm(spJenis.getSelectedItem().toString());

                if (!isEmpty(etKK.getText().toString()) && !isEmpty(etNmLengkap.getText().toString()) &&
                        !isEmpty(etNmPanggil.getText().toString()) && !isEmpty(etBerat.getText().toString()) &&
                        !isEmpty(etTglLahir.getText().toString()) &&
                        !isEmpty(etTmpLahir.getText().toString()) && !isEmpty(etTinggi.getText().toString()) &&
                        !isEmpty(spStatus.getSelectedItem().toString()) && !isEmpty(spJenis.getSelectedItem().toString())){
                    database.child(String.valueOf(maxId)).setValue(anak);
                    updateAnak();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Data tidak boleh kosong",Toast.LENGTH_LONG).show();
                    InputMethodManager inputManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputManager.hideSoftInputFromWindow(etKK.getWindowToken(),0);
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatabaseHelperAnak().deleteAnak(key, new DatabaseHelperAnak.DataStatusAnak() {
                    @Override
                    public void DataIsLoadAnak(List<Anak> anaks, List<String> keys) {

                    }

                    @Override
                    public void DataIsInsertAnak() {

                    }

                    @Override
                    public void DataIsUpdateAnak() {

                    }

                    @Override
                    public void DataIsDeleteAnak() {
                        Toast.makeText(getApplicationContext(),"Data berhasil dihapus",Toast.LENGTH_LONG).show();
                        finish(); return;
                    }
                });
            }
        });

    }

    void initView(){
        key = getIntent().getStringExtra("key");
        kk = getIntent().getStringExtra("kk");
        nmLngkap = getIntent().getStringExtra("nmLng");
        nmPanggil = getIntent().getStringExtra("nmPang");
        tglLahir = getIntent().getStringExtra("tglLahir");
        tmpLahir = getIntent().getStringExtra("tmpLahir");
        jenisKL = getIntent().getStringExtra("mJenisKL");
        status = getIntent().getStringExtra("status");
        tinggi = getIntent().getStringExtra("tinggi");
        berat = getIntent().getStringExtra("berat");

        etKK.setText(kk);
        etNmLengkap.setText(nmLngkap);
        etNmPanggil.setText(nmPanggil);
        etTglLahir.setText(tglLahir);
        etTmpLahir.setText(tmpLahir);
        spJenis.setPrompt(jenisKL);
        spStatus.setPrompt(status);
        etTinggi.setText(tinggi);
        etBerat.setText(berat);
    }

    private Boolean isEmpty(String s){
        return TextUtils.isEmpty(s);
    }

    private void updateAnak(){
        etKK.setText("");
        etNmPanggil.setText("");
        etNmLengkap.setText("");
        etBerat.setText("");
        etTglLahir.setText("");
        etTmpLahir.setText("");
        etTinggi.setText("");
        spStatus.setPrompt("");
        spJenis.setPrompt("");
        Toast.makeText(getApplicationContext(),"Data berhasil diupdate",Toast.LENGTH_LONG).show();

    }
}
