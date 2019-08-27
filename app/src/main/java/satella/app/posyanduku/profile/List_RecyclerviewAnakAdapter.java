package satella.app.posyanduku.profile;

import android.content.Context;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class List_RecyclerviewAnakAdapter {
    private Context mContext;
    private ListAnakAdapter mListAnakAdapter;

    public void setConfig(RecyclerView recyclerView, Context context, List<Anak> anaks, List<String> keys){
        mContext = context;
        mListAnakAdapter = new ListAnakAdapter(anaks,keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mListAnakAdapter);
    }

    class AnakItemView extends RecyclerView.ViewHolder{
        private TextView
    }

    private class ListAnakAdapter {
    }
}
