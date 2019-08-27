package satella.app.posyanduku.firebase_helper;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import satella.app.posyanduku.models.Anak;
import satella.app.posyanduku.models.Bapak;

public class DatabaseHelperBapak {
    private FirebaseDatabase mDatabaseBapak;
    private DatabaseReference mReferenceBapak;
    private List<Bapak> bapaks = new ArrayList<>();

    public interface DataStatusBapak{
        void DataIsLoadBapak(List<Bapak> bapaks, List<String> keys);
        void DataIsInsertBapak();
        void DataIsUpdateBapak();
        void DataIsDeleteBapak();
    }

    public DatabaseHelperBapak() {
        mDatabaseBapak = FirebaseDatabase.getInstance();
        mReferenceBapak = mDatabaseBapak.getReference("bapak");
    }

    public void readBapak(final DataStatusBapak dataStatusBapak){
        mReferenceBapak.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                bapaks.clear();
                List<String> keys = new ArrayList<>();
                for (DataSnapshot keyNode : dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    Bapak bapak = keyNode.getValue(Bapak.class);
                    bapaks.add(bapak);
                }
                dataStatusBapak.DataIsLoadBapak(bapaks, keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    public void deleteBapak(String key, final DataStatusBapak dataStatusBapak){
        mReferenceBapak.child(key).setValue(null)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        dataStatusBapak.DataIsDeleteBapak();
                    }
                });
    }
}
