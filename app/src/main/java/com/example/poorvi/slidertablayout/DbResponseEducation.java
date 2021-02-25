package com.example.poorvi.slidertablayout;

/**
 * Created by Poorvi on 08-11-2017.
 */

public class DbResponseEducation {
    String _id;
    String _course_name;
    String _institute_name;
    String _start_date_et;
    String _end_date_et;
    String _percentage_Cgpa;
    String _add_other_information;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_start_date_et() {
        return _start_date_et;
    }

    public void set_start_date_et(String _start_date_et) {
        this._start_date_et = _start_date_et;
    }

    public String get_end_date_et() {
        return _end_date_et;
    }

    public void set_end_date_et(String _end_date_et) {
        this._end_date_et = _end_date_et;
    }


    public String get_course_name() {
        return _course_name;
    }

    public void set_course_name(String _course_name) {
        this._course_name = _course_name;
    }

    public String get_institute_name() {
        return _institute_name;
    }

    public void set_institute_name(String _institute_name) {
        this._institute_name = _institute_name;
    }

    public String get_percentage_Cgpa() {
        return _percentage_Cgpa;
    }

    public void set_percentage_Cgpa(String _percentage_Cgpa) {
        this._percentage_Cgpa = _percentage_Cgpa;
    }

    public String get_add_other_information() {
        return _add_other_information;
    }

    public void set_add_other_information(String _add_other_information) {
        this._add_other_information = _add_other_information;
    }
}
