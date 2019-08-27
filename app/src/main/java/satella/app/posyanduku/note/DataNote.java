package satella.app.posyanduku.note;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.sql.SQLDataException;

public class DataNote extends SQLiteOpenHelper {

    Context mContext;
    private static final String DATABASE_NAME = "Note.db";
    private static final int SCHEMA_VERSION = 1;

    public DataNote(Context context){
        super(context, DATABASE_NAME, null, SCHEMA_VERSION);
        this.mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE noteDb(_id INTEGER " + "PRIMARY KEY AUTOINCREMENT, note LONGTEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_NAME);
    }

    public Cursor getAllNote(){
        return (getReadableDatabase()
                .rawQuery(" SELECT * FROM noteDb ", null));
    }

    public  Cursor getNoteByID(String _id) {
        String[] args = {_id};
        return (getReadableDatabase()
                .rawQuery(" SELECT * FROM noteDb " +
                                " WHERE _id = ? ",
                        args));
    }

    public void insertNote(String note){
        ContentValues cv = new ContentValues();
        cv.put("note", note);
        getWritableDatabase().insert("noteDb", null, cv);
    }

    public void updateNote(String _id, String note){
        ContentValues cv = new ContentValues();
        String[] args = { _id };
        cv.put("note", note);
        getWritableDatabase().update("noteDb", cv, " _id = ? ", args);
    }

    public void deleteNote(String _id){
        String[] args = { _id };
        getWritableDatabase().delete("noteDb", " _id = ? ",args);
    }

}
