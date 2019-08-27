package satella.app.posyanduku.data_pages.data_orang_tua;

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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import satella.app.posyanduku.R;
import satella.app.posyanduku.models.Bapak;
import satella.app.posyanduku.models.Ibu;

public class DataOrangTuaActivity extends AppCompatActivity {

    private EditText edtKK, edtNamaBpk, edtNamaIbu, edtKerjaBpk, edtKerjaIbu, edtPendBpk, edtPendIbu;
    private EditText edtAlmtBpk,edtAlmtIbu, edtAgamaBpk, edtAgamaIbu , edtTmpBpk, edtTmpibu, edtTglBpk, edtTglibu;
    private Button btnSubmit;

    private TextView txKK, txNmBpk;

    private DatabaseReference databaseBpk;
    private FirebaseDatabase dbBpk;
    private DatabaseReference databaseIbu;
    private FirebaseDatabase dbIbu;

    Bapak bapak;
    Ibu ibu;
    long maxIdBpk = 1;
    long maxIdIbu = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_orang_tua);

        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle("Data orang tua");
        }

        edtKK = findViewById(R.id.edt_NoKK_kel);
        edtNamaBpk = findViewById(R.id.edt_Nama_bpk);
        edtNamaIbu = findViewById(R.id.edt_Nama_ibu);
        edtKerjaBpk = findViewById(R.id.edt_pekerjaan_bpk);
        edtKerjaIbu = findViewById(R.id.edt_pekerjaan_ibu);
        edtPendBpk = findViewById(R.id.edt_pendidikan_bpk);
        edtPendIbu = findViewById(R.id.edt_pendidikan_ibu);
        edtAlmtBpk = findViewById(R.id.edt_alamat_bpk);
        edtAlmtIbu = findViewById(R.id.edt_alamat_ibu);
        edtAgamaBpk = findViewById(R.id.edt_agama_bpk);
        edtAgamaIbu = findViewById(R.id.edt_agama_ibu);
        edtTmpBpk = findViewById(R.id.edt_tmp_lhr_bkk);
        edtTmpibu = findViewById(R.id.edt_tmp_lhr_ibu);
        edtTglBpk = findViewById(R.id.edt_tgl_lhr_bpk);
        edtTglibu = findViewById(R.id.edt_tgl_lhr_ibu);
        btnSubmit = findViewById(R.id.btn_submit_parent);


        dbBpk = FirebaseDatabase.getInstance();
        databaseBpk = dbBpk.getReference().child("bapak");

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bapak bapak = new Bapak();

                bapak.setNoKkBapak(edtKK.getText().toString().trim());
                bapak.setNama_bapak(edtNamaBpk.getText().toString().trim());

                if (!isEmpty(edtKK.getText().toString()) && !isEmpty(edtNamaBpk.getText().toString())){
                    databaseBpk.child(String.valueOf(maxIdBpk)).setValue(bapak);
                    submitBpk();
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
    private void submitBpk(){
                edtKK.setText("");
                edtNamaBpk.setText("");
                Toast.makeText(getApplicationContext(),"Berhasil simpan data",Toast.LENGTH_LONG).show();

    }
}
