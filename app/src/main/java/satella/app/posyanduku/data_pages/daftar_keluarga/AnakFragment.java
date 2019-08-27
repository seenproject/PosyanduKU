package satella.app.posyanduku.data_pages.daftar_keluarga;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import satella.app.posyanduku.R;
import satella.app.posyanduku.adapter.RecyclerviewAnakAdapter;
import satella.app.posyanduku.firebase_helper.DatabaseHelperAnak;
import satella.app.posyanduku.models.Anak;

public class AnakFragment extends Fragment {

    private RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_anak,container,false);

        mRecyclerView = view.findViewById(R.id.rv_anak);
        new DatabaseHelperAnak().readAnak(new DatabaseHelperAnak.DataStatusAnak() {
            @Override
            public void DataIsLoadAnak(List<Anak> anaks, List<String> keys) {
                new RecyclerviewAnakAdapter().setConfig(mRecyclerView, getActivity(), anaks, keys);
            }

            @Override
            public void DataIsInsertAnak() {

            }

            @Override
            public void DataIsUpdateAnak() {

            }

            @Override
            public void DataIsDeleteAnak() {

            }
        });

        return view;
    }
}
