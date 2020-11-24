package th.ac.su.projectandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText text_hight,text_weight;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        text_hight = findViewById(R.id.text_hight);
        text_weight = findViewById(R.id.text_weight);
        submit = findViewById(R.id.button_submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);

                int H = Integer.valueOf(text_hight.getText().toString().trim());
                int W = Integer.valueOf(text_weight.getText().toString().trim());
                double A = W / ((H*0.01)*2);

                String body;

                if(A >= 30) {
                    body = "โรคอ้วนอันตราย";
                }else if(A >= 25){
                    body = "โรคอ้วน";
                }else if(A >= 23){
                    body = "น้ำหนักเกิน";
                }else if(A >= 18.5){
                    body = "สมส่วน";
                }else{
                    body = "น้ำหนักต่ำกว่าเกณฑ์";
                }

                myDB.addBook(text_hight.getText().toString().trim(),
                            text_weight.getText().toString().trim(), A , body );

                Intent intent = new Intent(AddActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}