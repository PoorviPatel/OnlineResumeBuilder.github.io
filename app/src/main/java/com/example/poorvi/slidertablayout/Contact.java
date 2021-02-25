package com.example.poorvi.slidertablayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Contact extends Fragment{

    TextView text;
    EditText Name,PhoneNumber,Email,Address ;
    Button Insert,Display;
    View view;
    DatabaseHelper myDB;

    public Contact() {

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.contact, container, false);
        myDB = new DatabaseHelper(getActivity());


        Name = (EditText)view.findViewById(R.id.name);
        PhoneNumber = (EditText)view.findViewById(R.id.phone_no);
        Email = (EditText)view.findViewById(R.id.email);
        Address = (EditText)view.findViewById(R.id.address);
        Insert = (Button) view.findViewById(R.id.button);
        /*Display = (Button) view.findViewById(R.id.button2);
        text = (TextView)view.findViewById(R.id.textView);*/

        addContact();
        //displayContact();

        return view;
    }

    public void addContact() {
        Insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDB.insertContact(
                        Name.getText().toString(),
                        PhoneNumber.getText().toString(),
                        Email.getText().toString(),
                        Address.getText().toString()
                );
                //text.setText("Data Inserted");
            }

        });
    }

    /*public void displayContact(){
        Display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDB = new DatabaseHelper(getActivity());
                DbResponseContact response = myDB.displayContact();
                text.setText(response._name+" - "+response._phone_number+" - "+response._email+" - "+response._address);
            }
        });
    }
*/
    /*public void DBCreate(){
        SQLITEDATABASE = SQLiteDatabase.openOrCreateDatabase("resume.db",null);
        SQLITEDATABASE.execSQL("CREATE TABLE IF NOT EXISTS contact_info_tbl(con_fname TEXT, con_phoneno INTEGER, con_email VARCHAR, con_address TEXT);");
    }
    public void SubmitData2SQLiteDB(){
        name = Name.getText().toString();
        phoneNumber = PhoneNumber.getText().toString();
        email = Email.getText().toString();
        address = Address.getText().toString();
        CheckEditTextIsEmptyOrNot( name,phoneNumber, email, address);
        if(CheckEditTextEmpty == true)
        {
            SQLiteQuery = "INSERT INTO contact_info_tbl (con_fname,con_phoneno,con_email,con_address) VALUES('"+name+"', '"+phoneNumber+"', '"+email+"', '"+address+"');";
            SQLITEDATABASE.execSQL(SQLiteQuery);
            text.setText("Inserted");
            Toast.makeText(getActivity(),"Data Inserted Successfully", Toast.LENGTH_LONG).show();
            ClearEditTextAfterDoneTask();
        }
        else {
            Toast.makeText(getActivity(),"Please Fill All the Fields", Toast.LENGTH_LONG).show();
        }
    }

    public void CheckEditTextIsEmptyOrNot(String Name,String PhoneNumber, String Email, String Address ){
        if(TextUtils.isEmpty(Name) || TextUtils.isEmpty(PhoneNumber) || TextUtils.isEmpty(Email) || TextUtils.isEmpty(Address)){
            CheckEditTextEmpty = false ;
        }
        else {
            CheckEditTextEmpty = true ;
        }
    }

    public void ClearEditTextAfterDoneTask(){
        Name.getText().clear();
        PhoneNumber.getText().clear();
        Email.getText().clear();
        Address.getText().clear();
    }*/
}
