package com.example.poorvi.slidertablayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Personal extends Fragment{

    TextView text;
    EditText Dob,MaritalStatus,Hobbies,AddOtherInfoP ;
    private RadioGroup RadioGrp;
    private RadioButton RadioBtn;
    Button Insert,Display;
    View view;
    DatabaseHelper myDB;

    public Personal() {
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
        final View view = inflater.inflate(R.layout.personal, container, false);
        myDB = new DatabaseHelper(getActivity());


        Dob = (EditText)view.findViewById(R.id.dob);
        MaritalStatus = (EditText)view.findViewById(R.id.marital_status);
        Hobbies = (EditText)view.findViewById(R.id.hobbies);
        RadioGrp = (RadioGroup)view.findViewById(R.id.radioGroup);

        AddOtherInfoP = (EditText)view.findViewById(R.id.other_info_p);

        Insert = (Button) view.findViewById(R.id.button);
        /*Display = (Button) view.findViewById(R.id.button2);
        text = (TextView)view.findViewById(R.id.textView);*/



        RadioGrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioBtn=(RadioButton)view.findViewById(checkedId);
            }
        });

        addPersonal();
       // displayPersonal();

        return view;
    }

    public void addPersonal() {
        Insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDB.insertPersonal(
                        Dob.getText().toString(),
                        MaritalStatus.getText().toString(),
                        RadioBtn.getText().toString(),
                        Hobbies.getText().toString(),
                        AddOtherInfoP.getText().toString()
                );
                //text.setText("Data Inserted");
            }

        });
    }

    /*public void displayPersonal(){
        Display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDB = new DatabaseHelper(getActivity());
                DbResponsePersonal response = myDB.displayPersonal();
                text.setText(response._dob+" - "+response._marital_status+" - "+response._gender+" - "+response._hobbies+" - "+response._add_other_info_p);
            }
        });
    }*/
}
