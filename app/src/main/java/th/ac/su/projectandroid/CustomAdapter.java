package th.ac.su.projectandroid;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList cal_id,  cal_hight, cal_weight,cal_bmi, cal_body;

    CustomAdapter(Activity activity, Context context, ArrayList cal_id, ArrayList cal_hight, ArrayList cal_weight ,ArrayList cal_bmi,ArrayList cal_body){
        this.activity = activity;
        this.context = context;
        this.cal_id = cal_id;
        this.cal_hight = cal_hight;
        this.cal_weight = cal_weight;
        this.cal_bmi = cal_bmi;
        this.cal_body = cal_body;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
        holder.book_id_txt.setText(String.valueOf(cal_id.get(position)));
        holder.book_title_txt.setText("ความสูง "+String.valueOf(cal_hight.get(position)));
        holder.book_author_txt.setText("น้ำหนัก "+String.valueOf(cal_weight.get(position)));

        holder.book_bmi_txt.setText("ค่า BMI เท่ากับ "+String.valueOf(cal_bmi.get(position)));
        holder.book_pages_txt.setText(String.valueOf(cal_body.get(position)));
    }

    @Override
    public int getItemCount() {
        return cal_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView book_id_txt, book_title_txt, book_author_txt, book_pages_txt, book_bmi_txt;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            book_id_txt = itemView.findViewById(R.id.book_id_txt);
            book_title_txt = itemView.findViewById(R.id.book_title_txt);
            book_author_txt = itemView.findViewById(R.id.book_author_txt);
            book_bmi_txt = itemView.findViewById(R.id.txt_bmi);
            book_pages_txt = itemView.findViewById(R.id.book_pages_txt);

        }
    }
}
