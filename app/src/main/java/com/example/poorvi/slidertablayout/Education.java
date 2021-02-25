package com.example.poorvi.slidertablayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Education extends Fragment {

    TextView text;
    EditText CourseName,InstituteName,StartDateEt,EndDateEt,PercentageCgpa,AddOtherInfo ;
    Button Insert,Display;
    View view;
    DatabaseHelper myDB;

    public Education() {
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
        View view = inflater.inflate(R.layout.education, container, false);
        myDB = new DatabaseHelper(getActivity());


        CourseName = (EditText)view.findViewById(R.id.cource);
        InstituteName = (EditText)view.findViewById(R.id.institute);
        StartDateEt = (EditText)view.findViewById(R.id.startDateET);
        EndDateEt = (EditText)view.findViewById(R.id.endDateET);
        PercentageCgpa = (EditText)view.findViewById(R.id.percentageCgpa);
        AddOtherInfo = (EditText)view.findViewById(R.id.otherInfoET);

        Insert = (Button) view.findViewById(R.id.button);
        Display = (Button) view.findViewById(R.id.button2);
        text = (TextView)view.findViewById(R.id.textView);

        addEducation();
        //displayEducation();

        return view;
    }
    public void addEducation() {
        Insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDB.insertEducation(
                        CourseName.getText().toString(),
                        InstituteName.getText().toString(),
                        StartDateEt.getText().toString(),
                        EndDateEt.getText().toString(),
                        PercentageCgpa.getText().toString(),
                        AddOtherInfo.getText().toString()
                );
//                text.setText("Data Inserted");
            }
        });
    }

    /*public void displayEducation(){
        Display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDB = new DatabaseHelper(getActivity());
                *//*DbResponseEducation response = myDB.displayEducation();
                text.setText(response._course_name+" - "+response._institute_name+" - "+response._start_date_et+" - "+response._end_date_et+" - "+response._percentage_Cgpa+" - "+response._add_other_information);
        *//*
                List<DbResponseEducation> educations = myDB.display();

                for (DbResponseEducation ed : educations) {
                    String log = "ID :"+ed.get_id()+ "Course: " + ed.get_course_name() ;
                    // Writing Contacts to log
                    Log.d("Course: ", log);
                    text.append(ed._id+ " - "+ ed._course_name + " - " + ed._institute_name + " - " + ed._start_date_et + " - " + ed._end_date_et + " - " + ed._percentage_Cgpa + " - " + ed._add_other_information);

                }
            }
        });*/

    }


