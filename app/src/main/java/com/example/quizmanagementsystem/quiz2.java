package com.example.quizmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class quiz2 extends AppCompatActivity {
    RatingBar ratingbar;
    int marks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);
        ratingbar=(RatingBar)findViewById(R.id.ratingBar);
        custom_part();
    }

    private void custom_part() {
        Intent i=getIntent();
        marks=i.getIntExtra("message",1);

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast_layout,
                (ViewGroup) findViewById(R.id.toast));
        ImageView toastImageView = (ImageView) layout.findViewById(R.id.i1);
        TextView t = (TextView) layout.findViewById(R.id.t1);
        t.setText("Marks" + marks + " ");
        toastImageView.setImageResource(R.drawable.j);
        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }
    public void New(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void Rate_Us(View v){
        String rating=String.valueOf(ratingbar.getRating());
        Toast.makeText(getApplicationContext(), rating, Toast.LENGTH_LONG).show();
    }
}