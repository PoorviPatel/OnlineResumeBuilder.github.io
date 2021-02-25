package com.example.poorvi.slidertablayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Objective extends Fragment{

    TextView text;
    EditText Description;
    Button Insert,Display;
    View view;
    DatabaseHelper myDB;

    public Objective() {
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
        View view = inflater.inflate(R.layout.objective, container, false);
        myDB = new DatabaseHelper(getActivity());


        Description = (EditText)view.findViewById(R.id.description);
        Insert = (Button) view.findViewById(R.id.button);
        /*Display = (Button) view.findViewById(R.id.button2);
        text = (TextView)view.findViewById(R.id.textView);
*/
        addObjective();
        //displayObjective();

        return view;

    }
    public void addObjective() {
        Insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDB.insertObjective(
                        Description.getText().toString()
                );
//                text.setText("Data Inserted");
                /*Intent intent = new Intent();
                intent.putExtra("text", Description.getText().toString());
                //start the second activity
                startActivity(intent);*/
            }

        });
    }

    /*public void displayObjective(){
        Display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDB = new DatabaseHelper(getActivity());
                DbResponseObjective response = myDB.displayObjective();
                text.setText(response._description);

                Intent intent=new Intent(getActivity(), Template1.class);
                //add data to the Intent object

            }
        });
    }
*/
}
