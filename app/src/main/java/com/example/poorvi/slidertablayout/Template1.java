package com.example.poorvi.slidertablayout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

public class Template1 extends Activity implements OnClickListener {

    DatabaseHelper myDB = new DatabaseHelper(this);

    private LinearLayout linearLayout;
    private Button saveBtn, email;
    File pictureFileDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "Handcare");
    File pdfDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "MyApp");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.template1);

        linearLayout = (LinearLayout) findViewById(R.id.activity_activities);
        saveBtn = (Button) findViewById(R.id.button);
        saveBtn.setOnClickListener(this);
        email = (Button) findViewById(R.id.button1);
        email.setOnClickListener(this);

        TextView name = (TextView) findViewById(R.id.t1_name);
        TextView phone = (TextView) findViewById(R.id.t1_phno);
        TextView email = (TextView) findViewById(R.id.t1_email);
        //TextView address  = (TextView) findViewById(R.id.t1_address);


        TextView obj = (TextView) findViewById(R.id.t1_obj);


        TextView course = (TextView) findViewById(R.id.t1_education1);
        TextView institute = (TextView) findViewById(R.id.t1_education2);
        /*TextView start_ed = (TextView) findViewById(R.id.startDateET);
        TextView end_ed = (TextView) findViewById(R.id.endDateET);
        TextView per_cgpa = (TextView) findViewById(R.id.percentageCgpa);
        TextView add_other = (TextView) findViewById(R.id.otherInfoET);*/

        /*course.setText("");
        institute.setText("");*/
        /*start_ed.setText("");
        end_ed.setText("");
        per_cgpa.setText("");
        add_other.setText("");*/

        TextView title = (TextView) findViewById(R.id.t1_pro_title);
        TextView desc_pro = (TextView) findViewById(R.id.t1_description);
        TextView front_end = (TextView) findViewById(R.id.t1_frontend);
        TextView back_end = (TextView) findViewById(R.id.t1_back_end);
        TextView start_pro = (TextView) findViewById(R.id.t1_date);
        //TextView end_pro = (TextView) findViewById(R.id.);
        TextView team_member = (TextView) findViewById(R.id.t1_team_member);

        /*title.setText("");
        desc_pro.setText("");
        front_end.setText("");
        back_end.setText("");
        start_pro.setText("");
        team_member.setText("");*/

        TextView designation = (TextView) findViewById(R.id.t1_designation);
        TextView organization = (TextView) findViewById(R.id.t1_organization);
        //TextView start_exp = (TextView) findViewById(R.id.t1_start_exp);
        //TextView end_exp = (TextView) findViewById(R.id.t1_end_exp);
        TextView role = (TextView) findViewById(R.id.t1_role);

        /*designation.setText("");
        organization.setText("");
        role.setText("");*/


        TextView dob = (TextView) findViewById(R.id.t1_dob);
        TextView marital = (TextView) findViewById(R.id.t1_marital);
        TextView hobbies = (TextView) findViewById(R.id.t1_hobbies);
        TextView gender = (TextView) findViewById(R.id.t1_gender);
        //TextView add_other_per = (TextView) findViewById(R.id.t1_other_per);

        //TextView co_curricular = (TextView) findViewById(R.id.t1_co_curri);
        //TextView extra = (TextView) findViewById(R.id.t1_extra);


        TextView language = (TextView) findViewById(R.id.t1_lang);
        TextView technical = (TextView) findViewById(R.id.t1_tech_skill);
        //TextView othee_skills = (TextView) findViewById(R.id.t1_other_skills);
        //TextView strength = (TextView) findViewById(R.id.t1_strength);
        //TextView field_of_interest = (TextView) findViewById(R.id.t1_field_of_interest);


        DbResponseContact contact = myDB.displayContact();
        name.setText(contact._name);
        phone.setText(contact._phone_number);
        email.setText(contact._email);


        DbResponseObjective objective = myDB.displayObjective();
        obj.setText(objective._description);


        List<DbResponseEducation> educations = myDB.display();
        for (DbResponseEducation ed : educations) {
            //DbResponseEducation education = myDB.displayEducation();
            course.append(ed._course_name + " with " + ed._percentage_Cgpa + " during " + ed._start_date_et + " to " + ed._end_date_et + " in " + ed._institute_name + "\n");
        }//institute.setText(education._course_name+" with "+education._percentage_Cgpa+" during "+education._start_date_et+" to "+education._end_date_et+" in "+education._institute_name);


        List<DbResponseProject> projects = myDB.displayProject();
        for (DbResponseProject pro : projects) {
            //DbResponseEducation education = myDB.displayEducation();
            title.append(pro._project_title + " \n " + pro._description + " \n " + "Front End : " + pro._start_date_pi + "\n " + "Back End :" + pro._end_date_pi + "\n " + "Duration :" + pro._front_end + " to " + pro._back_end + " \n " + "Team Members :" + pro._team_member + "\n");
            /*title.append(pro._project_title);
            desc_pro.append(pro._description);
            front_end.append("Front End  :"+pro._start_date_pi);
            back_end.append("Back End  :"+pro._end_date_pi);
            start_pro.append("Duration  :"+pro._front_end+" to "+pro._back_end);
            team_member.append("Team Member  :"+pro._team_member);
        }*/

            List<DbResponseWork> works = myDB.displayWork();
            for (DbResponseWork we : works) {
                //DbResponseEducation education = myDB.displayEducation();
                designation.append("Designation :" + we._designation + " \n " + "Organization :" + we._organization + " \n "+"Duration :"+we._start_date_we+" to "+we._end_date_we+"\n" + "Role :" + we._role + "\n");
            /*designation.setText(we._designation);
            organization.setText(we._organization);
            role.setText(we._role);*/

            }


            DbResponsePersonal personal = myDB.displayPersonal();
            dob.setText(personal._dob);
            marital.setText(personal._marital_status);
            hobbies.setText(personal._hobbies);
            gender.setText(personal._gender);


            DbResponseActivities activities = myDB.displayActivities();


            DbResponseOther other = myDB.displayOther();
            language.setText(other._language_known);
            technical.setText(other._technical_skills);


        }
    }

        //obj.setText(getIntent().getStringExtra("text"));
        //Intent intent = getIntent();
        //String name = intent.getStringExtra("text");


    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.button:
                File file = saveBitMap(this, linearLayout);    //which view you want to pass that view as parameter
                if (file != null) {
                    Log.i("TAG", "Drawing saved to the gallery!");
                } else {
                    Log.i("TAG", "Oops! Image could not be saved.");
                }
                try {
                    Document document = new Document();
                    if (!pdfDir.exists()){
                        pdfDir.mkdir();
                    }
                    PdfWriter.getInstance(document, new FileOutputStream(pdfDir + "/example.pdf")); //  Change pdf's name.
                    document.open();
                    Image img = Image.getInstance(pictureFileDir + "/" + "yourImageHere.jpg");  // Change image's name and extension.

                    float scaler = ((document.getPageSize().getWidth() - document.leftMargin()
                            - document.rightMargin() - 0) / img.getWidth()) * 100; // 0 means you have no indentation. If you have any, change it.
                    img.scalePercent(scaler);
                    img.setAlignment(Image.ALIGN_CENTER | Image.ALIGN_TOP);
                    //img.setAlignment(Image.LEFT| Image.TEXTWRAP);

                     /* float width = document.getPageSize().width() - document.leftMargin() - document.rightMargin();
                     float height = document.getPageSize().height() - document.topMargin() - document.bottomMargin();
                     img.scaleToFit(width, height)*/
                                        //   Or try this.

                    document.add(img);
                    document.close();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (BadElementException e) {
                    e.printStackTrace();
                } catch (DocumentException e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(Intent.ACTION_VIEW);
                Uri uri = Uri.fromFile(new File(pdfDir,  "example.pdf"));
                intent.setDataAndType(uri, "application/pdf");
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
                
                break;
            case R.id.button1:
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, "receiver_email_address");
                email.putExtra(Intent.EXTRA_SUBJECT, "subject");
                email.putExtra(Intent.EXTRA_TEXT, "email body");
                uri = Uri.fromFile(new File(pdfDir,  "example.pdf"));
                email.putExtra(Intent.EXTRA_STREAM, uri);
                email.setType("application/pdf");
                email.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(Intent.createChooser(email, "Send Email"));
                break;
            default:
                break;
        }
    }

    private File saveBitMap(Context context, View drawView) {

        if (!pictureFileDir.exists()) {
            boolean isDirectoryCreated = pictureFileDir.mkdirs();
            if (!isDirectoryCreated)
                Log.i("ATG", "Can't create directory to save the image");
            return null;
        }
        String filename = pictureFileDir.getPath() + File.separator + "yourImageHere" + ".jpg";
        File pictureFile = new File(filename);
        Bitmap bitmap = getBitmapFromView(drawView);
        try {
            pictureFile.createNewFile();
            FileOutputStream oStream = new FileOutputStream(pictureFile);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, oStream);
            oStream.flush();
            oStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            Log.i("TAG", "There was an issue saving the image.");
        }
        scanGallery(context, pictureFile.getAbsolutePath());
        return pictureFile;
    }

    //create bitmap from view and returns it
    private Bitmap getBitmapFromView(View view) {
        //Define a bitmap with the same size as the view
        Bitmap returnedBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        //Bind a canvas to it
        Canvas canvas = new Canvas(returnedBitmap);
        //Get the view's background
        Drawable bgDrawable = view.getBackground();
        if (bgDrawable != null) {
            //has background drawable, then draw it on the canvas
            bgDrawable.draw(canvas);
        } else {
            //does not have background drawable, then draw white background on the canvas
            canvas.drawColor(Color.WHITE);
        }
        // draw the view on the canvas
        view.draw(canvas);
        //return the bitmap
        return returnedBitmap;
    }

    // used for scanning gallery
    private void scanGallery(Context cntx, String path) {
        try {
            MediaScannerConnection.scanFile(cntx, new String[]{path}, null, new MediaScannerConnection.OnScanCompletedListener() {
                public void onScanCompleted(String path, Uri uri) {
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
