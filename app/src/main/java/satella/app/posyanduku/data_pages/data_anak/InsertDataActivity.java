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

import satella.app.posyanduku.R;
import satella.app.posyanduku.models.Anak;

public class InsertDataActivity extends AppCompatActivity {

    private EditText edtKK, edtNmLengkap, edtNmPanggil, edtTinggi;
    private EditText edtTmpLahir, edtTglLahir,edtBerat;
    private Spinner spinerKlmin, spinnerStstus;
    private Button btnSubmit;

    private DatabaseReference database;
    private FirebaseDatabase db;
    Anak anak;
    long maxId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data);

        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle("Data anak");
        }

        edtKK = findViewById(R.id.edt_NoKK);
        edtNmLengkap = findViewById(R.id.edt_nm_lngkap);
        edtNmPanggil = findViewById(R.id.edt_nm_pangilan);
        spinnerStstus = findViewById(R.id.spinner_status);
        edtTinggi = findViewById(R.id.edt_tinggi);
        edtTmpLahir = findViewById(R.id.edt_tmp_lahir);
        edtTglLahir = findViewById(R.id.edt_tgl_lahir);
        edtBerat = findViewById(R.id.edt_berat);
        spinerKlmin = findViewById(R.id.spiner_klamin);
        btnSubmit = findViewById(R.id.btn_submit_anak);

        db = FirebaseDatabase.getInstance();
        database = db.getReference().child("anak");
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                maxId = (dataSnapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Anak anak = new Anak();
                anak.setNoKK(edtKK.getText().toString().trim());
                anak.setNamaLengkap(edtNmLengkap.getText().toString().trim());
                anak.setNamaPanggilan(edtNmPanggil.getText().toString().trim());
                anak.setBeratBlahir(edtBerat.getText().toString().trim());
                anak.setTglLahir(edtTglLahir.getText().toString().trim());
                anak.setTempatLahir(edtTmpLahir.getText().toString().trim());
                anak.setTinggiBlahir(edtTinggi.getText().toString().trim());
                anak.setStatusLahir(spinnerStstus.getSelectedItem().toString());
                anak.setJenisKlm(spinerKlmin.getSelectedItem().toString());

                if (!isEmpty(edtKK.getText().toString()) && !isEmpty(edtNmLengkap.getText().toString()) &&
                        !isEmpty(edtNmPanggil.getText().toString()) && !isEmpty(edtBerat.getText().toString()) &&
                        !isEmpty(edtTglLahir.getText().toString()) &&
                        !isEmpty(edtTmpLahir.getText().toString()) && !isEmpty(edtTinggi.getText().toString()) &&
                        !isEmpty(spinnerStstus.getSelectedItem().toString()) && !isEmpty(spinerKlmin.getSelectedItem().toString())){
                    database.child(String.valueOf(maxId)).setValue(anak);
                    submitAnak();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Data tidak boleh kosong",Toast.LENGTH_LONG).show();
                    InputMethodManager inputManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputManager.hideSoftInputFromWindow(edtKK.getWindowToken(),0);
                }
            }
        });


    }

    private Boolean isEmpty(String s){
        return TextUtils.isEmpty(s);
    }

    private void submitAnak(){
        edtKK.setText("");
        edtNmPanggil.setText("");
        edtNmLengkap.setText("");
        edtBerat.setText("");
        edtTglLahir.setText("");
        edtTmpLahir.setText("");
        edtTinggi.setText("");
        spinnerStstus.setPrompt("");
        spinerKlmin.setPrompt("");
        Toast.makeText(getApplicationContext(),"Berhasil simpan data",Toast.LENGTH_LONG).show();

    }
}
