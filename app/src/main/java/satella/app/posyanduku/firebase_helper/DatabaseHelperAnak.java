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

public class DatabaseHelperAnak {
    private FirebaseDatabase mDatabaseAnak;
    private DatabaseReference mReferenceAnak;
    private List<Anak> anaks = new ArrayList<>();

    public interface DataStatusAnak{
        void DataIsLoadAnak(List<Anak> anaks, List<String> keys);
        void DataIsInsertAnak();
        void DataIsUpdateAnak();
        void DataIsDeleteAnak();
    }

    public DatabaseHelperAnak() {
        mDatabaseAnak = FirebaseDatabase.getInstance();
        mReferenceAnak = mDatabaseAnak.getReference("anak");
    }

    public void readAnak(final DataStatusAnak dataStatusAnak){
        mReferenceAnak.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                anaks.clear();
                List<String> keys = new ArrayList<>();
                for (DataSnapshot keyNode : dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    Anak anak = keyNode.getValue(Anak.class);
                    anaks.add(anak);
                }
                dataStatusAnak.DataIsLoadAnak(anaks, keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void deleteAnak(String key, final DataStatusAnak dataStatusAnak){
        mReferenceAnak.child(key).setValue(null)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        dataStatusAnak.DataIsDeleteAnak();
                    }
                });
    }

}
