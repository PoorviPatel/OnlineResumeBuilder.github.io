package com.example.poorvi.slidertablayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class Template extends AppCompatActivity {


    ImageView Template1,Template2,Template3,Template4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.template);

        Template1 = (ImageView) findViewById(R.id.template1);
        Template2 = (ImageView) findViewById(R.id.template2);
        Template3 = (ImageView) findViewById(R.id.template3);
        Template4 = (ImageView) findViewById(R.id.template4);

        Template1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplication(), Template1.class);
                startActivity(i);
            }
        });
        Template2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplication(), Template2.class);
                startActivity(i);
            }
        });

        Template3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplication(), Template3.class);
                startActivity(i);
            }
        });

        Template4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplication(), Template4.class);
                startActivity(i);
            }
        });

    }
}
