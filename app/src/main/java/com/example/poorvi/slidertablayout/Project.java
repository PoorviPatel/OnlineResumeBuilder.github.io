package com.example.poorvi.slidertablayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Project extends Fragment {

    TextView text;
    EditText ProjectTitle,Description,FrontEnd,BackEnd,StartDatePi,EndDatePi,TeamMember ;
    Button Insert,Display;
    View view;
    DatabaseHelper myDB;

    public Project() {
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
        View view = inflater.inflate(R.layout.project, container, false);
        myDB = new DatabaseHelper(getActivity());


        ProjectTitle = (EditText)view.findViewById(R.id.project_title);
        Description = (EditText)view.findViewById(R.id.description);
        FrontEnd = (EditText)view.findViewById(R.id.frontend);
        BackEnd = (EditText)view.findViewById(R.id.backend);
        StartDatePi = (EditText)view.findViewById(R.id.startDatePI);
        EndDatePi = (EditText)view.findViewById(R.id.endDatePI);
        TeamMember = (EditText)view.findViewById(R.id.team_member);

        Insert = (Button) view.findViewById(R.id.button);
        /*Display = (Button) view.findViewById(R.id.button2);
        text = (TextView)view.findViewById(R.id.textView);*/

        addProject();
        //displayProject();

        return view;
    }

    public void addProject() {
        Insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDB.insertProject(
                        ProjectTitle.getText().toString(),
                        Description.getText().toString(),
                        FrontEnd.getText().toString(),
                        BackEnd.getText().toString(),
                        StartDatePi.getText().toString(),
                        EndDatePi.getText().toString(),
                        TeamMember.getText().toString()
                );
               // text.setText("Data Inserted");
            }

        });
    }

    /*public void displayProject(){
        Display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDB = new DatabaseHelper(getActivity());
                DbResponseProject response = myDB.displayProject();
                text.setText(response._project_title+" - "+response._description+" - "+response._front_end+" - "+response._back_end+"-"+response._start_date_pi+" - "+response._end_date_pi+"-"+response._team_member);
            }
        });
    }*/
}


