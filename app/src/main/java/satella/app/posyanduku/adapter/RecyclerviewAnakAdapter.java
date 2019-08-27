package satella.app.posyanduku.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import satella.app.posyanduku.R;
import satella.app.posyanduku.data_pages.data_anak.UpdateDeleteActivity;
import satella.app.posyanduku.models.Anak;

public class RecyclerviewAnakAdapter {
    private Context mContext;
    private AnakAdapter mAnakAdapter;

    public void setConfig(RecyclerView recyclerView, Context context, List<Anak> anaks, List<String> keys){
        mContext = context;
        mAnakAdapter = new AnakAdapter(anaks, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mAnakAdapter);
    }

    class AnakItemView extends RecyclerView.ViewHolder{
        private TextView mKK, mNmLengkap, mNmPanggil;
        private TextView mTmpLahir, mTglLahir;
        private TextView mJenisKlamin, mStatus,mTinggi, mBerat;
        private String key;


        public AnakItemView(@NonNull ViewGroup parent) {
            super(LayoutInflater.from(mContext).inflate(R.layout.item_anak, parent,false));

            mKK = itemView.findViewById(R.id.tv_kk);
            mNmLengkap = itemView.findViewById(R.id.tv_nm_lengkap);
            mNmPanggil = itemView.findViewById(R.id.tv_nm_panggilan);
            mTglLahir = itemView.findViewById(R.id.tv_tgl);
            mTmpLahir = itemView.findViewById(R.id.tv_tmpat_lahir);
            mJenisKlamin = itemView.findViewById(R.id.tv_jenis_klamin);
            mStatus = itemView.findViewById(R.id.tv_status);
            mTinggi = itemView.findViewById(R.id.tv_tinggi);
            mBerat = itemView.findViewById(R.id.tv_berat);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, UpdateDeleteActivity.class);
                    intent.putExtra("key", key);
                    intent.putExtra("kk", mKK.getText().toString());
                    intent.putExtra("nmLng", mNmLengkap.getText().toString());
                    intent.putExtra("nmPang", mNmPanggil.getText().toString());
                    intent.putExtra("tglLahir", mTglLahir.getText().toString());
                    intent.putExtra("tmpLahir", mTmpLahir.getText().toString());
                    intent.putExtra("mJenisKL", mJenisKlamin.getText().toString());
                    intent.putExtra("status", mStatus.getText().toString());
                    intent.putExtra("tinggi", mTinggi.getText().toString());
                    intent.putExtra("berat", mBerat.getText().toString());

                    mContext.startActivity(intent);
                }
            });


        }

        public void bind(Anak anak, String key){
            mKK.setText(anak.getNoKK());
            mNmLengkap.setText(anak.getNamaLengkap());
            mNmPanggil.setText(anak.getNamaPanggilan());
            mTglLahir.setText(anak.getTglLahir());
            mTmpLahir.setText(anak.getTempatLahir());
            mJenisKlamin.setText(anak.getJenisKlm());
            mStatus.setText(anak.getStatusLahir());
            mTinggi.setText(anak.getTinggiBlahir());
            mBerat.setText(anak.getBeratBlahir());
            this.key = key;
        }
    }
    class AnakAdapter extends RecyclerView.Adapter<AnakItemView>{
        private List<Anak> mAnakList;
        private List<String> mKeys;

        public AnakAdapter(List<Anak> mAnakList, List<String> mKeys) {
            this.mAnakList = mAnakList;
            this.mKeys = mKeys;
        }

        @NonNull
        @Override
        public AnakItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new AnakItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull AnakItemView holder, int position) {
            holder.bind(mAnakList.get(position), mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mAnakList.size();
        }
    }
}
