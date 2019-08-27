package satella.app.posyanduku.note;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import satella.app.posyanduku.R;

public class NoteActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mAdd, mUpdate, mDelete, mCancel, addData;
    private EditText mNote;
    private ListView listNote;
    private LinearLayout lineAdd, lineUpdate, lineDelete, lineCancel;

    DataNote dataNote;
    Cursor cursor;
    String selectedIndex;
    String idSechond;
    NoteAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle("Note");
        }

        dataNote = new DataNote(this);

        mNote = findViewById(R.id.note);
        mAdd = findViewById(R.id.img_add);
        mUpdate = findViewById(R.id.img_update);
        mDelete = findViewById(R.id.img_delete);
        mCancel = findViewById(R.id.img_cancel);
        listNote = findViewById(R.id.listNote);
        addData = findViewById(R.id.AddData);
        lineAdd = findViewById(R.id.line_add);
        lineUpdate = findViewById(R.id.line_update);
        lineDelete = findViewById(R.id.line_delete);
        lineCancel = findViewById(R.id.line_cancel);

        mAdd.setOnClickListener(this);
        mDelete.setOnClickListener(this);
        mUpdate.setOnClickListener(this);
        mCancel.setOnClickListener(this);
        addData.setOnClickListener(this);

        listNote.setVisibility(View.VISIBLE);
        allData();

    }

    @Override
    public void onClick(View v) {
        if (v == mCancel){
            lineUpdate.setVisibility(View.GONE);
            lineAdd.setVisibility(View.GONE);
            lineCancel.setVisibility(View.GONE);
            lineDelete.setVisibility(View.GONE);
            mNote.setVisibility(View.GONE);
            mNote.setText(null);
        }
        else if (v == mAdd){
            if (mNote.getText().toString().length()==0){
                new AlertDialog.Builder(NoteActivity.this)
                        .setTitle("Kosong")
                        .setMessage("Isi Note !")
                        .setNeutralButton("Oke", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).show();
            }else {
                dataNote.insertNote(mNote.getText().toString());
                allData();
                mNote.setText(null);
                mNote.setVisibility(View.GONE);
                lineAdd.setVisibility(View.GONE);
            }
        }
        else if (v == mUpdate){
            dataNote.updateNote(idSechond, mNote.getText().toString());
            allData();
            lineUpdate.setVisibility(View.GONE);
            lineAdd.setVisibility(View.GONE);
            lineCancel.setVisibility(View.GONE);
            lineDelete.setVisibility(View.GONE);
            mNote.setVisibility(View.GONE);
            mNote.setText(null);
        }
        else if (v == mDelete){
            dataNote.deleteNote(idSechond);
            allData();
            lineUpdate.setVisibility(View.GONE);
            lineAdd.setVisibility(View.GONE);
            lineCancel.setVisibility(View.GONE);
            lineDelete.setVisibility(View.GONE);
            mNote.setVisibility(View.GONE);
            mNote.setText(null);
        }
        else if (v == addData){
            mNote.setVisibility(View.VISIBLE);
            lineAdd.setVisibility(View.VISIBLE);
        }
    }

    public void allData(){
        int firstVisiblePosition = listNote.getFirstVisiblePosition();
        int lastVisiblePosition = listNote.getLastVisiblePosition();
        View view = listNote.getChildAt(0);
        int distFromTop = (view == null) ? 0 : view.getTop();

        try {

            cursor = dataNote.getAllNote();
            if (cursor.moveToFirst()){
                startManagingCursor(cursor);
                adapter =  new NoteAdapter(NoteActivity.this, cursor);
                listNote.setAdapter(adapter);
                adapter.notifyDataSetChanged();

                if (lastVisiblePosition >= cursor.getCount()-1)
                    listNote.setSelection(cursor.getCount());
                else
                    listNote.setSelectionFromTop(firstVisiblePosition, distFromTop);

            }else{
                listNote.setAdapter(null);
            }

        }catch(Exception e){

            if (e!=null)
                Log.e("error list", e.toString());

        }

    }

    class NoteAdapter extends CursorAdapter{

        NoteAdapter(Context context , Cursor c) {
            super(context, c);
        }

        public void setSelectedIndex(String ind, int posisi) {
            selectedIndex = ind;

        }

        @Override
        public View newView(Context context, Cursor cursor, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View v = inflater.inflate(R.layout.detail_note, parent,
                    false);
            ViewHolder holder = new ViewHolder(v);

            v.setTag(holder);
            // bindView(v, context, cursor);
            return v;
        }

        @Override
        public void bindView(View view, Context context, Cursor cursor) {
            ViewHolder holder = (ViewHolder) view.getTag();

            holder.populateFrom(cursor, dataNote, selectedIndex, context);


        }
    }

    class ViewHolder{
        private View row = null;
        private LinearLayout detailMain = null;
        private TextView detailNote = null;
        String key;

        ViewHolder(View row) {
            this.row = row;
            detailMain = row.findViewById(R.id.detail_utama);
            detailNote = row.findViewById(R.id.detailNote);
        }

        void populateFrom(final Cursor c, final DataNote approve, String selected,
                          final Context context){
            key = c.getString(c.getColumnIndex("_id"));
            detailNote.setText(c.getString(c.getColumnIndex("note")));

            detailMain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    idSechond = key;
                    mNote.setText(detailNote.getText().toString());

                    lineAdd.setVisibility(View.GONE);
                    mNote.setVisibility(View.VISIBLE);
                    lineUpdate.setVisibility(View.VISIBLE);
                    lineDelete.setVisibility(View.VISIBLE);
                    lineCancel.setVisibility(View.VISIBLE);
                }
            });

        }

    }
}
