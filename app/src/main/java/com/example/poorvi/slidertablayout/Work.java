package com.example.poorvi.slidertablayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Work extends Fragment {

    TextView text;
    EditText Designation,Organization,StartDateWe,EndDateWe,Role ;
    Button Insert,Display;
    View view;
    DatabaseHelper myDB;

    public Work() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragmentView
        view = inflater.inflate(R.layout.work, container, false);
        myDB = new DatabaseHelper(getActivity());


        Designation = (EditText)view.findViewById(R.id.designation);
        Organization = (EditText)view.findViewById(R.id.organization);
        StartDateWe = (EditText)view.findViewById(R.id.startDateWE);
        EndDateWe = (EditText)view.findViewById(R.id.endDateWE);
        Role = (EditText)view.findViewById(R.id.role) ;

        Insert = (Button) view.findViewById(R.id.button);
        /*Display = (Button) view.findViewById(R.id.button2);
        text = (TextView)view.findViewById(R.id.textView);
*/
        addWork();
        //displayWork();

        return view;
    }

    public void addWork() {
        Insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDB.insertWork(
                        Designation.getText().toString(),
                        Organization.getText().toString(),
                        StartDateWe.getText().toString(),
                        EndDateWe.getText().toString(),
                        Role.getText().toString()
                );
                //text.setText("Data Inserted");
            }

        });
    }

    /*public void displayWork(){
        Display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDB = new DatabaseHelper(getActivity());
                DbResponseWork response = myDB.displayWork();
                text.setText(response._designation+" - "+response._organization+" - "+response._start_date_we+" - "+response._end_date_we+" - "+response._role);
            }
        });
    }*/
}
