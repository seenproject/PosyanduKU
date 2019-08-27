package satella.app.posyanduku.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import satella.app.posyanduku.R;
import satella.app.posyanduku.models.Anak;
import satella.app.posyanduku.models.Bapak;

public class RecyclerviewBapakAdapter {
    private Context mContext;
    private BapakAdapter mBapakAdapter;

    public void setConfig(RecyclerView recyclerView, Context context, List<Bapak> bapaks, List<String> keys){
        mContext = context;
        mBapakAdapter = new BapakAdapter(bapaks, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mBapakAdapter);
    }
    class BapakItemView extends RecyclerView.ViewHolder {
        private TextView mKK, mNmBpk, mPekerjaan;
        private TextView mpendidikan, mAlamat;
        private TextView mAgama, mTmptLahir, mTglLahir;
        private String key;


        public BapakItemView(@NonNull ViewGroup parent) {
            super(LayoutInflater.from(mContext).inflate(R.layout.item_bapak, parent, false));

            mKK = itemView.findViewById(R.id.tv_kk);
            mNmBpk = itemView.findViewById(R.id.tv_nm_bpk);
            mPekerjaan = itemView.findViewById(R.id.tv_kerja_bpk);
            mpendidikan = itemView.findViewById(R.id.tv_pend_bpk);
            mAlamat = itemView.findViewById(R.id.tv_almt_bpk);
            mAgama = itemView.findViewById(R.id.tv_agama_bpk);
            mTmptLahir = itemView.findViewById(R.id.tv_tmp_lahir_bpk);
            mTglLahir = itemView.findViewById(R.id.tv_tgl_bpk);

        }

        public void bind(Bapak bapak, String key){
            mKK.setText(bapak.getNoKkBapak());
            mNmBpk.setText(bapak.getNama_bapak());
            mPekerjaan.setText(bapak.getPekerjaan());
            mpendidikan.setText(bapak.getPendidikan());
            mAlamat.setText(bapak.getAlamat());
            mAgama.setText(bapak.getAgama());
            mTmptLahir.setText(bapak.getTempat_lahir());
            mTglLahir.setText(bapak.getTanggal_lahir());
            this.key = key;
        }
    }

    class BapakAdapter extends RecyclerView.Adapter<BapakItemView>{
        private List<Bapak> mBapakList;
        private List<String> mKeys;

        public BapakAdapter(List<Bapak> mBapakList, List<String> mKeys) {
            this.mBapakList = mBapakList;
            this.mKeys = mKeys;
        }

        @NonNull
        @Override
        public BapakItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new BapakItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull BapakItemView holder, int position) {
            holder.bind(mBapakList.get(position), mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mBapakList.size();
        }
    }
}
