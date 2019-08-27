package satella.app.posyanduku.data_pages.daftar_keluarga;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import satella.app.posyanduku.R;
import satella.app.posyanduku.adapter.RecyclerviewBapakAdapter;
import satella.app.posyanduku.firebase_helper.DatabaseHelperBapak;
import satella.app.posyanduku.models.Bapak;

public class BapakFragment extends Fragment {

    private RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bpk,container,false);

        mRecyclerView = view.findViewById(R.id.rv_bapak);
        new DatabaseHelperBapak().readBapak(new DatabaseHelperBapak.DataStatusBapak() {
            @Override
            public void DataIsLoadBapak(List<Bapak> bapaks, List<String> keys) {
                new RecyclerviewBapakAdapter().setConfig(mRecyclerView, getActivity(), bapaks, keys);
            }

            @Override
            public void DataIsInsertBapak() {

            }

            @Override
            public void DataIsUpdateBapak() {

            }

            @Override
            public void DataIsDeleteBapak() {

            }
        });


        return view;
    }
}
