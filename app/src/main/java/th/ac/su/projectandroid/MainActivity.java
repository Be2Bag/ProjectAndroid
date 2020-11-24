package th.ac.su.projectandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.database.Cursor;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button AddButton;

    MyDatabaseHelper myDB;
    ArrayList<String> cal_id,  cal_hight, cal_weight, cal_bmi ,cal_body;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        AddButton = findViewById(R.id.button_add);
        AddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });


        myDB = new MyDatabaseHelper(MainActivity.this);
        cal_id = new ArrayList<>();
        cal_hight = new ArrayList<>();
        cal_weight = new ArrayList<>();
        cal_bmi = new ArrayList<>();
        cal_body = new ArrayList<>();


        storeDataInArrays();

        customAdapter = new CustomAdapter(MainActivity.this,this, cal_id, cal_hight, cal_weight, cal_bmi, cal_body);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

    }

    void storeDataInArrays(){
        Cursor cursor = myDB.readAllData();
        if(cursor.getCount() == 0){
            Toast.makeText(this,"No data.", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                cal_id.add(cursor.getString(0));
                cal_hight.add(cursor.getString(1));
                cal_weight.add(cursor.getString(2));
                cal_bmi.add(cursor.getString(3));
                cal_body.add(cursor.getString(4));
            }
        }
    }


}