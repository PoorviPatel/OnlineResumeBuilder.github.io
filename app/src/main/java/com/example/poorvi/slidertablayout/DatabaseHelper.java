package com.example.poorvi.slidertablayout;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "resume.db";

    public static final String CONTACT_TBL="contact_info_tbl";
    public static final String OBJECTIVE_TBL = "objective_tbl";
    public static final String PERSONAL_TBL ="personal_tbl";
    public static final String EDUCATION_TBL="education_tbl";
    public static final String PROJECT_TBL="project_tbl";
    public static final String WORK_EXP_TBL="work_exp_tbl";
    public static final String CURRICULAR_ACTIVITY_TBL ="curricular_activity_tbl";
    public static final String OTHER_INFO_TBL="other_info_tbl";

    public static final String COL_OBJECTIVE_DESCRIPTION = "objective_description";

    public static final String COL_PERSONAL_DOB="per_dob";
    public static final String COL_PERSONAL_MARITAL_STATUS="per_marital_status";
    public static final String COL_PERSONAL_HOBBIES="per_hobbies";
    public static final String COL_PERSONAL_GENDER="per_gender";
    public static final String COL_PERSONAL_ADD_OTHER_INFO_P="per_add_other";

    public static final String COL_CONTACT_INFO_FNAME="con_fname";
    public static final String COL_CONTACT_INFO_PHONENO="con_phoneno";
    public static final String COL_CONTACT_INFO_EMAIL="con_email";
    public static final String COL_CONTACT_INFO_ADDRESS="con_address";

    public static final String COL_EDU_INFO_COURSENAME="edu_coursename";
    public static final String COL_EDU_INFO_INSNAME="edu_insname";
    public static final String COL_EDU_INFO_SDATE="edu_sdate";
    public static final String COL_EDU_INFO_EDATE="edu_edate";
    public static final String COL_EDU_INFO_PER_CGPA="edu_per_cgpa";
    public static final String COL_EDU_INFO_ADD_OTHHER="edu_add_other";
    public static final String COLUMN_ID ="id" ;

    public static final String COL_PRO_INFO_PRONAME="pro_proname";
    public static final String COL_PRO_INFO_DES="pro_des";
    public static final String COL_PRO_INFO_FRONT_END="pro_front_end";
    public static final String COL_PRO_INFO_BACK_END="pro_back_end";
    public static final String COL_PRO_INFO_SDATE="pro_sdate";
    public static final String COL_PRO_INFO_EDATE="pro_edate";
    public static final String COL_PRO_INFO_TMEMBER="pro_tmember";

    public static final String COL_WORK_EXP_DESIG="work_desig";
    public static final String COL_WORK_EXP_ORG="work_org";
    public static final String COL_WORK_EXP_SDATE="work_sdate";
    public static final String COL_WORK_EXP_EDATE="work_edate";
    public static final String COL_WORK_EXP_ROLE="work_role";


    public static final String COL_CURRICULAR_CO_CURR="curr_co_curr";
    public static final String COL_CURRICULAR_EXTRA_ACT="curr_extra_act";


    public static final String COL_OTHER_INFO_LAN_KNOWN="other_lan_known";
    public static final String COL_OTHER_INFO_TECH_SKILL="other_tech_skill";
    public static final String COL_OTHER_INFO_OTHER_SKILL="other_other_skill";
    public static final String COL_OTHER_INFO_STRENGTH="other_strength";
    public static final String COL_OTHER_INFO_FIELD_INTEREST="other_field_interest";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String objective_tbl= "CREATE TABLE "+OBJECTIVE_TBL+" ( "+COL_OBJECTIVE_DESCRIPTION+" TEXT )";
        db.execSQL(objective_tbl);

        String personal_tbl="CREATE TABLE "+PERSONAL_TBL+" ( "+COL_PERSONAL_DOB+" DATE,"+COL_PERSONAL_MARITAL_STATUS+" TEXT,"+COL_PERSONAL_HOBBIES+" TEXT,"+COL_PERSONAL_GENDER+" TEXT,"+COL_PERSONAL_ADD_OTHER_INFO_P+" TEXT)";
        db.execSQL(personal_tbl);

        String create_table ="CREATE TABLE "+CONTACT_TBL+" ( "+COL_CONTACT_INFO_FNAME+" TEXT,"+COL_CONTACT_INFO_PHONENO+" INTEGER,"+COL_CONTACT_INFO_EMAIL+" VARCHAR,"+COL_CONTACT_INFO_ADDRESS+" TEXT)";
        db.execSQL(create_table);

        String education_tbl="CREATE TABLE "+EDUCATION_TBL+" ( "+ COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+COL_EDU_INFO_COURSENAME+" TEXT,"+COL_EDU_INFO_INSNAME+" TEXT,"+COL_EDU_INFO_SDATE+" DATE,"+COL_EDU_INFO_EDATE+" DATE,"+COL_EDU_INFO_PER_CGPA+" TEXT,"+COL_EDU_INFO_ADD_OTHHER+" TEXT)";
        db.execSQL(education_tbl);

        String project_tbl="CREATE TABLE "+PROJECT_TBL+" ( "+COL_PRO_INFO_PRONAME+" TEXT,"+COL_PRO_INFO_DES+" TEXT,"+COL_PRO_INFO_FRONT_END+" TEXT,"+COL_PRO_INFO_BACK_END+" TEXT,"+COL_PRO_INFO_SDATE+" DATE,"+COL_PRO_INFO_EDATE+" DATE,"+COL_PRO_INFO_TMEMBER+" TEXT)";
        db.execSQL(project_tbl);

        String work_exp_tbl="CREATE TABLE "+WORK_EXP_TBL+" ( "+COL_WORK_EXP_DESIG+" TEXT,"+COL_WORK_EXP_ORG+" TEXT,"+COL_WORK_EXP_SDATE+" DATE,"+COL_WORK_EXP_EDATE+" DATE,"+COL_WORK_EXP_ROLE+" TEXT)";
        db.execSQL(work_exp_tbl);

        String curricular_activity_tbl="CREATE TABLE "+ CURRICULAR_ACTIVITY_TBL +" ( "+COL_CURRICULAR_CO_CURR+" TEXT ,"+COL_CURRICULAR_EXTRA_ACT+" TEXT)";
        db.execSQL(curricular_activity_tbl);

        String other_info_tbl="CREATE TABLE "+OTHER_INFO_TBL+" ( "+COL_OTHER_INFO_LAN_KNOWN+" TEXT,"+COL_OTHER_INFO_TECH_SKILL+" TEXT,"+COL_OTHER_INFO_OTHER_SKILL+" TEXT,"+COL_OTHER_INFO_STRENGTH+" TEXT,"+COL_OTHER_INFO_FIELD_INTEREST+" TEXT)";
        db.execSQL(other_info_tbl);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS"+OBJECTIVE_TBL);
        onCreate(db);
        db.execSQL("drop table if exists "+PERSONAL_TBL);
        onCreate(db);
        db.execSQL("drop table if exists "+CONTACT_TBL);
        onCreate(db);
        db.execSQL("drop table if exists "+EDUCATION_TBL);
        onCreate(db);
        db.execSQL("drop table if exists "+PROJECT_TBL);
        onCreate(db);
        db.execSQL("drop table if exists "+WORK_EXP_TBL);
        onCreate(db);
        db.execSQL("drop table if exists "+ CURRICULAR_ACTIVITY_TBL);
        onCreate(db);
        db.execSQL("drop table if exists "+OTHER_INFO_TBL);
        onCreate(db);
    }

    public boolean insertContact(String name, String phno, String email, String address) {

        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_CONTACT_INFO_FNAME, name);
        contentValues.put(COL_CONTACT_INFO_PHONENO, phno);
        contentValues.put(COL_CONTACT_INFO_EMAIL, email);
        contentValues.put(COL_CONTACT_INFO_ADDRESS, address);
        long result = database.insert(CONTACT_TBL, null, contentValues);

        //check if value is -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public DbResponseContact displayContact(){

        DbResponseContact contact = new DbResponseContact();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + CONTACT_TBL, null);
        if (cursor.moveToFirst()) {
            do {
                contact._name = cursor.getString(cursor.getColumnIndex(COL_CONTACT_INFO_FNAME));
                contact._phone_number = cursor.getString(cursor.getColumnIndex(COL_CONTACT_INFO_PHONENO));
                contact._email = cursor.getString(cursor.getColumnIndex(COL_CONTACT_INFO_EMAIL));
                contact._address = cursor.getString(cursor.getColumnIndex(COL_CONTACT_INFO_ADDRESS));

            } while (cursor.moveToNext());
        }
        cursor.close();
        return contact;
    }



    public boolean insertObjective(String description) {

        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_OBJECTIVE_DESCRIPTION, description);
        long result = database.insert(OBJECTIVE_TBL, null, contentValues);

        //check if value is -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }


    public DbResponseObjective displayObjective(){

        DbResponseObjective objective = new DbResponseObjective();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + OBJECTIVE_TBL, null);
        if (cursor.moveToFirst()) {
            do {
                objective._description = cursor.getString(cursor.getColumnIndex(COL_OBJECTIVE_DESCRIPTION));

            } while (cursor.moveToNext());
        }
        cursor.close();
        return objective;
    }



    public boolean insertEducation(String coursename, String institutename, String startdateet, String enddateet, String percentagecgpa, String addotherinfo) {

        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_EDU_INFO_COURSENAME, coursename);
        contentValues.put(COL_EDU_INFO_INSNAME, institutename);
        contentValues.put(COL_EDU_INFO_SDATE, startdateet);
        contentValues.put(COL_EDU_INFO_EDATE, enddateet);
        contentValues.put(COL_EDU_INFO_PER_CGPA, percentagecgpa);
        contentValues.put(COL_EDU_INFO_ADD_OTHHER, addotherinfo);
        long result = database.insert(EDUCATION_TBL, null, contentValues);

        //check if value is -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public DbResponseEducation displayEducation(){

        DbResponseEducation education = new DbResponseEducation();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + EDUCATION_TBL, null);
        if (cursor.moveToFirst()) {
            do {
                education._course_name = cursor.getString(cursor.getColumnIndex(COL_EDU_INFO_COURSENAME));
                education._institute_name = cursor.getString(cursor.getColumnIndex(COL_EDU_INFO_INSNAME));
                education._start_date_et = cursor.getString(cursor.getColumnIndex(COL_EDU_INFO_SDATE));
                education._end_date_et = cursor.getString(cursor.getColumnIndex(COL_EDU_INFO_EDATE));
                education._percentage_Cgpa = cursor.getString(cursor.getColumnIndex(COL_EDU_INFO_PER_CGPA));
                education._add_other_information = cursor.getString(cursor.getColumnIndex(COL_EDU_INFO_ADD_OTHHER));

            } while (cursor.moveToNext());
        }
        cursor.close();
        return education;
    }





    public boolean insertProject(String projecttitle, String description, String startdatepi, String enddatepi, String frontend, String backend, String teammember) {

        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_PRO_INFO_PRONAME, projecttitle);
        contentValues.put(COL_PRO_INFO_DES, description);
        contentValues.put(COL_PRO_INFO_FRONT_END, frontend);
        contentValues.put(COL_PRO_INFO_BACK_END, backend);
        contentValues.put(COL_PRO_INFO_SDATE, startdatepi);
        contentValues.put(COL_PRO_INFO_EDATE, enddatepi);
        contentValues.put(COL_PRO_INFO_TMEMBER, teammember);
        long result = database.insert(PROJECT_TBL, null, contentValues);

        //check if value is -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    /*public DbResponseProject displayProject(){

        DbResponseProject project = new DbResponseProject();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + PROJECT_TBL, null);
        if (cursor.moveToFirst()) {
            do {
                project._project_title = cursor.getString(cursor.getColumnIndex(COL_PRO_INFO_PRONAME));
                project._description = cursor.getString(cursor.getColumnIndex(COL_PRO_INFO_DES));
                project._front_end = cursor.getString(cursor.getColumnIndex(COL_PRO_INFO_FRONT_END));
                project._back_end = cursor.getString(cursor.getColumnIndex(COL_PRO_INFO_BACK_END));
                project._start_date_pi = cursor.getString(cursor.getColumnIndex(COL_PRO_INFO_SDATE));
                project._end_date_pi = cursor.getString(cursor.getColumnIndex(COL_PRO_INFO_EDATE));
                project._team_member = cursor.getString(cursor.getColumnIndex(COL_PRO_INFO_TMEMBER));
                
            } while (cursor.moveToNext());
        }
        cursor.close();
        return project;
    }*/



    public boolean insertWork(String designation, String organization, String startdatewe, String enddatewe, String role) {

        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_WORK_EXP_DESIG, designation);
        contentValues.put(COL_WORK_EXP_ORG, organization);
        contentValues.put(COL_WORK_EXP_SDATE, startdatewe);
        contentValues.put(COL_WORK_EXP_EDATE, enddatewe);
        contentValues.put(COL_WORK_EXP_ROLE, role);
        long result = database.insert(WORK_EXP_TBL, null, contentValues);

        //check if value is -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    /*public DbResponseWork displayWork(){

        DbResponseWork work = new DbResponseWork();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + WORK_EXP_TBL, null);
        if (cursor.moveToFirst()) {
            do {
                work._designation = cursor.getString(cursor.getColumnIndex(COL_WORK_EXP_DESIG));
                work._organization = cursor.getString(cursor.getColumnIndex(COL_WORK_EXP_ORG));
                work._start_date_we = cursor.getString(cursor.getColumnIndex(COL_WORK_EXP_SDATE));
                work._end_date_we = cursor.getString(cursor.getColumnIndex(COL_WORK_EXP_EDATE));
                work._role = cursor.getString(cursor.getColumnIndex(COL_WORK_EXP_ROLE));

            } while (cursor.moveToNext());
        }
        cursor.close();
        return work;
    }
*/


    public boolean insertPersonal(String dob, String marital, String gender, String hobbies, String addother) {

        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_PERSONAL_DOB, dob);
        contentValues.put(COL_PERSONAL_MARITAL_STATUS, marital);
        contentValues.put(COL_PERSONAL_GENDER, gender);
        contentValues.put(COL_PERSONAL_HOBBIES, hobbies);
        contentValues.put(COL_PERSONAL_ADD_OTHER_INFO_P, addother);
        long result = database.insert(PERSONAL_TBL, null, contentValues);

        //check if value is -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public DbResponsePersonal displayPersonal(){

        DbResponsePersonal personal = new DbResponsePersonal();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + PERSONAL_TBL, null);
        if (cursor.moveToFirst()) {
            do {
                personal._dob = cursor.getString(cursor.getColumnIndex(COL_PERSONAL_DOB));
                personal._marital_status = cursor.getString(cursor.getColumnIndex(COL_PERSONAL_MARITAL_STATUS));
                personal._gender = cursor.getString(cursor.getColumnIndex(COL_PERSONAL_GENDER));
                personal._hobbies = cursor.getString(cursor.getColumnIndex(COL_PERSONAL_HOBBIES));
                personal._add_other_info_p = cursor.getString(cursor.getColumnIndex(COL_PERSONAL_ADD_OTHER_INFO_P
                ));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return personal;
    }

    public boolean insertActivities(String cocurricualar, String extra) {
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_CURRICULAR_CO_CURR, cocurricualar);
        contentValues.put(COL_CURRICULAR_EXTRA_ACT, extra);
        long result = database.insert(CURRICULAR_ACTIVITY_TBL, null, contentValues);

        //check if value is -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }

    }

    public DbResponseActivities displayActivities() {
        DbResponseActivities activities = new DbResponseActivities();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + CURRICULAR_ACTIVITY_TBL, null);
        if (cursor.moveToFirst()) {
            do {
                activities._cocurricular = cursor.getString(cursor.getColumnIndex(COL_CURRICULAR_CO_CURR));
                activities._extra = cursor.getString(cursor.getColumnIndex(COL_CURRICULAR_EXTRA_ACT));

            } while (cursor.moveToNext());
        }
        cursor.close();
        return activities;

    }

    public boolean insertOther(String language, String technical, String other, String strength, String foi) {

        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_OTHER_INFO_LAN_KNOWN, language);
        contentValues.put(COL_OTHER_INFO_TECH_SKILL, technical);
        contentValues.put(COL_OTHER_INFO_OTHER_SKILL, other);
        contentValues.put(COL_OTHER_INFO_STRENGTH, strength);
        contentValues.put(COL_OTHER_INFO_FIELD_INTEREST, foi);
        long result = database.insert(OTHER_INFO_TBL, null, contentValues);

        //check if value is -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public DbResponseOther displayOther(){

        DbResponseOther other = new DbResponseOther();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + OTHER_INFO_TBL, null);
        if (cursor.moveToFirst()) {
            do {
                other._language_known = cursor.getString(cursor.getColumnIndex(COL_OTHER_INFO_LAN_KNOWN));
                other._technical_skills = cursor.getString(cursor.getColumnIndex(COL_OTHER_INFO_TECH_SKILL));
                other._other_skills = cursor.getString(cursor.getColumnIndex(COL_OTHER_INFO_OTHER_SKILL));
                other._strength = cursor.getString(cursor.getColumnIndex(COL_OTHER_INFO_STRENGTH));
                other._field_of_interest = cursor.getString(cursor.getColumnIndex(COL_OTHER_INFO_FIELD_INTEREST));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return other;
    }

    public List<DbResponseEducation> display() {
        List<DbResponseEducation> educationlist = new ArrayList<DbResponseEducation>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + EDUCATION_TBL;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                DbResponseEducation education = new DbResponseEducation();
                education.set_id(cursor.getString(0));
                education.set_course_name(cursor.getString(1));
                education.set_institute_name(cursor.getString(2));
                education.set_start_date_et(cursor.getString(3));
                education.set_end_date_et(cursor.getString(4));
                education.set_percentage_Cgpa(cursor.getString(5));
                education.set_add_other_information(cursor.getString(6));

                // Adding contact to list
                educationlist.add(education);

            } while (cursor.moveToNext());
        }
        // return contact list
        return educationlist;
    }

    public List<DbResponseProject> displayProject() {
        List<DbResponseProject> projectList = new ArrayList<DbResponseProject>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + PROJECT_TBL;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                DbResponseProject project = new DbResponseProject();
                //project.set_id_pro(cursor.getString(0));
                project.set_project_title(cursor.getString(0));
                project.set_description(cursor.getString(1));
                project.set_front_end(cursor.getString(2));
                project.set_back_end(cursor.getString(3));
                project.set_start_date_pi(cursor.getString(4));
                project.set_end_date_pi(cursor.getString(5));
                project.set_team_member(cursor.getString(6));

                // Adding contact to list
                projectList.add(project);

            } while (cursor.moveToNext());
        }
        // return contact list
        return projectList;
    }



    public List<DbResponseWork> displayWork() {
        List<DbResponseWork> workList = new ArrayList<DbResponseWork>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + WORK_EXP_TBL;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                DbResponseWork work = new DbResponseWork();
                //work.set_id_exp(cursor.getString(0));
                work.set_designation(cursor.getString(0));
                work.set_organization(cursor.getString(1));
                work.set_start_date_we(cursor.getString(2));
                work.set_end_date_we(cursor.getString(3));
                work.set_role(cursor.getString(4));


                // Adding contact to list
                workList.add(work);

            } while (cursor.moveToNext());
        }
        // return contact list
        return workList;
    }
}


