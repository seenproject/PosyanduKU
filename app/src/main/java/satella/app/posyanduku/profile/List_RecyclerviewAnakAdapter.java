package satella.app.posyanduku.profile;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import satella.app.posyanduku.MainActivity;
import satella.app.posyanduku.Posyandu.read_profile;
import satella.app.posyanduku.R;
import satella.app.posyanduku.adapter.RecyclerviewAnakAdapter;
import satella.app.posyanduku.models.Anak;

import static androidx.core.content.ContextCompat.startActivity;

public class List_RecyclerviewAnakAdapter extends RecyclerView.Adapter<List_RecyclerviewAnakAdapter.ViewHolder> {
    private ArrayList<Anak> listAnak;
    private Context mContext;

    public List_RecyclerviewAnakAdapter(ArrayList<Anak> anaks,Context context){
        /**
         * Inisiasi data dan variabel yang akan digunakan
         */
        listAnak = anaks;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /**
         *  Inisiasi ViewHolder
         */
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_anak,parent,false);
        // mengeset ukuran view, margin, padding, dan parameter layout lainnya
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        /**
         *  Menampilkan data pada view
         */
        final String nikAnak = listAnak.get(position).getNoKK();
        final String namaAnak = listAnak.get(position).getNamaLengkap();
        final String tanggalLahir = listAnak.get(position).getTglLahir();

        holder.tv_nikAnak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        holder.tv_nikAnak.setText(nikAnak);
        holder.tv_namaAnak.setText(namaAnak);
        holder.tv_tanggalLahir.setText(tanggalLahir);
        holder.tv_nikAnak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(data_profile.getActIntent((Activity) mContext).putExtra("anak", (Serializable) listAnak.get(position)));
            }
        });
    }


    @Override
    public int getItemCount() {
        /**
         * Mengembalikan jumlah item pada anak
         */
        return listAnak.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_nikAnak,tv_namaAnak,tv_tanggalLahir;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_nikAnak = (TextView) itemView.findViewById(R.id.tv_nikAnak);
            tv_namaAnak = (TextView) itemView.findViewById(R.id.tv_namaAnak);
            tv_tanggalLahir = (TextView) itemView.findViewById(R.id.tv_tanggalLahir);

        }
    }
}
