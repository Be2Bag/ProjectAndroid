package th.ac.su.projectandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
import android.database.Cursor;
import androidx.annotation.Nullable;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "cal.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "my_cal";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_HIGHT = "cal_hight";
    private static final String COLUMN_WEIGHT = "cal_weight";
    private static final String COLUMN_BMI = "cal_bmi";
    private static final String COLUMN_BODY = "cal_body";

    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME,null,DATABASE_VERSION );
        this.context = context;
    }

    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_HIGHT + " TEXT, " +
                COLUMN_WEIGHT + " TEXT," +
                COLUMN_BMI + " INTEGER," +
                COLUMN_BODY + " TEXT);";
        db.execSQL(query);
    }

    public  void onUpgrade(SQLiteDatabase db, int i, int i1){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void addBook(String hight, String weight, double bmi, String body){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_HIGHT, hight);
        cv.put(COLUMN_WEIGHT, weight);
        cv.put(COLUMN_BMI, bmi);
        cv.put(COLUMN_BODY, body);


        long result = db.insert(TABLE_NAME,null, cv);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }


}
