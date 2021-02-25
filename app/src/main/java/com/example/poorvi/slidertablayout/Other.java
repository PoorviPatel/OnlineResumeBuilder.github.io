package com.example.poorvi.slidertablayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Other extends Fragment {

    TextView text;
    EditText LanguageKnown,TechnicalSkills,OtherSkills,Strength,FieldOfInterest ;
    Button Insert,Display;
    View view;
    DatabaseHelper myDB;

    public Other() {
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
        View view = inflater.inflate(R.layout.other, container, false);
        myDB = new DatabaseHelper(getActivity());


        LanguageKnown = (EditText)view.findViewById(R.id.language);
        TechnicalSkills = (EditText)view.findViewById(R.id.tech_skills);
        OtherSkills = (EditText)view.findViewById(R.id.other_skills);
        Strength = (EditText)view.findViewById(R.id.strength);
        FieldOfInterest = (EditText)view.findViewById(R.id.foi);

        Insert = (Button) view.findViewById(R.id.button);
        Display = (Button) view.findViewById(R.id.button2);
        text = (TextView)view.findViewById(R.id.textView);

        addOther();
        displayOther();

        return view;
    }

    public void addOther() {
        Insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDB.insertOther(
                        LanguageKnown.getText().toString(),
                        TechnicalSkills.getText().toString(),
                        OtherSkills.getText().toString(),
                        Strength.getText().toString(),
                        FieldOfInterest.getText().toString()
                );
               // text.setText("Data Inserted");
            }

        });
    }

    public void displayOther(){
        Display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDB = new DatabaseHelper(getActivity());
                DbResponseOther response = myDB.displayOther();
                //text.setText(response._language_known+" - "+response._technical_skills+" - "+response._other_skills+" - "+response._strength+" - "+response._field_of_interest);

                Intent intent=new Intent(getActivity(), Template.class);
                startActivity(intent);
            }
        });
    }

}
