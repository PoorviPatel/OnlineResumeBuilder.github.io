package com.example.poorvi.slidertablayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activities extends Fragment {

    TextView text;
    EditText Cocurricural,Extra;
    Button Insert,Display;
    View view;
    DatabaseHelper myDB;

    public Activities() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activities, container, false);
        myDB = new DatabaseHelper(getActivity());


        Cocurricural = (EditText)view.findViewById(R.id.co_curri_act);
        Extra = (EditText)view.findViewById(R.id.extra_act);
        Insert = (Button) view.findViewById(R.id.button);
        //Display = (Button) view.findViewById(R.id.button2);
        //text = (TextView)view.findViewById(R.id.textView);

        addActivities();
        //displayActivities();

        return view;

    }

    public void addActivities() {
        Insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDB.insertActivities(
                        Cocurricural.getText().toString(),
                        Extra.getText().toString()
                );
                //text.setText("Data Inserted");
            }

        });
    }

    /*public void displayActivities(){
        Display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDB = new DatabaseHelper(getActivity());
                DbResponseActivities response = myDB.displayActivities();
                text.setText(response._cocurricular+" - "+response._extra);
            }
        });
    }*/

}
